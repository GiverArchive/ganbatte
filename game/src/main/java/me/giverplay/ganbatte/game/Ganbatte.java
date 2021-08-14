package me.giverplay.ganbatte.game;

import me.giverplay.ganbatte.screen.Window;

public class Ganbatte {
  private final GameLoop loop;
  private final Window window;

  public Ganbatte() {
    this.loop = new GameLoop(this);
    this.window = new Window("Ganbatte", 320, 240);
    this.window.show();
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

  public Window getWindow() {
    return window;
  }
}
