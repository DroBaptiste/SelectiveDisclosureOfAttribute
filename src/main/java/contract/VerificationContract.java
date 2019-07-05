package contract;

import io.reactivex.Flowable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.3.0.
 */
public class VerificationContract extends Contract {
    private static final String BINARY = "6080604081905260208152601960a0527f436f6e7374727563746f722077617320696e697469617465640000000000000060c0527f11a3fca63f87bd67d7f9f72b744acc8be2193705e7a734ac3a773d35d259e87b90606090a1611808806100686000396000f3fe60806040526004361061004a5760003560e01c80630d0da09d1461004f57806327dc297e146100fc57806338bbfa50146101b4578063add4c784146102f1578063ef70cf031461032d575b600080fd5b6100fa6004803603604081101561006557600080fd5b81359190810190604081016020820135600160201b81111561008657600080fd5b82018360208201111561009857600080fd5b803590602001918460018302840111600160201b831117156100b957600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610357945050505050565b005b34801561010857600080fd5b506100fa6004803603604081101561011f57600080fd5b81359190810190604081016020820135600160201b81111561014057600080fd5b82018360208201111561015257600080fd5b803590602001918460018302840111600160201b8311171561017357600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610528945050505050565b3480156101c057600080fd5b506100fa600480360360608110156101d757600080fd5b81359190810190604081016020820135600160201b8111156101f857600080fd5b82018360208201111561020a57600080fd5b803590602001918460018302840111600160201b8311171561022b57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561027d57600080fd5b82018360208201111561028f57600080fd5b803590602001918460018302840111600160201b831117156102b057600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610670945050505050565b3480156102fd57600080fd5b5061031b6004803603602081101561031457600080fd5b50356106a1565b60408051918252519081900360200190f35b34801561033957600080fd5b506100fa6004803603602081101561035057600080fd5b50356106f8565b306001600160a01b031631610389604051806040016040528060038152602001600160ea1b62155493028152506107ed565b11156103df577fc4dc360d0a9c0677a3379ae0a3d81e887f761e65fdf3d7e00859d1bcd3c4738960405180806020018281038252604b815260200180611792604b913960600191505060405180910390a1610524565b6060610443604051806040016040528060078152602001600160cb1b660c4d2dcc2e4f2502815250836040518060400160405280601081526020017f292e736c69636528302c31303030302900000000000000000000000000000000815250610a3c565b90507fc4dc360d0a9c0677a3379ae0a3d81e887f761e65fdf3d7e00859d1bcd3c4738960405180806020018281038252603581526020018061175d6035913960400191505060405180910390a160006104be604051806040016040528060038152602001600160ea1b621554930281525083622dc6c0610a73565b60008581526005602090815260408083205484845260068352818420556007825291829020805460ff19166001179055815183815291519293507ff0f6609f1ed6d3d95ae7015dc934fd8d0181b4682ccec3af17b3bf1dff9bdd9f92918290030190a150505b5050565b610530610e41565b6001600160a01b0316336001600160a01b03161461054d57600080fd5b60008281526007602052604090205460ff16151560011461056d57600080fd5b8060006105798261102b565b6000858152600660205260409020549091508114156105a9576000848152600860205260409020600190556105bc565b6000848152600860205260409020600290555b7fec115ab529a6f2b28c798319fb509919401c93565332cdcf11caee6d4966a303836040518080602001828103825283818151815260200191508051906020019080838360005b8381101561061b578181015183820152602001610603565b50505050905090810190601f1680156106485780820380516001836020036101000a031916815260200191505b509250505060405180910390a15050506000908152600760205260409020805460ff19169055565b5050600080805260036020527f3617319a054d772f909f7c479a2cebe5066e836a939412e32403c99029b92eff5550565b600081815260086020908152604080832054815190815290517f19d1d22d5770ffa11e0d7210395e92b4407c00d35d6eba5cacbcb1dbccdf38fe929181900390910190a15060009081526008602052604090205490565b6000600242604051602001808281526020019150506040516020818303038152906040526040518082805190602001908083835b6020831061074b5780518252601f19909201916020918201910161072c565b51815160209384036101000a60001901801990921691161790526040519190930194509192505080830381855afa15801561078a573d6000803e3d6000fd5b5050506040513d602081101561079f57600080fd5b5051600081815260056020908152604091829020859055815183815291519293507f6454a4364797d82ce8cc1d55f973e70ad1b995dccb7227e5987382c697f22f5992918290030190a15050565b6001546000906001600160a01b0316158061081a5750600154610818906001600160a01b0316611123565b155b1561082b576108296000611127565b505b600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b15801561087b57600080fd5b505af115801561088f573d6000803e3d6000fd5b505050506040513d60208110156108a557600080fd5b50516000546001600160a01b0390811691161461095857600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b15801561090c57600080fd5b505af1158015610920573d6000803e3d6000fd5b505050506040513d602081101561093657600080fd5b5051600080546001600160a01b0319166001600160a01b039092169190911790555b60008054604051600160e01b63524f38890281526020600482018181528651602484015286516001600160a01b039094169463524f3889948894929384936044019290860191908190849084905b838110156109be5781810151838201526020016109a6565b50505050905090810190601f1680156109eb5780820380516001836020036101000a031916815260200191505b5092505050602060405180830381600087803b158015610a0a57600080fd5b505af1158015610a1e573d6000803e3d6000fd5b505050506040513d6020811015610a3457600080fd5b505192915050565b6060610a698484846040518060200160405280600081525060405180602001604052806000815250611137565b90505b9392505050565b6001546000906001600160a01b03161580610aa05750600154610a9e906001600160a01b0316611123565b155b15610ab157610aaf6000611127565b505b600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b158015610b0157600080fd5b505af1158015610b15573d6000803e3d6000fd5b505050506040513d6020811015610b2b57600080fd5b50516000546001600160a01b03908116911614610bde57600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b158015610b9257600080fd5b505af1158015610ba6573d6000803e3d6000fd5b505050506040513d6020811015610bbc57600080fd5b5051600080546001600160a01b0319166001600160a01b039092169190911790555b6000805460408051600160e21b630bbceb3302815260248101869052600481019182528751604482015287516001600160a01b0390931692632ef3accc928992889282916064019060208601908083838c5b83811015610c48578181015183820152602001610c30565b50505050905090810190601f168015610c755780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b158015610c9557600080fd5b505af1158015610ca9573d6000803e3d6000fd5b505050506040513d6020811015610cbf57600080fd5b50519050670de0b6b3a76400003a840201811115610ce1575060009050610a6c565b60008054604051600160e01b63c51be90f02815260048101838152606482018790526080602483019081528951608484015289516001600160a01b039094169463c51be90f94879491938c938c938c93604482019160a4019060208801908083838c5b83811015610d5c578181015183820152602001610d44565b50505050905090810190601f168015610d895780820380516001836020036101000a031916815260200191505b50838103825285518152855160209182019187019080838360005b83811015610dbc578181015183820152602001610da4565b50505050905090810190601f168015610de95780820380516001836020036101000a031916815260200191505b5096505050505050506020604051808303818588803b158015610e0b57600080fd5b505af1158015610e1f573d6000803e3d6000fd5b50505050506040513d6020811015610e3657600080fd5b505195945050505050565b6001546000906001600160a01b03161580610e6e5750600154610e6c906001600160a01b0316611123565b155b15610e7f57610e7d6000611127565b505b600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b158015610ecf57600080fd5b505af1158015610ee3573d6000803e3d6000fd5b505050506040513d6020811015610ef957600080fd5b50516000546001600160a01b03908116911614610fac57600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b158015610f6057600080fd5b505af1158015610f74573d6000803e3d6000fd5b505050506040513d6020811015610f8a57600080fd5b5051600080546001600160a01b0319166001600160a01b039092169190911790555b6000809054906101000a90046001600160a01b03166001600160a01b031663c281d19e6040518163ffffffff1660e01b815260040160206040518083038186803b158015610ff957600080fd5b505afa15801561100d573d6000803e3d6000fd5b505050506040513d602081101561102357600080fd5b505190505b90565b6000806002836040516020018082805190602001908083835b602083106110635780518252601f199092019160209182019101611044565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040516020818303038152906040526040518082805190602001908083835b602083106110c65780518252601f1990920191602091820191016110a7565b51815160209384036101000a60001901801990921691161790526040519190930194509192505080830381855afa158015611105573d6000803e3d6000fd5b5050506040513d602081101561111a57600080fd5b50519392505050565b3b90565b600061113161134b565b92915050565b6060808690506060869050606086905060608690506060869050606081518351855187518951010101016040519080825280601f01601f19166020018201604052801561118b576020820181803883390190505b509050806000805b88518110156111e4578881815181106111a857fe5b602001015160f81c60f81b8383806001019450815181106111c557fe5b60200101906001600160f81b031916908160001a905350600101611193565b5060005b8751811015611239578781815181106111fd57fe5b602001015160f81c60f81b83838060010194508151811061121a57fe5b60200101906001600160f81b031916908160001a9053506001016111e8565b5060005b865181101561128e5786818151811061125257fe5b602001015160f81c60f81b83838060010194508151811061126f57fe5b60200101906001600160f81b031916908160001a90535060010161123d565b5060005b85518110156112e3578581815181106112a757fe5b602001015160f81c60f81b8383806001019450815181106112c457fe5b60200101906001600160f81b031916908160001a905350600101611292565b5060005b8451811015611338578481815181106112fc57fe5b602001015160f81c60f81b83838060010194508151811061131957fe5b60200101906001600160f81b031916908160001a9053506001016112e7565b50909d9c50505050505050505050505050565b60008061136b731d3b2638a7cc9f2cb3d298a3da7a90b67e5506ed611123565b11156113cd57600180546001600160a01b031916731d3b2638a7cc9f2cb3d298a3da7a90b67e5506ed17905560408051808201909152600b8152600160aa1b6a195d1a17db585a5b9b995d0260208201526113c5906116b6565b506001611028565b60006113ec73c03a2615d5efaf5f49f60b7bb6583eaec212fdf1611123565b111561145557600180546001600160a01b03191673c03a2615d5efaf5f49f60b7bb6583eaec212fdf117905560408051808201909152600c81527f6574685f726f707374656e33000000000000000000000000000000000000000060208201526113c5906116b6565b600061147473b7a07bcf2ba2f2703b24c0691b5278999c59ac7e611123565b11156114cc57600180546001600160a01b03191673b7a07bcf2ba2f2703b24c0691b5278999c59ac7e1790556040805180820190915260098152600160b91b6832ba342fb5b7bb30b70260208201526113c5906116b6565b60006114eb73146500cfd35b22e4a392fe0adc06de1a1368ed48611123565b111561154557600180546001600160a01b03191673146500cfd35b22e4a392fe0adc06de1a1368ed4817905560408051808201909152600b8152600160a81b6a6574685f72696e6b6562790260208201526113c5906116b6565b600061156473a2998efd205fb9d4b4963afb70778d6354ad3a41611123565b11156115bd57600180546001600160a01b03191673a2998efd205fb9d4b4963afb70778d6354ad3a4117905560408051808201909152600a8152600160b01b696574685f676f65726c690260208201526113c5906116b6565b60006115dc736f485c8bf6fc43ea212e93bbf8ce046c7f1cb475611123565b111561160e5750600180546001600160a01b031916736f485c8bf6fc43ea212e93bbf8ce046c7f1cb475178155611028565b600061162d7320e12a1f859b3feae5fb2a0a32c18f5a65555bbf611123565b111561165f5750600180546001600160a01b0319167320e12a1f859b3feae5fb2a0a32c18f5a65555bbf178155611028565b600061167e7351efaf4c8b3c9afbd5ab9f4bbc82784ab6ef8faa611123565b11156116b05750600180546001600160a01b0319167351efaf4c8b3c9afbd5ab9f4bbc82784ab6ef8faa178155611028565b50600090565b8051610524906002906020840190828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061170557805160ff1916838001178555611732565b82800160010185558215611732579182015b82811115611732578251825591602001919060010190611717565b5061173e929150611742565b5090565b61102891905b8082111561173e576000815560010161174856fe4f7261636c697a65207175657279207761732073656e742c207374616e64696e6720627920666f722074686520616e737765722e2e4f7261636c697a6520717565727920776173204e4f542073656e742c20706c656173652061646420736f6d652045544820746f20636f76657220666f722074686520717565727920666565a165627a7a723058207a7e5874c5c5568d695221693fcee513d4cb5a2c5635fe934b140954b1e689400029";

    public static final String FUNC_QUERYPROVABLE = "queryProvable";

    public static final String FUNC___CALLBACK = "__callback";

    public static final String FUNC_GETRESULT = "getResult";

    public static final String FUNC_INDEXTOKEN = "indexToken";

    public static final Event LOGCONSTRUCTORINITIATED_EVENT = new Event("LogConstructorInitiated",
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event LOGVERIFICATION_EVENT = new Event("LogVerification",
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event LOGNEWPROVABLEQUERY_EVENT = new Event("LogNewProvableQuery",
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event ASSERTIONRESULT_EVENT = new Event("AssertionResult",
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event TOKENINDEXED_EVENT = new Event("TokenIndexed",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
    ;

    public static final Event QUERYINITIATED_EVENT = new Event("queryInitiated",
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
    ;

    @Deprecated
    protected VerificationContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected VerificationContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected VerificationContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected VerificationContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> queryProvable(byte[] _token, String _url, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_QUERYPROVABLE,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_token),
                        new org.web3j.abi.datatypes.Utf8String(_url)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> __callback(byte[] myid, String result) {
        final Function function = new Function(
                FUNC___CALLBACK,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(myid),
                        new org.web3j.abi.datatypes.Utf8String(result)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> __callback(byte[] _myid, String _result, byte[] _proof) {
        final Function function = new Function(
                FUNC___CALLBACK,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_myid),
                        new org.web3j.abi.datatypes.Utf8String(_result),
                        new org.web3j.abi.datatypes.DynamicBytes(_proof)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getResult(byte[] id) {
        final Function function = new Function(
                FUNC_GETRESULT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> indexToken(byte[] _hash) {
        final Function function = new Function(
                FUNC_INDEXTOKEN,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_hash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<LogConstructorInitiatedEventResponse> getLogConstructorInitiatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGCONSTRUCTORINITIATED_EVENT, transactionReceipt);
        ArrayList<LogConstructorInitiatedEventResponse> responses = new ArrayList<LogConstructorInitiatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogConstructorInitiatedEventResponse typedResponse = new LogConstructorInitiatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.nextStep = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LogConstructorInitiatedEventResponse> logConstructorInitiatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, LogConstructorInitiatedEventResponse>() {
            @Override
            public LogConstructorInitiatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGCONSTRUCTORINITIATED_EVENT, log);
                LogConstructorInitiatedEventResponse typedResponse = new LogConstructorInitiatedEventResponse();
                typedResponse.log = log;
                typedResponse.nextStep = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LogConstructorInitiatedEventResponse> logConstructorInitiatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGCONSTRUCTORINITIATED_EVENT));
        return logConstructorInitiatedEventFlowable(filter);
    }

    public List<LogVerificationEventResponse> getLogVerificationEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGVERIFICATION_EVENT, transactionReceipt);
        ArrayList<LogVerificationEventResponse> responses = new ArrayList<LogVerificationEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogVerificationEventResponse typedResponse = new LogVerificationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.saml = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LogVerificationEventResponse> logVerificationEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, LogVerificationEventResponse>() {
            @Override
            public LogVerificationEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGVERIFICATION_EVENT, log);
                LogVerificationEventResponse typedResponse = new LogVerificationEventResponse();
                typedResponse.log = log;
                typedResponse.saml = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LogVerificationEventResponse> logVerificationEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGVERIFICATION_EVENT));
        return logVerificationEventFlowable(filter);
    }

    public List<LogNewProvableQueryEventResponse> getLogNewProvableQueryEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGNEWPROVABLEQUERY_EVENT, transactionReceipt);
        ArrayList<LogNewProvableQueryEventResponse> responses = new ArrayList<LogNewProvableQueryEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogNewProvableQueryEventResponse typedResponse = new LogNewProvableQueryEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.description = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LogNewProvableQueryEventResponse> logNewProvableQueryEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, LogNewProvableQueryEventResponse>() {
            @Override
            public LogNewProvableQueryEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGNEWPROVABLEQUERY_EVENT, log);
                LogNewProvableQueryEventResponse typedResponse = new LogNewProvableQueryEventResponse();
                typedResponse.log = log;
                typedResponse.description = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LogNewProvableQueryEventResponse> logNewProvableQueryEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGNEWPROVABLEQUERY_EVENT));
        return logNewProvableQueryEventFlowable(filter);
    }

    public List<AssertionResultEventResponse> getAssertionResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ASSERTIONRESULT_EVENT, transactionReceipt);
        ArrayList<AssertionResultEventResponse> responses = new ArrayList<AssertionResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AssertionResultEventResponse typedResponse = new AssertionResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.answer = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AssertionResultEventResponse> assertionResultEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, AssertionResultEventResponse>() {
            @Override
            public AssertionResultEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ASSERTIONRESULT_EVENT, log);
                AssertionResultEventResponse typedResponse = new AssertionResultEventResponse();
                typedResponse.log = log;
                typedResponse.answer = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AssertionResultEventResponse> assertionResultEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ASSERTIONRESULT_EVENT));
        return assertionResultEventFlowable(filter);
    }

    public List<TokenIndexedEventResponse> getTokenIndexedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TOKENINDEXED_EVENT, transactionReceipt);
        ArrayList<TokenIndexedEventResponse> responses = new ArrayList<TokenIndexedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TokenIndexedEventResponse typedResponse = new TokenIndexedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.token = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TokenIndexedEventResponse> tokenIndexedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TokenIndexedEventResponse>() {
            @Override
            public TokenIndexedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TOKENINDEXED_EVENT, log);
                TokenIndexedEventResponse typedResponse = new TokenIndexedEventResponse();
                typedResponse.log = log;
                typedResponse.token = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TokenIndexedEventResponse> tokenIndexedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TOKENINDEXED_EVENT));
        return tokenIndexedEventFlowable(filter);
    }

    public List<QueryInitiatedEventResponse> getQueryInitiatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(QUERYINITIATED_EVENT, transactionReceipt);
        ArrayList<QueryInitiatedEventResponse> responses = new ArrayList<QueryInitiatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            QueryInitiatedEventResponse typedResponse = new QueryInitiatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<QueryInitiatedEventResponse> queryInitiatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, QueryInitiatedEventResponse>() {
            @Override
            public QueryInitiatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(QUERYINITIATED_EVENT, log);
                QueryInitiatedEventResponse typedResponse = new QueryInitiatedEventResponse();
                typedResponse.log = log;
                typedResponse.id = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<QueryInitiatedEventResponse> queryInitiatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(QUERYINITIATED_EVENT));
        return queryInitiatedEventFlowable(filter);
    }

    @Deprecated
    public static VerificationContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new VerificationContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static VerificationContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new VerificationContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static VerificationContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new VerificationContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static VerificationContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new VerificationContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<VerificationContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(VerificationContract.class, web3j, credentials, contractGasProvider, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<VerificationContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(VerificationContract.class, web3j, transactionManager, contractGasProvider, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<VerificationContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(VerificationContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<VerificationContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(VerificationContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static class LogConstructorInitiatedEventResponse {
        public Log log;

        public String nextStep;
    }

    public static class LogVerificationEventResponse {
        public Log log;

        public String saml;
    }

    public static class LogNewProvableQueryEventResponse {
        public Log log;

        public String description;
    }

    public static class AssertionResultEventResponse {
        public Log log;

        public BigInteger answer;
    }

    public static class TokenIndexedEventResponse {
        public Log log;

        public byte[] token;
    }

    public static class QueryInitiatedEventResponse {
        public Log log;

        public byte[] id;
    }
}