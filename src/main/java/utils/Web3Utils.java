package utils;

import contract.VerificationContract;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public class Web3Utils {

    private static Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/0be11186c2cb444482e8f0ab666cc1fc"));
    private static Credentials credentials = Credentials.create("cd9d8a491ec83a93bb41de04bebddfc494774e044ba77b7df225f938bb0d495c");
    private static final String CONTRACT_ADDRESS = "0x27e4bec28acca810029d68050a17a5f3713c819b";
    private static final String MYADDRESS = "0x8fa7173202d86C746bd884C9f116E356600c6b0E";
    private static BigInteger GAS_PRICE = BigInteger.valueOf(300000);
    private static BigInteger GAS_LIMIT = BigInteger.valueOf(300000);

    public static String indexHash(String hash) throws Exception {

        VerificationContract contract = VerificationContract.load(CONTRACT_ADDRESS, web3, credentials, GAS_PRICE, GAS_LIMIT);
        TransactionReceipt result = contract.indexToken(Numeric.hexStringToByteArray(hash)).send();
        String token = result.getLogs().get(0).getData();
        return token;
    }

    public static boolean verifyAssertion(String token, String url) throws Exception {

            VerificationContract contract = VerificationContract.load(CONTRACT_ADDRESS, web3, credentials, GAS_PRICE, GAS_LIMIT);
            TransactionReceipt result = contract.queryProvable(Numeric.hexStringToByteArray(token), url, BigInteger.ZERO).send();
            String id = result.getLogs().get(2).getData();
            int answer = 0;
            while (answer == 0) {
                TimeUnit.SECONDS.sleep(5);
                result = contract.getResult(Numeric.hexStringToByteArray(id)).send();
                String str = result.getLogs().get(0).getData();
                answer = Integer.valueOf(str.substring(str.length()-1));
            }
            return answer == 1;
    }

    public static boolean verifyOwner(String hashBlockchain, String hash, String address) throws IOException {

        org.web3j.protocol.core.methods.response.Transaction tx = web3.ethGetTransactionByHash(hashBlockchain).send().getTransaction().get();
        return tx.getInput().equals(hash) && tx.getFrom().equalsIgnoreCase(address);
    }
}