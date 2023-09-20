package blockchain;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//      int nThreads = Runtime.getRuntime().availableProcessors();
//      ExecutorService executor = Executors.newFixedThreadPool(nThreads);
//
//      MessageSender[] messageSenders = new MessageSender[4];

try {

  BlockChain blockChain = new BlockChain(2);
  blockChain.getAllBlocks();
} catch ( RuntimeException e){
  e.printStackTrace();
}
    }
}
