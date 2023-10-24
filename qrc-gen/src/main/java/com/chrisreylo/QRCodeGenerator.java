package com.chrisreylo;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;

public class QRCodeGenerator {

  public Gui gui;

  QRCodeGenerator() throws WriterException, IOException {
    gui = new Gui(this);
  }

  private static byte[] readPDF(String filePath) throws IOException {
    File file = new File(filePath);
    byte[] data = new byte[(int) file.length()];

    try (FileInputStream fileInputStream = new FileInputStream(file)) {
      fileInputStream.read(data);
    }

    return data;
  }

  public void gen(String data, String path, String name, String format)
    throws WriterException, IOException {
    if (data.contains(".pdf")) {
      byte[] pdfData = readPDF(data);
      data = Base64.getEncoder().encodeToString(pdfData);
    }

    try {
      BitMatrix matrix = new MultiFormatWriter()
        .encode(data, BarcodeFormat.QR_CODE, 500, 500);
      MatrixToImageWriter.writeToPath(
        matrix,
        format,
        Paths.get(path + "/" + name + "." + format)
      );
      System.out.println("\n" + name + "." + format + " Generated!");
    } catch (Exception e) {
      System.out.println("ERROR OCCURRED: " + e);
    }
  }
}
