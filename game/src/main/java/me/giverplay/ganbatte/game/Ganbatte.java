package me.giverplay.ganbatte.game;

public class Ganbatte {
  private final GameLooping looping;

  public Ganbatte() {
    this.looping = new GameLooping(this);
  }

  public synchronized void start() {
    this.looping.start();
  }

  public synchronized void stop() {
    this.looping.stop();
  }

  protected void update() {

  }

  protected void draw() {

  }
}
