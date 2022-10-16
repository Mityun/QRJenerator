package org.example;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QrCodeDecoder {

    // Function to read the QR file
    public static String readQR(String path,
                                String charset,
                                Map hashMap)
            throws FileNotFoundException, IOException, NotFoundException

    {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        return result.getText();
    }
    // Driver code

    public static void main(String[] args) throws WriterException, IOException, NotFoundException {

        // Path where the QR code is saved
        String path = "src/main/resources/Qrcodes/img.png";

        // Encoding charset

        String charset = "UTF-8";


        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();


        hintMap.put(EncodeHintType.ERROR_CORRECTION,

                ErrorCorrectionLevel.L);


        System.out.println(

                "QRCode output: "  + readQR(path, charset, hintMap));

    }

}