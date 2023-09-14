package blockchain;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Block {
    private final int id;
    private final long timeStamp;
    private final String previousBlockHash;
    private final String blockHash;
    private float blockGenerationTime;
    private String magicNumber;

    public Block (int id, String previousBlockHash, int numberOfZeros) {
        this.id = id;
        this.timeStamp = new Date().getTime();
        this.previousBlockHash = previousBlockHash;
        this.blockHash = setHash(numberOfZeros);
    }

    public String getBlockHash() {
        return blockHash;
    }

    public String toString() {
        return "Block: " +
                "\nId: " + id +
                "\nTimestamp: " + timeStamp +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block: \n"+ previousBlockHash +
                "\nHash of the block: \n" + blockHash +
                "\nBlock was generating for " + blockGenerationTime + " seconds" + "\n";
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

        this.blockGenerationTime = (endTime - startTime) / 1000F;
        System.out.println("BLOCK GENERATION TIME ->" + blockGenerationTime);
       return hash;
    }

}
