package blockchain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      System.out.print("Enter how many zeros the hash must start with: ");
      Scanner sc = new Scanner(System.in);

      int numberOfZeros = sc.nextInt();
      BlockChain  blockChain = new BlockChain(numberOfZeros);

       blockChain.addBlock();
       blockChain.addBlock();
       blockChain.addBlock();
       blockChain.addBlock();
       blockChain.addBlock();
       blockChain.getAllBlocks();
    }
}
