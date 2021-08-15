package me.giverplay.ganbatte.screen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Layer {
  private final BufferedImage image;
  private Graphics graphics;

  public Layer(BufferedImage image) {
    if(image == null) {
      throw new IllegalArgumentException("Image cannot be null!");
    }

    this.image = image;
    resetGraphics();
  }

  public int getPixel(int x, int y) {
    return image.getRGB(x, y);
  }

  public void setPixel(int x, int y, int color) {
    image.setRGB(x, y, color);
  }

  public int getWidth() {
    return image.getWidth();
  }

  public int getHeight() {
    return image.getHeight();
  }

  public int[] getPixels() {
    return image.getRGB(0, 0, getWidth(), getHeight(), null, getWidth(), getWidth());
  }

  public void resetGraphics() {
    if(graphics != null) {
      graphics.dispose();
    }

    graphics = image.getGraphics();
  }

  public Graphics getGraphics() {
    return graphics;
  }

  public BufferedImage getImage() {
    return image;
  }
}
