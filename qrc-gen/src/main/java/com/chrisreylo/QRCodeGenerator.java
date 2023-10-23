package com.chrisreylo;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.IOException;
import java.nio.file.Paths;

public class QRCodeGenerator {

  public void gen() throws WriterException, IOException {
    String data = "https://github.com/chrisreylo73";
    String path = "C:/Users/chris/Desktop/test.jpg";
    BitMatrix matrix = new MultiFormatWriter()
      .encode(data, BarcodeFormat.QR_CODE, 500, 500);
    MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
  }

  QRCodeGenerator() throws WriterException, IOException {
    gen();
    System.out.println("Hello World!");
  }
}
