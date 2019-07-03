package utils;

import contract.CheckAssertion;
import io.reactivex.disposables.Disposable;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertFalse;

public class Web3Utils {

    private static Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/0be11186c2cb444482e8f0ab666cc1fc"));
    private static Credentials credentials = Credentials.create("a19c85dc8d02dc778233fea6f3d50df369c149026b1abf0dcb310fef9189fd1e");
    private static final String CONTRACT_ADDRESS = "0xe7735d18d09573578a42d79559be4bdf48ef4fab";//"0x81A595E19dD37B2e69C0cd6bff5114341BfB6B8f";
    private static final String MYADDRESS = "0x8fa7173202d86C746bd884C9f116E356600c6b0E";

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
        BigInteger gasprice = BigInteger.ZERO;
        BigInteger gaslimit = BigInteger.valueOf(300000);

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
            CheckAssertion contract = CheckAssertion.load(CONTRACT_ADDRESS, web3, credentials, BigInteger.valueOf(0), BigInteger.valueOf(300000));
            TransactionReceipt result = contract.check(hashBlockchain, hash).send();
            Disposable subscription = web3.blockFlowable(false).subscribe(block -> {
                System.out.println("Sweet, block number " + block.getBlock().getNumber()
                        + " has just been created");
            }, Throwable::printStackTrace);

            TimeUnit.MINUTES.sleep(2);
            subscription.dispose();
            return true;
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