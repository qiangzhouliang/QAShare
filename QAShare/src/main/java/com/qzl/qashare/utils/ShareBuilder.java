package com.qzl.qashare.utils;

import android.net.Uri;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * @author qiangzhouliang
 * @desc ShareBuilder
 * @email 2538096489@qq.com
 * @time 2021/3/17 11:18
 * @class ShareBuilder
 * @package com.qzl.qashare.utils
 */
public class ShareBuilder {
    /**
     * 分享文字
     */
    public static final int SHARE_TEXT = 1;
    /**
     * 分享文件
     */
    public static final int SHARE_FILE = 2;

    /**
     * 分享多个文件
     */
    public static final int SHARE_MULTIPLE_FILES = 3;

    @IntDef({SHARE_TEXT, SHARE_FILE, SHARE_MULTIPLE_FILES})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShareType {
    }


    /**
     * 分享的文字内容
     */
    private String text;

    /**
     * 分享选择标题
     */
    private String chooserTitle;

    /**
     * 分享类型
     */
    private int shareType;

    /**
     * 分享的文件集合
     */
    private List<Uri> shareFiles;

    public String getText() {
        return text;
    }

    public ShareBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public String getChooserTitle() {
        return chooserTitle;
    }

    public ShareBuilder setChooserTitle(String chooserTitle) {
        this.chooserTitle = chooserTitle;
        return this;
    }

    public int getShareType() {
        return shareType;
    }

    public ShareBuilder setShareType(@ShareType int shareType) {
        this.shareType = shareType;
        return this;
    }

    public List<Uri> getShareFiles() {
        return shareFiles;
    }

    public ShareBuilder setShareFiles(List<Uri> shareFiles) {
        this.shareFiles = shareFiles;
        return this;
    }

    public Share build() {
        return new Share(this);
    }

}
