package blockchain;

public class runAddBlockCommand implements Command {

  private BlockChain blockChain;

  public runAddBlockCommand (BlockChain blockChain) {
    this.blockChain = blockChain;
  }

  @Override
  public void execute () {
    blockChain.addBlock();
  }
}
