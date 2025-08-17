package blockchain;

import java.util.*;

public class BlockChain {
    private String threadName;
    private int blockCount = 0;
    public HashMap<Integer, Block> chain;

    public int getNumberOfZeros () {
        return numberOfZeros;
    }

    public void setNumberOfZeros (int numberOfZeros) {
        this.numberOfZeros = numberOfZeros;
    }

    private  int numberOfZeros;


    public void setThreadName (String threadName) {
        this.threadName = threadName;
    }

    public BlockChain(int numberOfZeros) {
        this.chain = new HashMap<>();
        this.numberOfZeros = numberOfZeros;
    }

    public synchronized void addBlock() {

        Block block = new Block(blockCount, getLastBlockHash(), numberOfZeros, threadName);
        System.out.println("Number of Zeros-> " + getNumberOfZeros());
        if(block.getBlockGenerationTime() < 60) {
            numberOfZeros++;
        } else {
            numberOfZeros--;
        }

        this.chain.put(
            blockCount,
            block);
        this.blockCount++;
    }

    public String getLastBlockHash () {
        try {
        Map.Entry<Integer, Block> lastBlock = this.chain.entrySet().stream()
                .reduce((first, second) -> second)
                .orElse(null);

            return lastBlock != null ? lastBlock.getValue().getBlockHash() : "0";
            } catch (NoSuchElementException e) {
            return "0";
        }


    }

    public void getAllBlocks() {
        Collection<Block> getValues = this.chain.values();
        for (Block getValue : getValues) {
            System.out.println(getValue);
        }
    }

}
