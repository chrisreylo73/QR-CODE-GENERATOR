package com.chrisreylo;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.IOException;
import java.nio.file.Paths;

public class App {

  public static void main(String[] args) throws WriterException, IOException {
    new QRCodeGenerator();
  }
}
