package com.chrisreylo;

import com.google.zxing.WriterException;
import java.io.IOException;

public class App {

  public static void main(String[] args) throws WriterException, IOException {
    new QRCodeGenerator();
  }
}
