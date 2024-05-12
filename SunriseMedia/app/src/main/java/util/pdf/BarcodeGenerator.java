/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Desktop;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mbaiu
 */
public class BarcodeGenerator {
    
    public static BufferedImage creadeBarCode(String isbn) {
        
        // Generate the barcode
        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        EAN13Writer writer = new EAN13Writer();
        BitMatrix bitMatrix = writer.encode(isbn, BarcodeFormat.EAN_13, 300, 150, hints);
        BufferedImage barcodeImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        
        // Create a new image with barcode and ISBN
        int width = barcodeImage.getWidth();
        int height = barcodeImage.getHeight() + 20;
        BufferedImage combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        // Draw the barcode onto the new image
        combined.getGraphics().drawImage(barcodeImage, 0, 0, null);
        
        // Draw the ISBN below the barcode
        combined.getGraphics().drawString(isbn, 10, height - 5);
        
        return combined;
    }
    
    public static String getRandomISBN(){
        StringBuilder sb = new StringBuilder();
        sb.append("978");
        for (int i = 0; i < 9; i++) {
            sb.append((int) (Math.random() * 10));
        }
        String isbn = sb.toString();
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Integer.parseInt(isbn.substring(i, i + 1));
            sum += (i % 2 == 0) ? digit * 1 : digit * 3;
        }
        int checkDigit = 10 - (sum % 10);
        if (checkDigit == 10) {
            checkDigit = 0;
        }
        return isbn + checkDigit;
        
    }
    
}
