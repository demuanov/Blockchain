package blockchain;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockChain {
    private Block chainBlock;
    private int blockCount = 0;
    public HashMap<Integer, Block> chain;
    private final int numberOfZeros;


    public BlockChain(int numberOfZeros) {
        this.chain = new HashMap<>();
        this.numberOfZeros = numberOfZeros;

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {

            List<Miner> minerList = new ArrayList<>();
            minerList.add(new Miner(getLastBlockHash()));

            try {
                Block block = executor.invokeAny(minerList);
                addBlock(block);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


    public Block createBlock(String previousBlockHash) {
        return new Block(previousBlockHash);
    }

    public void addBlock(Block block) {
        this.chain.put(
            blockCount,
            block
        );
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

    public int getBlockChainSize(){
        return chain.size();
    }

    public boolean isValid(BlockChain chain) {
        if (chain.getBlockChainSize() <= 1) {
            return chain.getBlockChainSize() < 1 || "0".equals(getLastBlockHash());
        }

        for (Block block: this.chain.values()) {
            String blockHash = block.getBlockHash();
            if( blockHash.equals("0")) {
                continue;
            }
           String previousHash = block.getPreviousBlockHash();
            boolean valid = previousHash.equals(blockHash);
            if (!valid) {
                return false;
            }
        }
        return true;

    }

    public void getAllBlocks() {
        Collection<Block> getValues = this.chain.values();
        for (Block getValue : getValues) {
            System.out.println(getValue);
        }
    }

}
