package blockchain;

import java.util.Date;

public class Block {
    private final int id;
    private final long timeStamp;
    private final String previousBlockHash;
    private final String blockHash;

    public Block(int id, String previousBlockHash) {
        this.id = id;
        this.timeStamp = new Date().getTime();
        this.previousBlockHash = previousBlockHash;
        this.blockHash = StringUtil.applySha256(String.valueOf(id));
    }

    public String getBlockHash() {
        return blockHash;
    }

    public String toString() {
        return "Block: " +
                "\nId: " + id +
                "\nTimestamp: " + timeStamp +
                "\nHash of the previous block:  " + previousBlockHash +
                "\nHash of the block: " + blockHash + "\n";
    }



}
