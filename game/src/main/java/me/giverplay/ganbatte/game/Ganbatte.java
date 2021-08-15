package me.giverplay.ganbatte.game;

import me.giverplay.ganbatte.screen.Renderer;
import me.giverplay.ganbatte.screen.Window;

import java.awt.Color;
import java.awt.Graphics;

public class Ganbatte {
  private final GameLoop loop;
  private final Window window;
  private final Renderer renderer;

  public Ganbatte() {
    this.loop = new GameLoop(this);
    this.window = new Window("Ganbatte", 320, 240);
    this.renderer = window.getRenderer();
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
    Graphics graphics = renderer.getRootLayer().getGraphics();
    graphics.setColor(Color.RED);
    graphics.drawRect(10, 20, 40, 50);
    renderer.render();
  }

  public Window getWindow() {
    return window;
  }
}
