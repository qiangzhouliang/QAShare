package com.qzl.qashare;

import android.graphics.drawable.Drawable;

/**
 * @author qiangzhouliang
 * @desc ShareBean
 * @email 2538096489@qq.com
 * @time 2021/3/17 11:18
 * @class ShareBean
 * @package com.qzl.qashare
 */
public class ShareBean {
    private String appName;
    private String packageName;
    private String className;
    private Drawable icon;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
