package com.xdynamics.share.qr;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Size;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.Hashtable;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.qr
 * @ClassName: QrUtils
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/25 14:51
 * @UpdateUser:
 * @UpdateDate: 2020/5/25 14:51
 * @UpdateRemark:
 * @Version: 1.0
 */
public class QrUtils {

    public static Bitmap createQR(@NonNull String content, @NonNull Size size) throws WriterException {

        int w = size.getWidth();

        int h = size.getHeight();

        Hashtable<EncodeHintType, String> hints = new Hashtable<>();

        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

        BitMatrix bitMatrix = new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, w, h, hints);

        int[] colors = new int[w * h];

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (bitMatrix.get(i, j)) {
                    colors[i * w + j] = Color.BLACK;
                } else {
                    colors[i * w + j] = Color.WHITE;
                }
            }
        }

        return Bitmap.createBitmap(colors, w, h, Bitmap.Config.RGB_565);
    }

}
