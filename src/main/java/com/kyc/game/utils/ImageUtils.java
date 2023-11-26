package com.kyc.game.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class ImageUtils {
    private static final Base64.Encoder encoder = Base64.getEncoder();

    public static String picToBase64(String filePath) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(filePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
            return encoder.encodeToString(data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
