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
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public class Web3Utils {
    public static BigInteger getBalance(String address) throws IOException, ExecutionException, InterruptedException {
        Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/e7f83aeaafd14cb797f74930d2ec4695"));
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
        BigInteger gasprice = BigInteger.valueOf(30000);
        BigInteger gaslimit = BigInteger.valueOf(30000);

        Credentials credentials = Credentials.create("cd9d8a491ec83a93bb41de04bebddfc494774e044ba77b7df225f938bb0d495c");

        Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/0be11186c2cb444482e8f0ab666cc1fc"));

        EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(
                address, DefaultBlockParameterName.LATEST).sendAsync().get();
        BigInteger nonce = ethGetTransactionCount.getTransactionCount();

        RawTransaction transaction = RawTransaction.createTransaction(nonce, gasprice, gaslimit, address, BigInteger.valueOf(0), hash);

        byte[] signedMessage = TransactionEncoder.signMessage(transaction, credentials);
        String hexValue = Numeric.toHexString(signedMessage);
        EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).send();

        return ethSendTransaction.getTransactionHash();

    }

    public static boolean verifyAssertion(String hashBlockchain, String hash) throws IOException {
        Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/0be11186c2cb444482e8f0ab666cc1fc"));
        Optional<Transaction> tx = web3.ethGetTransactionByHash(hashBlockchain).send().getTransaction();
        return tx.map(transaction -> transaction.getInput().equals(hash)).orElse(false);
    }

    public static boolean verifyOwner(String hashBlockchain, String hash, String address) throws IOException {
        Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/0be11186c2cb444482e8f0ab666cc1fc"));
        Transaction tx = web3.ethGetTransactionByHash(hashBlockchain).send().getTransaction().get();
        return tx.getInput().equals(hash) && tx.getFrom().equalsIgnoreCase(address) ;
    }

    
}