package me.giverplay.ganbatte.screen;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Window {
  private final int width;
  private final int height;

  private final JFrame frame;
  private final Canvas canvas;

  public Window(String title, int width, int height) {
    this.width = width;
    this.height = height;

    canvas = new Canvas();
    canvas.setPreferredSize(new Dimension(width, height));

    frame = new JFrame(title);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.add(canvas);
    frame.pack();
    frame.setLocationRelativeTo(null);
  }

  public void show() {
    frame.setVisible(true);
  }

  public void hide() {
    frame.setVisible(false);
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
