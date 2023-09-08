package blockchain;

public class Main {
    public static void main(String[] args) {
      BlockChain  blockChain = new BlockChain();

       blockChain.addBlock();
       blockChain.addBlock();
       blockChain.addBlock();
       blockChain.addBlock();
       blockChain.addBlock();
       blockChain.getAllBlocks();
    }
}
