package utils;

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

public class Web3Utils {

    private static Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/0be11186c2cb444482e8f0ab666cc1fc"));
    private static Credentials credentials = Credentials.create("a19c85dc8d02dc778233fea6f3d50df369c149026b1abf0dcb310fef9189fd1e");

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
                "0x5bbC9F0b57acF06ED60758b09Eb372204dCe8fBd", DefaultBlockParameterName.LATEST).sendAsync().get();
        BigInteger nonce = ethGetTransactionCount.getTransactionCount();

        RawTransaction transaction = RawTransaction.createTransaction(nonce, gasprice, gaslimit, address, BigInteger.valueOf(0), hash);

        byte[] signedMessage = TransactionEncoder.signMessage(transaction, credentials);
        String hexValue = Numeric.toHexString(signedMessage);
        EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).send();
        web3.shutdown();
        return ethSendTransaction.getTransactionHash();

    }

    public static boolean verifyAssertion(String hashBlockchain, String hash) throws IOException {
        Transaction tx = web3.ethGetTransactionByHash(hashBlockchain).send().getTransaction().get();
        return tx.getInput().equals(hash);
    }

    public static boolean verifyOwner(String hashBlockchain, String hash, String address) throws IOException {

        Transaction tx = web3.ethGetTransactionByHash(hashBlockchain).send().getTransaction().get();
        return tx.getInput().equals(hash) && tx.getFrom().equalsIgnoreCase(address);
    }
}