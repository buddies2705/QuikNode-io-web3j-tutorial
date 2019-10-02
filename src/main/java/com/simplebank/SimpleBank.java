package com.simplebank;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
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
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class SimpleBank extends Contract {
    private static final String BINARY = "6080604052346801a055690d9db8000014610065576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602181526020018061031d6021913960400191505060405180910390fd5b600280546001600160a01b031916331790556000805460ff1916905561028d806100906000396000f3fe6080604052600436106100555760003560e01c8063138fbe711461005a5780632e1a7d4d146100815780638da5cb5b146100ab578063b69ef8a8146100dc578063d0e30db0146100f1578063e65f2a7e146100f9575b600080fd5b34801561006657600080fd5b5061006f61010e565b60408051918252519081900360200190f35b34801561008d57600080fd5b5061006f600480360360208110156100a457600080fd5b5035610113565b3480156100b757600080fd5b506100c061017f565b604080516001600160a01b039092168252519081900360200190f35b3480156100e857600080fd5b5061006f61018e565b61006f6101a1565b34801561010557600080fd5b5061006f610205565b303190565b33600090815260016020526040812054821161016a5733600081815260016020526040808220805486900390555184156108fc0291859190818181858888f19350505050158015610168573d6000803e3d6000fd5b505b50503360009081526001602052604090205490565b6002546001600160a01b031681565b3360009081526001602052604090205490565b336000818152600160209081526040808320805434908101909155815190815290519293927fa8126f7572bb1fdeae5b5aa9ec126438b91f658a07873f009d041ae690f3a193929181900390910190a2503360009081526001602052604090205490565b60008054600360ff9091161015610244576000805460ff198116600160ff928316810190921617825533825260205260409020678ac7230489e8000090555b50336000908152600160205260409020549056fea265627a7a723158204d27928c1ab7d0f7f05261d973a33e76d06517b2b9f4302e3d269b3f5f36211664736f6c634300050b0032333020657468657220696e697469616c2066756e64696e67207265717569726564";

    public static final String FUNC_DEPOSITSBALANCE = "depositsBalance";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_BALANCE = "balance";

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_ENROLL = "enroll";

    public static final Event LOGDEPOSITMADE_EVENT = new Event("LogDepositMade", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected SimpleBank(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SimpleBank(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SimpleBank(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SimpleBank(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> depositsBalance() {
        final Function function = new Function(FUNC_DEPOSITSBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw(BigInteger withdrawAmount) {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(withdrawAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> balance() {
        final Function function = new Function(FUNC_BALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> deposit(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_DEPOSIT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> enroll() {
        final Function function = new Function(
                FUNC_ENROLL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<LogDepositMadeEventResponse> getLogDepositMadeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGDEPOSITMADE_EVENT, transactionReceipt);
        ArrayList<LogDepositMadeEventResponse> responses = new ArrayList<LogDepositMadeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogDepositMadeEventResponse typedResponse = new LogDepositMadeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.accountAddress = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LogDepositMadeEventResponse> logDepositMadeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, LogDepositMadeEventResponse>() {
            @Override
            public LogDepositMadeEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGDEPOSITMADE_EVENT, log);
                LogDepositMadeEventResponse typedResponse = new LogDepositMadeEventResponse();
                typedResponse.log = log;
                typedResponse.accountAddress = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LogDepositMadeEventResponse> logDepositMadeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGDEPOSITMADE_EVENT));
        return logDepositMadeEventFlowable(filter);
    }

    @Deprecated
    public static SimpleBank load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SimpleBank(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SimpleBank load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SimpleBank(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SimpleBank load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SimpleBank(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SimpleBank load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SimpleBank(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SimpleBank> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(SimpleBank.class, web3j, credentials, contractGasProvider, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<SimpleBank> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(SimpleBank.class, web3j, transactionManager, contractGasProvider, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<SimpleBank> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(SimpleBank.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<SimpleBank> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(SimpleBank.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static class LogDepositMadeEventResponse extends BaseEventResponse {
        public String accountAddress;

        public BigInteger amount;
    }
}
