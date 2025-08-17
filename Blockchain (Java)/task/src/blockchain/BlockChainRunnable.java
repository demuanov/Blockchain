package blockchain;

public class BlockChainRunnable implements Runnable{
  private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private BlockChain blockChain;
    private Controller controller;
//    private String name;
public BlockChainRunnable (Controller controller, BlockChain blockChain) {
//    this.name = Thread.currentThread().getName();
//    blockChain.setThreadName(this.name);
    this.controller = controller;
    this.blockChain = blockChain;
  }
// TODO Mining or updating should be here
  @Override
  public void run () {


    blockChain.setThreadName(Thread.currentThread().getName());
    controller.setCommand(new runAddBlockCommand(blockChain));
    controller.executeCommand();
    blockChain.setThreadName(Thread.currentThread().getName());
    controller.setCommand(new runAddBlockCommand(blockChain));
    controller.executeCommand();
  }
}
