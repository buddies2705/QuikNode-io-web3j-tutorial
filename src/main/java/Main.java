import com.simplebank.SimpleBank;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscription;
import org.web3j.abi.EventEncoder;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;

import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Main {

    public static void main(String[] args) throws IOException, CipherException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {

        Web3j web3 = Web3j.build(new HttpService("https://rinkeby.infura.io/v3/8db0d897cda44a4f9c5b371c6a40ed7e"));

        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        System.out.println("Client version" + clientVersion);

//        Subscribing for New Blocks
        Subscription subscription = (Subscription) web3.blockFlowable(false).subscribe(block -> {
            System.out.println(block.getBlock().getHash());
        });

        //Subscribing for New Transactions
        web3.transactionFlowable().subscribe(tx -> {
            System.out.println(tx.getHash());
        });

        //Subscribing to pending Transactions
        web3.pendingTransactionFlowable().subscribe(tx -> {
            System.out.println(tx.getHash());
        });


        String walletPassword = "trumpshouldbeimpeached";
        String walletDirectory = "/home/batman/wallet/"; //add your own wallet directory path

        String walletName = WalletUtils.generateNewWalletFile(walletPassword, new File(walletDirectory));

        //Loading Wallet
        Credentials credentials = WalletUtils.loadCredentials(walletPassword, walletDirectory + "/" + walletName);

        String accountAddress = credentials.getAddress();
        System.out.println("Account address: " + accountAddress);


        SimpleBank simpleBank = SimpleBank.load("0x7208b4883a4dF0F3e5cD084F2F9C579e7b622A38",web3, credentials , new DefaultGasProvider());



        final EthFilter ethFilter = new EthFilter(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST,
                simpleBank.getContractAddress());

        ethFilter.addSingleTopic(EventEncoder.encode(SimpleBank.LOGDEPOSITMADE_EVENT));


        simpleBank.logDepositMadeEventFlowable(DefaultBlockParameterName.EARLIEST,
                DefaultBlockParameterName.LATEST)
                .doOnError(error -> System.err.println("The error message is: " + error.getMessage()))
                .subscribe(logDepositMadeEventResponse ->
                        System.out.println(logDepositMadeEventResponse.accountAddress),
                                e -> System.err.println("The error message is: " + e));

    }
}