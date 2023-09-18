package blockchain;

import blockchain.BlockChainRunnable.*;
import java.util.concurrent.ThreadPoolExecutor;


public class Main {
    public static void main(String[] args) throws InterruptedException {
    Controller controller = new Controller();

    BlockChain blockChain = new BlockChain(2);

    Miner miner = new Miner(new BlockChainRunnable(controller, blockChain), "1");
    Miner miner2 = new Miner(new BlockChainRunnable(controller, blockChain), "2");

    Thread thread1 = new Thread(miner, "1");
    Thread thread2 = new Thread(miner2, "2");
    Thread thread3 = new Thread(miner, "3");

    thread1.start();
    thread2.start();
    thread3.start();

    thread1.join();
    thread2.join();

    blockChain.getAllBlocks();

    }
}
