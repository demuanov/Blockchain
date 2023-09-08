package blockchain;

import java.util.*;

public class BlockChain {
    private Block chainBlock;
    private int blockCount = 0;
    public HashMap<Integer, Block> chain;


    public BlockChain() {
        this.chain = new HashMap<>();
    }

    public void addBlock() {
        this.chain.put(blockCount, new Block(blockCount, getLastBlockHash()));
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
