package blockchain;

import java.util.Date;

public class Block {
    private int id;
    private long timeStamp;
    private String previousBlockHash;
    private String nextBlockHash;

    public Block() {
        this.id = 0;
        this.timeStamp = new Date().getTime();
        this.previousBlockHash = "0";
        this.nextBlockHash = StringUtil.applySha256(previousBlockHash);
    }

    public String toString() {
        return "Block: " + "\nId: " + id + "\nTimestamp: " + timeStamp + "\nHash " + previousBlockHash + "\nHash: " + nextBlockHash;
    }



}
