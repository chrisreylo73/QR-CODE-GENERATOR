package com.chrisreylo;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.IOException;
import java.nio.file.Paths;

public class QRCodeGenerator {

  public Gui gui;

  public void gen(String data, String path, String name, String format)
    throws WriterException, IOException {
    try {
      BitMatrix matrix = new MultiFormatWriter()
        .encode(data, BarcodeFormat.QR_CODE, 500, 500);
      MatrixToImageWriter.writeToPath(
        matrix,
        format,
        Paths.get(path + "/" + name + "." + format)
      );
    } catch (Exception e) {
      System.out.println("ERROR OCCURRED: " + e);
    }
  }

  QRCodeGenerator() throws WriterException, IOException {
    gui = new Gui(this);
    String data = "https://github.com/chrisreylo73";
    String path =
      "C:/Users/chris/Desktop/QR CODE GENERATOR/QR-CODE-GENERATOR/qrc-gen/src/main/resources/QRCodes";
    String name = "test";
    String format = "jpg";
    gen(data, path, name, format);
    System.out.println("Hello World!");
  }
}
