package blockchain;

public class runAddBlockCommand implements Command {

  private final BlockChain blockChain;

  public runAddBlockCommand (BlockChain blockChain) {
    this.blockChain = blockChain;
  }

  @Override
  public void execute () {
    blockChain.addBlock();
  }
}
