package blockchain;
class Miner extends Thread {

  private final BlockChainRunnable blockChainRunnable;

  public Miner ( BlockChainRunnable blockChainRunnable, String name) {
    super(name);
    this.blockChainRunnable = blockChainRunnable;
  }

  @Override
  public void run() {
    blockChainRunnable.run();
  }
}