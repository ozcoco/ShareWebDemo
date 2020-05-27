package com.xdynamics.share.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.utils
 * @ClassName: MediaUtils
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/26 9:40
 * @UpdateUser:
 * @UpdateDate: 2020/5/26 9:40
 * @UpdateRemark:
 * @Version: 1.0
 */
public class MediaUtils {

    @Nullable
    public static Uri getImageUriByPath(@NonNull ContentResolver resolver, @NonNull String path) {

        return Uri.parse(MediaStore.Images.Media.insertImage(resolver, BitmapFactory.decodeFile(path), null, null));

    }

    @Nullable
    public static Uri getVideoUriByPath(@NonNull ContentResolver resolver, @NonNull String path) {

        Uri mediaUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

        Cursor cursor = resolver.query(mediaUri,
                null,
                null,
                null,
                null);

        Uri uri = null;

        if (cursor != null && cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                int index = cursor.getColumnIndex(MediaStore.Video.Media.DATA);
                if (index != -1) {
                    String path1 = cursor.getString(index);
                    if (path1.equals(path)) {
                        uri = ContentUris.withAppendedId(mediaUri,
                                cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media._ID)));
                        return uri;
                    }
                }
            }
        } else {
            return null;
        }
        cursor.close();
        return null;
    }

}
