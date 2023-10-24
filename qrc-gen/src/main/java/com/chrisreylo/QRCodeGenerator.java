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

  // Constructor for the QRCodeGenerator class
  QRCodeGenerator() throws WriterException, IOException {
    // Initialize the GUI
    gui = new Gui(this);
  }

  // Method to read a PDF file and return its contents as a byte array
  private static byte[] readPDF(String filePath) throws IOException {
    File file = new File(filePath);
    byte[] data = new byte[(int) file.length()];

    try (FileInputStream fileInputStream = new FileInputStream(file)) {
      fileInputStream.read(data);
    }

    return data;
  }

  // Method to generate a QR code based on input data
  public void gen(String data, String path, String name, String format)
    throws WriterException, IOException {
    if (data.contains(".pdf")) {
      // If the input data is a PDF file, read its contents and encode as Base64
      byte[] pdfData = readPDF(data);
      data = Base64.getEncoder().encodeToString(pdfData);
    }

    try {
      // Generate a QR code from the input data using the ZXing library
      BitMatrix matrix = new MultiFormatWriter()
        .encode(data, BarcodeFormat.QR_CODE, 500, 500);

      // Write the QR code as an image to the specified path and format
      MatrixToImageWriter.writeToPath(
        matrix,
        format,
        Paths.get(path + "/" + name + "." + format)
      );

      // Print a success message to the console
      System.out.println("\n" + name + "." + format + " Generated!");
    } catch (Exception e) {
      // Print an error message if an exception occurs during QR code generation
      System.out.println("ERROR OCCURRED: " + e);
    }
  }
}
