package utils;

import contract.CheckAssertion;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertFalse;

public class Web3Utils {

    private static Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/0be11186c2cb444482e8f0ab666cc1fc"));
    private static Credentials credentials = Credentials.create("a19c85dc8d02dc778233fea6f3d50df369c149026b1abf0dcb310fef9189fd1e");
    private static final String CONTRACT_ADDRESS = "0xe7735d18d09573578a42d79559be4bdf48ef4fab";//"0x81A595E19dD37B2e69C0cd6bff5114341BfB6B8f";
    private static final String MYADDRESS = "0x5bbC9F0b57acF06ED60758b09Eb372204dCe8fBd";

    public  BigInteger getBalance(String address) throws IOException, ExecutionException, InterruptedException {
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        System.out.println(clientVersion);
        EthGetBalance ethGetBalance;
        ethGetBalance = web3
                .ethGetBalance(address, DefaultBlockParameterName.LATEST)
                .sendAsync()
                .get();
        return ethGetBalance.getBalance();
    }

    public static String doTransaction(String address, String hash) throws Exception {
        BigInteger gasprice = BigInteger.valueOf(100000);
        BigInteger gaslimit = BigInteger.valueOf(100000);

        EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(
                MYADDRESS, DefaultBlockParameterName.LATEST).sendAsync().get();
        BigInteger nonce = ethGetTransactionCount.getTransactionCount();

        RawTransaction transaction = RawTransaction.createTransaction(nonce, gasprice, gaslimit, address, BigInteger.valueOf(0), hash);

        byte[] signedMessage = TransactionEncoder.signMessage(transaction, credentials);
        String hexValue = Numeric.toHexString(signedMessage);
        EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).send();
        web3.shutdown();
        return ethSendTransaction.getTransactionHash();

    }

    public static boolean verifyAssertion(String hashBlockchain, String hash) throws Exception {
        try {
            CheckAssertion contract = CheckAssertion.load(CONTRACT_ADDRESS, web3, credentials, BigInteger.valueOf(1000000), BigInteger.valueOf(1000000));
            TransactionReceipt result = contract.check(hashBlockchain, hash).send();
            return result.getLogs().get(0).getData().endsWith("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean verifyOwner(String hashBlockchain, String hash, String address) throws IOException {

        org.web3j.protocol.core.methods.response.Transaction tx = web3.ethGetTransactionByHash(hashBlockchain).send().getTransaction().get();
        return tx.getInput().equals(hash) && tx.getFrom().equalsIgnoreCase(address);
    }
}