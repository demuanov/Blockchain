package blockchain;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Block {
    private final int id;
    private final long timeStamp;
    private final String previousBlockHash;
    private final String blockHash;

    public float getBlockGenerationTime () {
        return blockGenerationTime;
    }

    public void setBlockGenerationTime (int blockGenerationTime) {
        this.blockGenerationTime = blockGenerationTime;
    }

    private int blockGenerationTime;
    private String magicNumber;
    private String threadName;

    public Block (int id, String previousBlockHash, int numberOfZeros,String threadName) {
        this.id = id;
        this.timeStamp = new Date().getTime();
        this.previousBlockHash = previousBlockHash;
        this.blockHash = setHash(numberOfZeros);
        this.threadName = threadName;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public String toString() {
        return "Block: " +
                "\nCreated by miner # " + threadName +
                "\nId: " + id +
                "\nTimestamp: " + timeStamp +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block: \n"+ previousBlockHash +
                "\nHash of the block: \n" + blockHash +
                "\nBlock was generating for " + blockGenerationTime + " seconds" +
                "\nN was decreased by "  + "\n";
    }

    private String setHash(int numberOfZeros){
        String zeros = "0".repeat(numberOfZeros);
        this.magicNumber = String.valueOf(ThreadLocalRandom.current().nextInt());
        String hash = StringUtil.applySha256(this.magicNumber);


        Long startTime = System.currentTimeMillis();
        while (!hash.substring(0, numberOfZeros).equals(zeros)) {
            String generationNumber = String.valueOf(ThreadLocalRandom.current().nextInt());
            hash = StringUtil.applySha256(generationNumber);
            this.magicNumber = generationNumber;
       }

       Long endTime = System.currentTimeMillis();

        setBlockGenerationTime((int)((endTime - startTime) / 1000F));
        System.out.println("BLOCK GENERATION TIME ->" + blockGenerationTime);
       return hash;
    }

}
