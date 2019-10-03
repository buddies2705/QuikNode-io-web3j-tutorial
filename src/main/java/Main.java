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

        Web3j web3 = Web3j.build(new HttpService("https://totally-active-shrew.quiknode.io/4f4e2a11-c6bd-4c37-8e43-7355d8670508/BkXa1xG_6cEY4-3GAd0kKQ==/"));

        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        System.out.println("Client version" + clientVersion);

////        Subscribing for New Blocks
//        Subscription subscription = (Subscription) web3.blockFlowable(false).subscribe(block -> {
//            System.out.println(block.getBlock().getHash());
//        });
//
//        //Subscribing for New Transactions
//        web3.transactionFlowable().subscribe(tx -> {
//            System.out.println(tx.getHash());
//        });
//
//        //Subscribing to pending Transactions
//        web3.pendingTransactionFlowable().subscribe(tx -> {
//            System.out.println(tx.getHash());
//        });


        String walletPassword = "trumpshouldbeimpeached";
        String walletDirectory = "/home/batman/wallet/"; //add your own wallet directory path

        String walletName = WalletUtils.generateNewWalletFile(walletPassword, new File(walletDirectory));

        System.out.println(walletName);
        //Loading Wallet
        Credentials credentials = WalletUtils.loadCredentials(walletPassword, walletDirectory + "/" + walletName);

        String accountAddress = credentials.getAddress();
        System.out.println("Account address: " + accountAddress);


        SimpleBank simpleBank = SimpleBank.load("0xaBbB2E8A526A06D0CC76e6583DD2B2a5572a913a",web3, credentials , new DefaultGasProvider());


        simpleBank.logDepositMadeEventFlowable(DefaultBlockParameterName.EARLIEST,
                DefaultBlockParameterName.LATEST)
                .doOnError(error -> System.err.println("The error message is: " + error.getMessage()))
                .subscribe(logDepositMadeEventResponse ->
                        System.out.println(logDepositMadeEventResponse.amount),
                                e -> System.err.println("The error message is: " + e));

    }
}