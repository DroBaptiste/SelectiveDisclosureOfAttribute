package contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.3.0.
 */
public class CheckAssertion extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506101de806100206000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c8063725dbc4014610030575b600080fd5b61015d6004803603604081101561004657600080fd5b81019060208101813564010000000081111561006157600080fd5b82018360208201111561007357600080fd5b8035906020019184600183028401116401000000008311171561009557600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092959493602081019350359150506401000000008111156100e857600080fd5b8201836020820111156100fa57600080fd5b8035906020019184600183028401116401000000008311171561011c57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610171945050505050565b604080519115158252519081900360200190f35b604080516001815290516000917f0b3bdb70bcb1393d4319be3261bd6ab95e2ea1665e718029d24cecca39e84ccc919081900360200190a15060019291505056fea165627a7a72305820121e6861e942ae80dfe9326e5cf94c0185819777f6653c1348ab20777d7a95e30029";

    public static final String FUNC_CHECK = "check";

    public static final Event RESULT_EVENT = new Event("Result", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
    ;

    @Deprecated
    protected CheckAssertion(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CheckAssertion(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CheckAssertion(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CheckAssertion(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> check(String url, String hash) {
        final Function function = new Function(
                FUNC_CHECK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(url), 
                new org.web3j.abi.datatypes.Utf8String(hash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<ResultEventResponse> getResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESULT_EVENT, transactionReceipt);
        ArrayList<ResultEventResponse> responses = new ArrayList<ResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ResultEventResponse typedResponse = new ResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.Result = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ResultEventResponse> resultEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ResultEventResponse>() {
            @Override
            public ResultEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RESULT_EVENT, log);
                ResultEventResponse typedResponse = new ResultEventResponse();
                typedResponse.log = log;
                typedResponse.Result = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ResultEventResponse> resultEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RESULT_EVENT));
        return resultEventFlowable(filter);
    }

    @Deprecated
    public static CheckAssertion load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CheckAssertion(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CheckAssertion load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CheckAssertion(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CheckAssertion load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CheckAssertion(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CheckAssertion load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CheckAssertion(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CheckAssertion> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CheckAssertion.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CheckAssertion> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CheckAssertion.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CheckAssertion> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CheckAssertion.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CheckAssertion> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CheckAssertion.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class ResultEventResponse {
        public Log log;

        public Boolean Result;
    }
}
