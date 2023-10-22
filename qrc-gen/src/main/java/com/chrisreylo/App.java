package com.chrisreylo;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.IOException;
import java.nio.file.Paths;

public class App {

  public static void gen(
    String data,
    String path,
    String charset,
    int h,
    int w
  ) throws WriterException, IOException {
    BitMatrix bitMatrix = new MultiFormatWriter()
      .encode(data, BarcodeFormat.QR_CODE, w, h);
    MatrixToImageWriter.writeToPath(
      bitMatrix,
      path.substring(path.lastIndexOf('.') + 1),
      Paths.get(path)
    );
  }

  public static void main(String[] args) throws WriterException, IOException {
    String url =
      "https://www.youtube.com/watch?v=Q4hQ7xK-kWw&list=PL39VDaR03WJlrxrdUKqi9fH1A2oqSBlHY";
    String url2 = "https://github.com/chrisreylo73";
    String path = "C:\\Users\\chris\\Desktop";
    String charset = "UTF-8";
    gen(url, path, charset, 200, 200);
    // BitMatrix matrix;

    // try {
    //   matrix =
    //     new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500);
    //   MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
    // } catch (Exception e) {
    //   // TODO: handle exception

    // new QRC_Generator();
  }
}
