package me.giverplay.ganbatte.screen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Renderer {
  public final Color BACKGROUND_COLOR;

  private final BufferStrategy bufferStrategy;
  private final Graphics graphics;
  private final Layer rootLayer;

  public Renderer(BufferStrategy bufferStrategy, int width, int height, Color backgroundColor) {
    if(bufferStrategy == null) {
      throw new IllegalArgumentException("BufferStrategy cannot be null!");
    }

    if(backgroundColor == null) {
      backgroundColor = Color.BLACK;
    }

    this.bufferStrategy = bufferStrategy;
    this.graphics = bufferStrategy.getDrawGraphics();
    this.rootLayer = new Layer(new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB));
    this.BACKGROUND_COLOR = backgroundColor;
  }

  public void render() {
    graphics.setColor(BACKGROUND_COLOR);
    graphics.fillRect(0, 0, getWidth(), getHeight());
    graphics.drawImage(rootLayer.getImage(), 0, 0, null);
    bufferStrategy.show();
  }

  public Layer getRootLayer() {
    return rootLayer;
  }

  public int getWidth() {
    return rootLayer.getWidth();
  }

  public int getHeight() {
    return rootLayer.getHeight();
  }
}
