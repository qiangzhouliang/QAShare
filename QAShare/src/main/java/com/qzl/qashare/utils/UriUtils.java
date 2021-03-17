package com.qzl.qashare.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;

import androidx.core.content.FileProvider;

import java.io.File;

/**
 * @author qiangzhouliang
 * @desc UriUtils
 * @email 2538096489@qq.com
 * @time 2021/3/17 11:15
 * @class UriUtils
 * @package com.qzl.qashare.utils
 */
public class UriUtils {

    /**
     * 获取文件的Uri
     *
     * @param context  应用上下文
     * @param filePath 文件路径
     * @return
     */
    public static Uri getUriFromFile(Context context, String filePath) {
        Uri uri = null;
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 24) {
            uri = Uri.fromFile(file);
        } else {
            uri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        }
        return uri;
    }
}
