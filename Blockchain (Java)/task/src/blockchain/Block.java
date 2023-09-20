package blockchain;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Block {
    private int id;
    private final long timeStamp;
    private final String previousBlockHash;
    private final String blockHash;
    private String event;
    private int blockGenerationTime;
    private String magicNumber;
    private String threadName;
    private int numberOfZeros = 2;
    static int idCounter = 0;


    public String getEvent () {
        return event;
    }

    public void setEvent (String event) {
        this.event = event;
    }

    public float getBlockGenerationTime () {
        return blockGenerationTime;
    }

    public void setBlockGenerationTime (int blockGenerationTime) {
        this.blockGenerationTime = blockGenerationTime;
    }

    public void setThreadName (String threadName) {
        this.threadName = threadName;
    }


    public Block (String previousBlockHash) {
        this.id = idCounter;
        this.timeStamp = new Date().getTime();
        this.previousBlockHash = previousBlockHash;
        this.blockHash = setHash(numberOfZeros);
    }

    public int getId () {
        return id;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    @Override
    public String toString() {
        return "Block: " +
                "\nCreated by miner # " + threadName +
                "\nId: " + getId() +
                "\nTimestamp: " + timeStamp +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block: \n"+ previousBlockHash +
                "\nHash of the block: \n" + blockHash +
                "\nBlock was generating for " + blockGenerationTime + " seconds" +
                "\nN was "+ getEvent() +" to " + numberOfZeros  + "\n";
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
//        System.out.println("BLOCK GENERATION TIME ->" + blockGenerationTime);
       return hash;
    }

    public void increaseId () {
        this.idCounter++;
    }
}
