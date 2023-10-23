package com.chrisreylo;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Gui {

  private final int frameWidth = 500;
  private final int frameHeight = 500;
  private final JFrame frame;
  private final JPanel mainPanel;

  public Gui() {
    frame = new JFrame("");
    frame.setSize(frameWidth, frameHeight);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    mainPanel = new JPanel();
  }
}
