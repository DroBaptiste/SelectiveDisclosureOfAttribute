package contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    private static final String BINARY = "608060408190524260095560208152601960a0527f436f6e7374727563746f722077617320696e697469617465640000000000000060c0527f11a3fca63f87bd67d7f9f72b744acc8be2193705e7a734ac3a773d35d259e87b90606090a16118428061006c6000396000f3fe6080604052600436106100555760003560e01c80631b9265b81461005a57806327dc297e1461006457806338bbfa501461011c57806379ecb47114610259578063845f349a14610283578063d1dccbdb146102bf575b600080fd5b61006261036a565b005b34801561007057600080fd5b506100626004803603604081101561008757600080fd5b81359190810190604081016020820135600160201b8111156100a857600080fd5b8201836020820111156100ba57600080fd5b803590602001918460018302840111600160201b831117156100db57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610395945050505050565b34801561012857600080fd5b506100626004803603606081101561013f57600080fd5b81359190810190604081016020820135600160201b81111561016057600080fd5b82018360208201111561017257600080fd5b803590602001918460018302840111600160201b8311171561019357600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156101e557600080fd5b8201836020820111156101f757600080fd5b803590602001918460018302840111600160201b8311171561021857600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506105c6945050505050565b34801561026557600080fd5b506100626004803603602081101561027c57600080fd5b50356105f7565b34801561028f57600080fd5b506102ad600480360360208110156102a657600080fd5b50356106f7565b60408051918252519081900360200190f35b610062600480360360408110156102d557600080fd5b81359190810190604081016020820135600160201b8111156102f657600080fd5b82018360208201111561030857600080fd5b803590602001918460018302840111600160201b8311171561032957600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955061074e945050505050565b6040517fc5d54e43523da46c617f42df5251baed8a23627549ceb5f520fea78bf6da6f8f90600090a1565b61039d61091f565b6001600160a01b0316336001600160a01b0316146103ba57600080fd5b60008281526007602052604090205460ff1615156001146103da57600080fd5b606081905060006002826040516020018082805190602001908083835b602083106104165780518252601f1990920191602091820191016103f7565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040516020818303038152906040526040518082805190602001908083835b602083106104795780518252601f19909201916020918201910161045a565b51815160209384036101000a60001901801990921691161790526040519190930194509192505080830381855afa1580156104b8573d6000803e3d6000fd5b5050506040513d60208110156104cd57600080fd5b50516000858152600660205260409020549091508114156104ff57600084815260086020526040902060019055610512565b6000848152600860205260409020600290555b7fec115ab529a6f2b28c798319fb509919401c93565332cdcf11caee6d4966a303836040518080602001828103825283818151815260200191508051906020019080838360005b83811015610571578181015183820152602001610559565b50505050905090810190601f16801561059e5780820380516001836020036101000a031916815260200191505b509250505060405180910390a15050506000908152600760205260409020805460ff19169055565b5050600080805260036020527f3617319a054d772f909f7c479a2cebe5066e836a939412e32403c99029b92eff5550565b60006002600954604051602001808281526020019150506040516020818303038152906040526040518082805190602001908083835b6020831061064c5780518252601f19909201916020918201910161062d565b51815160209384036101000a60001901801990921691161790526040519190930194509192505080830381855afa15801561068b573d6000803e3d6000fd5b5050506040513d60208110156106a057600080fd5b5051600980546001019055600081815260056020908152604091829020859055815183815291519293507f6454a4364797d82ce8cc1d55f973e70ad1b995dccb7227e5987382c697f22f5992918290030190a15050565b600081815260086020908152604080832054815190815290517f19d1d22d5770ffa11e0d7210395e92b4407c00d35d6eba5cacbcb1dbccdf38fe929181900390910190a15060009081526008602052604090205490565b306001600160a01b031631610780604051806040016040528060038152602001600160ea1b6215549302815250610b09565b11156107d6577fc4dc360d0a9c0677a3379ae0a3d81e887f761e65fdf3d7e00859d1bcd3c4738960405180806020018281038252604b8152602001806117cc604b913960600191505060405180910390a161091b565b606061083a604051806040016040528060078152602001600160cb1b660c4d2dcc2e4f2502815250836040518060400160405280601081526020017f292e736c69636528302c31303030302900000000000000000000000000000000815250610d58565b90507fc4dc360d0a9c0677a3379ae0a3d81e887f761e65fdf3d7e00859d1bcd3c473896040518080602001828103825260358152602001806117976035913960400191505060405180910390a160006108b5604051806040016040528060038152602001600160ea1b621554930281525083622dc6c0610d8f565b60008581526005602090815260408083205484845260068352818420556007825291829020805460ff19166001179055815183815291519293507ff0f6609f1ed6d3d95ae7015dc934fd8d0181b4682ccec3af17b3bf1dff9bdd9f92918290030190a150505b5050565b6001546000906001600160a01b0316158061094c575060015461094a906001600160a01b031661115d565b155b1561095d5761095b6000611161565b505b600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b1580156109ad57600080fd5b505af11580156109c1573d6000803e3d6000fd5b505050506040513d60208110156109d757600080fd5b50516000546001600160a01b03908116911614610a8a57600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b158015610a3e57600080fd5b505af1158015610a52573d6000803e3d6000fd5b505050506040513d6020811015610a6857600080fd5b5051600080546001600160a01b0319166001600160a01b039092169190911790555b6000809054906101000a90046001600160a01b03166001600160a01b031663c281d19e6040518163ffffffff1660e01b815260040160206040518083038186803b158015610ad757600080fd5b505afa158015610aeb573d6000803e3d6000fd5b505050506040513d6020811015610b0157600080fd5b505190505b90565b6001546000906001600160a01b03161580610b365750600154610b34906001600160a01b031661115d565b155b15610b4757610b456000611161565b505b600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b158015610b9757600080fd5b505af1158015610bab573d6000803e3d6000fd5b505050506040513d6020811015610bc157600080fd5b50516000546001600160a01b03908116911614610c7457600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b158015610c2857600080fd5b505af1158015610c3c573d6000803e3d6000fd5b505050506040513d6020811015610c5257600080fd5b5051600080546001600160a01b0319166001600160a01b039092169190911790555b60008054604051600160e01b63524f38890281526020600482018181528651602484015286516001600160a01b039094169463524f3889948894929384936044019290860191908190849084905b83811015610cda578181015183820152602001610cc2565b50505050905090810190601f168015610d075780820380516001836020036101000a031916815260200191505b5092505050602060405180830381600087803b158015610d2657600080fd5b505af1158015610d3a573d6000803e3d6000fd5b505050506040513d6020811015610d5057600080fd5b505192915050565b6060610d858484846040518060200160405280600081525060405180602001604052806000815250611171565b90505b9392505050565b6001546000906001600160a01b03161580610dbc5750600154610dba906001600160a01b031661115d565b155b15610dcd57610dcb6000611161565b505b600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b158015610e1d57600080fd5b505af1158015610e31573d6000803e3d6000fd5b505050506040513d6020811015610e4757600080fd5b50516000546001600160a01b03908116911614610efa57600160009054906101000a90046001600160a01b03166001600160a01b03166338cc48316040518163ffffffff1660e01b8152600401602060405180830381600087803b158015610eae57600080fd5b505af1158015610ec2573d6000803e3d6000fd5b505050506040513d6020811015610ed857600080fd5b5051600080546001600160a01b0319166001600160a01b039092169190911790555b6000805460408051600160e21b630bbceb3302815260248101869052600481019182528751604482015287516001600160a01b0390931692632ef3accc928992889282916064019060208601908083838c5b83811015610f64578181015183820152602001610f4c565b50505050905090810190601f168015610f915780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b158015610fb157600080fd5b505af1158015610fc5573d6000803e3d6000fd5b505050506040513d6020811015610fdb57600080fd5b50519050670de0b6b3a76400003a840201811115610ffd575060009050610d88565b60008054604051600160e01b63c51be90f02815260048101838152606482018790526080602483019081528951608484015289516001600160a01b039094169463c51be90f94879491938c938c938c93604482019160a4019060208801908083838c5b83811015611078578181015183820152602001611060565b50505050905090810190601f1680156110a55780820380516001836020036101000a031916815260200191505b50838103825285518152855160209182019187019080838360005b838110156110d85781810151838201526020016110c0565b50505050905090810190601f1680156111055780820380516001836020036101000a031916815260200191505b5096505050505050506020604051808303818588803b15801561112757600080fd5b505af115801561113b573d6000803e3d6000fd5b50505050506040513d602081101561115257600080fd5b505195945050505050565b3b90565b600061116b611385565b92915050565b6060808690506060869050606086905060608690506060869050606081518351855187518951010101016040519080825280601f01601f1916602001820160405280156111c5576020820181803883390190505b509050806000805b885181101561121e578881815181106111e257fe5b602001015160f81c60f81b8383806001019450815181106111ff57fe5b60200101906001600160f81b031916908160001a9053506001016111cd565b5060005b87518110156112735787818151811061123757fe5b602001015160f81c60f81b83838060010194508151811061125457fe5b60200101906001600160f81b031916908160001a905350600101611222565b5060005b86518110156112c85786818151811061128c57fe5b602001015160f81c60f81b8383806001019450815181106112a957fe5b60200101906001600160f81b031916908160001a905350600101611277565b5060005b855181101561131d578581815181106112e157fe5b602001015160f81c60f81b8383806001019450815181106112fe57fe5b60200101906001600160f81b031916908160001a9053506001016112cc565b5060005b84518110156113725784818151811061133657fe5b602001015160f81c60f81b83838060010194508151811061135357fe5b60200101906001600160f81b031916908160001a905350600101611321565b50909d9c50505050505050505050505050565b6000806113a5731d3b2638a7cc9f2cb3d298a3da7a90b67e5506ed61115d565b111561140757600180546001600160a01b031916731d3b2638a7cc9f2cb3d298a3da7a90b67e5506ed17905560408051808201909152600b8152600160aa1b6a195d1a17db585a5b9b995d0260208201526113ff906116f0565b506001610b06565b600061142673c03a2615d5efaf5f49f60b7bb6583eaec212fdf161115d565b111561148f57600180546001600160a01b03191673c03a2615d5efaf5f49f60b7bb6583eaec212fdf117905560408051808201909152600c81527f6574685f726f707374656e33000000000000000000000000000000000000000060208201526113ff906116f0565b60006114ae73b7a07bcf2ba2f2703b24c0691b5278999c59ac7e61115d565b111561150657600180546001600160a01b03191673b7a07bcf2ba2f2703b24c0691b5278999c59ac7e1790556040805180820190915260098152600160b91b6832ba342fb5b7bb30b70260208201526113ff906116f0565b600061152573146500cfd35b22e4a392fe0adc06de1a1368ed4861115d565b111561157f57600180546001600160a01b03191673146500cfd35b22e4a392fe0adc06de1a1368ed4817905560408051808201909152600b8152600160a81b6a6574685f72696e6b6562790260208201526113ff906116f0565b600061159e73a2998efd205fb9d4b4963afb70778d6354ad3a4161115d565b11156115f757600180546001600160a01b03191673a2998efd205fb9d4b4963afb70778d6354ad3a4117905560408051808201909152600a8152600160b01b696574685f676f65726c690260208201526113ff906116f0565b6000611616736f485c8bf6fc43ea212e93bbf8ce046c7f1cb47561115d565b11156116485750600180546001600160a01b031916736f485c8bf6fc43ea212e93bbf8ce046c7f1cb475178155610b06565b60006116677320e12a1f859b3feae5fb2a0a32c18f5a65555bbf61115d565b11156116995750600180546001600160a01b0319167320e12a1f859b3feae5fb2a0a32c18f5a65555bbf178155610b06565b60006116b87351efaf4c8b3c9afbd5ab9f4bbc82784ab6ef8faa61115d565b11156116ea5750600180546001600160a01b0319167351efaf4c8b3c9afbd5ab9f4bbc82784ab6ef8faa178155610b06565b50600090565b805161091b906002906020840190828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061173f57805160ff191683800117855561176c565b8280016001018555821561176c579182015b8281111561176c578251825591602001919060010190611751565b5061177892915061177c565b5090565b610b0691905b80821115611778576000815560010161178256fe4f7261636c697a65207175657279207761732073656e742c207374616e64696e6720627920666f722074686520616e737765722e2e4f7261636c697a6520717565727920776173204e4f542073656e742c20706c656173652061646420736f6d652045544820746f20636f76657220666f722074686520717565727920666565a165627a7a723058204c8f9cfbdb50896958e044d90cb446da52e413ab6474d13062f9781f30af208c0029";

    public static final String FUNC_PAY = "pay";

    public static final String FUNC___CALLBACK = "__callback";

    public static final String FUNC_INDEXDIGEST = "indexDigest";

    public static final String FUNC_CHECKRESULT = "checkResult";

    public static final String FUNC_VERIFYASSERTION = "verifyAssertion";

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

    public static final Event TRANSACTIONMADE_EVENT = new Event("TransactionMade", 
            Arrays.<TypeReference<?>>asList());
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

    public RemoteCall<TransactionReceipt> pay(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_PAY, 
                Arrays.<Type>asList(), 
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

    public RemoteCall<TransactionReceipt> indexDigest(byte[] _digest) {
        final Function function = new Function(
                FUNC_INDEXDIGEST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_digest)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> checkResult(byte[] id) {
        final Function function = new Function(
                FUNC_CHECKRESULT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> verifyAssertion(byte[] _token, String _url, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_VERIFYASSERTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_token), 
                new org.web3j.abi.datatypes.Utf8String(_url)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
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

    public List<TransactionMadeEventResponse> getTransactionMadeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSACTIONMADE_EVENT, transactionReceipt);
        ArrayList<TransactionMadeEventResponse> responses = new ArrayList<TransactionMadeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransactionMadeEventResponse typedResponse = new TransactionMadeEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransactionMadeEventResponse> transactionMadeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TransactionMadeEventResponse>() {
            @Override
            public TransactionMadeEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSACTIONMADE_EVENT, log);
                TransactionMadeEventResponse typedResponse = new TransactionMadeEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Flowable<TransactionMadeEventResponse> transactionMadeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSACTIONMADE_EVENT));
        return transactionMadeEventFlowable(filter);
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

    public static class TransactionMadeEventResponse {
        public Log log;
    }
}
