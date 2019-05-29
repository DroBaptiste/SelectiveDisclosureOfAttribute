package Utils;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;
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
}
