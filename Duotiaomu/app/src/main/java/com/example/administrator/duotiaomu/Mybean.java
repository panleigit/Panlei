package com.example.administrator.duotiaomu;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */

public class Mybean {
    private int dataSize;
    private List<ApkBean> apk;

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public List<ApkBean> getApk() {
        return apk;
    }

    public void setApk(List<ApkBean> apk) {
        this.apk = apk;
    }

    public static class ApkBean {
        /**
         * id : 143
         * name : 诛仙
         * iconUrl : http://www.microvirt.com/new_market/img/zhuxian_logo.png
         * downloadUrl : http://www.microvirt.com/new_market/apk/zhuxian_xiaoyao_ew1995111626.apk
         * packageName : com.wanmei.zhuxian.ewan.xyaz
         * versionName : 1.99.5
         * versionCode : 1102
         * apkSize : 517749503
         * downloadTimes : 680500
         * categoryName : 角色扮演
         * from : 官方
         * markid : 0
         */

        private String id;
        private String name;
        private String iconUrl;
        private String downloadUrl;
        public String packageName;
        private String versionName;
        private String versionCode;
        private String apkSize;
        private String downloadTimes;
        private String categoryName;
        private String from;
        private int markid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getDownloadUrl() {
            return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public String getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(String versionCode) {
            this.versionCode = versionCode;
        }

        public String getApkSize() {
            return apkSize;
        }

        public void setApkSize(String apkSize) {
            this.apkSize = apkSize;
        }

        public String getDownloadTimes() {
            return downloadTimes;
        }

        public void setDownloadTimes(String downloadTimes) {
            this.downloadTimes = downloadTimes;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public int getMarkid() {
            return markid;
        }

        public void setMarkid(int markid) {
            this.markid = markid;
        }

    }
}
