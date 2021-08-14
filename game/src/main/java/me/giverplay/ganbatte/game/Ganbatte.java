package me.giverplay.ganbatte.game;

public class Ganbatte {
  private final GameLoop loop;

  public Ganbatte() {
    this.loop = new GameLoop(this);
  }

  public synchronized void start() {
    this.loop.start();
  }

  public synchronized void stop() {
    this.loop.stop();
  }

  protected void update() {

  }

  protected void draw() {

  }
}
