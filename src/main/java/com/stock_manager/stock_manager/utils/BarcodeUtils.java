package com.stock_manager.stock_manager.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import com.stock_manager.stock_manager.model.Product;
import com.stock_manager.stock_manager.model.enums.ProductCategories;

public class BarcodeUtils {

    private static final String BARCODE_IMAGE_FOLDER = "src\\main\\java\\com\\stock_manager\\stock\\utils\\barcodeImg\\";

    public static void createBarcodeImage(Product product) {
        if(product != null){
            String filePath = BARCODE_IMAGE_FOLDER +
                product.getName()+"_"+LocalDateTime.now()+"_barcode.png";
            try {
                EAN13Writer barcodeWriter = new EAN13Writer();
                BitMatrix bitMatrix = barcodeWriter.encode(product.getBarcode()
                , BarcodeFormat.EAN_13, 400, 200);
                MatrixToImageWriter.writeToPath(bitMatrix, "PNG", new File(filePath).toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String generateBarcode(ProductCategories category) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(category.getCodeNumber());
        for(int i = 0; i <= 9; i++){
            sb.append(random.nextInt(10));
        }
        return sb.toString() + calculateCheckDigit(sb.toString());
    }

    private static int calculateCheckDigit(String barcodeData) {
        int sum = 0;
        for (int i = 0; i < barcodeData.length(); i++) {
            int digit = Character.getNumericValue(barcodeData.charAt(i));
            if (i % 2 == 0) {
                sum += digit;
            } else {
                sum += digit * 3;
            }
        }
        int remainder = sum % 10;
        if (remainder == 0) {
            return 0;
        } else {
            return 10 - remainder;
        }
    }
}
