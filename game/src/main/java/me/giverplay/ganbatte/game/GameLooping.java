package me.giverplay.ganbatte.game;

public class GameLooping implements Runnable {
  private final Ganbatte game;

  private Thread thread;

  private volatile boolean isRunning;

  public GameLooping(Ganbatte game) {
    this.game = game;
  }

  public synchronized void start() {
    this.isRunning = true;
    this.thread = new Thread(this, "Game Looping Thread");
    this.thread.start();
  }

  public synchronized void stop() {
    isRunning = false;

    try {
      this.thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    long timer = System.currentTimeMillis();
    long lastTime = System.nanoTime();
    long now;

    double nsPerTick = 1_000_000_000 / 60.0D;
    double unprocessed = 0.0D;

    int tps = 0;
    int fps = 0;

    while(this.isRunning) {
      now = System.nanoTime();
      unprocessed += (now - lastTime) / nsPerTick;
      lastTime = now;

      while(unprocessed >= 1) {
        game.update();
        ++tps;
        --unprocessed;
      }

      game.draw();
      ++fps;

      if(System.currentTimeMillis() - timer >= 1000) {
        System.out.printf("[TPS: %d | FPS: %d]%n", tps, fps);
        tps = 0;
        fps = 0;
        timer += 1000;
      }

      try {
        Thread.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
