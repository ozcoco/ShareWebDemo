package com.xdynamics.share.p2p.utils;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.utils
 * @ClassName: ResourceUtils
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/5/29 14:08
 * @UpdateUser:
 * @UpdateDate: 2020/5/29 14:08
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ResourceUtils {

    public static List<File> getFiles(@NonNull String[] dirs, @Nullable FilenameFilter filter) {

        List<File> list = new ArrayList<>();

        for (String path : dirs) {

            File file = new File(path);

            if (file.exists() && file.isDirectory()) {

                list.addAll(Arrays.asList(filter != null ? file.listFiles(filter) : file.listFiles()));

            }

        }

        return list;
    }

    public static List<String> getAssetFiles(@NonNull AssetManager asset, @NonNull String dir) {

        List<String> list = new ArrayList<>();

        try {
            list.addAll(Arrays.asList(asset.list(dir)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
