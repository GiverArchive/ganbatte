package me.giverplay.ganbatte.screen;

import java.util.Arrays;

public class Layer {
  private final int[] pixels;

  private final int width;
  private final int height;

  public Layer(int width, int height) {
    if(width < 1) throw new IllegalArgumentException("Width cannot be less than 1");
    if(height < 1) throw new IllegalArgumentException("Height cannot be less than 1");

    this.width = width;
    this.height = height;

    this.pixels = new int[width * height];
  }

  public int getPixel(int x, int y) {
    return pixels[x + y * width];
  }

  public void setPixel(int x, int y, int color) {
    pixels[x + y * width] = color;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int[] getPixels() {
    return Arrays.copyOf(pixels, pixels.length);
  }
}
