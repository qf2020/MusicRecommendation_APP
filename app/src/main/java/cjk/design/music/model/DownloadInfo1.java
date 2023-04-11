package cjk.design.music.model;

import java.util.List;

public class DownloadInfo1 {
    /**
     * data : [{"id":33894312,"url":"http://m8.music.126.net/20230403162850/9d5b2de8dad3a1f46b3e35deddb88074/ymusic/0fd6/4f65/43ed/a8772889f38dfcb91c04da915b301617.mp3","br":320000,"size":10691439,"md5":"a8772889f38dfcb91c04da915b301617","code":200,"expi":1200,"type":"mp3","gain":-6.3072,"peak":1,"fee":0,"uf":null,"payed":0,"flag":1,"canExtend":false,"freeTrialInfo":null,"level":"exhigh","encodeType":"mp3","freeTrialPrivilege":{"resConsumable":false,"userConsumable":false,"listenType":null,"cannotListenReason":null},"freeTimeTrialPrivilege":{"resConsumable":false,"userConsumable":false,"type":0,"remainTime":0},"urlSource":0,"rightSource":0,"podcastCtrp":null,"effectTypes":null,"time":267232}]
     * code : 200
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 33894312
         * url : http://m8.music.126.net/20230403162850/9d5b2de8dad3a1f46b3e35deddb88074/ymusic/0fd6/4f65/43ed/a8772889f38dfcb91c04da915b301617.mp3
         * br : 320000
         * size : 10691439
         * md5 : a8772889f38dfcb91c04da915b301617
         * code : 200
         * expi : 1200
         * type : mp3
         * gain : -6.3072
         * peak : 1
         * fee : 0
         * uf : null
         * payed : 0
         * flag : 1
         * canExtend : false
         * freeTrialInfo : null
         * level : exhigh
         * encodeType : mp3
         * freeTrialPrivilege : {"resConsumable":false,"userConsumable":false,"listenType":null,"cannotListenReason":null}
         * freeTimeTrialPrivilege : {"resConsumable":false,"userConsumable":false,"type":0,"remainTime":0}
         * urlSource : 0
         * rightSource : 0
         * podcastCtrp : null
         * effectTypes : null
         * time : 267232
         */

        private int id;
        private String url;
        private int br;
        private int size;
        private String md5;
        private int code;
        private int expi;
        private String type;
        private double gain;
        private String peak;
        private int fee;
        private Object uf;
        private int payed;
        private int flag;
        private boolean canExtend;
        private Object freeTrialInfo;
        private String level;
        private String encodeType;
        private FreeTrialPrivilegeBean freeTrialPrivilege;
        private FreeTimeTrialPrivilegeBean freeTimeTrialPrivilege;
        private int urlSource;
        private int rightSource;
        private Object podcastCtrp;
        private Object effectTypes;
        private int time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getBr() {
            return br;
        }

        public void setBr(int br) {
            this.br = br;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getExpi() {
            return expi;
        }

        public void setExpi(int expi) {
            this.expi = expi;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getGain() {
            return gain;
        }

        public void setGain(double gain) {
            this.gain = gain;
        }

        public String getPeak() {
            return peak;
        }

        public void setPeak(String peak) {
            this.peak = peak;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public Object getUf() {
            return uf;
        }

        public void setUf(Object uf) {
            this.uf = uf;
        }

        public int getPayed() {
            return payed;
        }

        public void setPayed(int payed) {
            this.payed = payed;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public boolean isCanExtend() {
            return canExtend;
        }

        public void setCanExtend(boolean canExtend) {
            this.canExtend = canExtend;
        }

        public Object getFreeTrialInfo() {
            return freeTrialInfo;
        }

        public void setFreeTrialInfo(Object freeTrialInfo) {
            this.freeTrialInfo = freeTrialInfo;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getEncodeType() {
            return encodeType;
        }

        public void setEncodeType(String encodeType) {
            this.encodeType = encodeType;
        }

        public FreeTrialPrivilegeBean getFreeTrialPrivilege() {
            return freeTrialPrivilege;
        }

        public void setFreeTrialPrivilege(FreeTrialPrivilegeBean freeTrialPrivilege) {
            this.freeTrialPrivilege = freeTrialPrivilege;
        }

        public FreeTimeTrialPrivilegeBean getFreeTimeTrialPrivilege() {
            return freeTimeTrialPrivilege;
        }

        public void setFreeTimeTrialPrivilege(FreeTimeTrialPrivilegeBean freeTimeTrialPrivilege) {
            this.freeTimeTrialPrivilege = freeTimeTrialPrivilege;
        }

        public int getUrlSource() {
            return urlSource;
        }

        public void setUrlSource(int urlSource) {
            this.urlSource = urlSource;
        }

        public int getRightSource() {
            return rightSource;
        }

        public void setRightSource(int rightSource) {
            this.rightSource = rightSource;
        }

        public Object getPodcastCtrp() {
            return podcastCtrp;
        }

        public void setPodcastCtrp(Object podcastCtrp) {
            this.podcastCtrp = podcastCtrp;
        }

        public Object getEffectTypes() {
            return effectTypes;
        }

        public void setEffectTypes(Object effectTypes) {
            this.effectTypes = effectTypes;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public static class FreeTrialPrivilegeBean {
            /**
             * resConsumable : false
             * userConsumable : false
             * listenType : null
             * cannotListenReason : null
             */

            private boolean resConsumable;
            private boolean userConsumable;
            private Object listenType;
            private Object cannotListenReason;

            public boolean isResConsumable() {
                return resConsumable;
            }

            public void setResConsumable(boolean resConsumable) {
                this.resConsumable = resConsumable;
            }

            public boolean isUserConsumable() {
                return userConsumable;
            }

            public void setUserConsumable(boolean userConsumable) {
                this.userConsumable = userConsumable;
            }

            public Object getListenType() {
                return listenType;
            }

            public void setListenType(Object listenType) {
                this.listenType = listenType;
            }

            public Object getCannotListenReason() {
                return cannotListenReason;
            }

            public void setCannotListenReason(Object cannotListenReason) {
                this.cannotListenReason = cannotListenReason;
            }
        }

        public static class FreeTimeTrialPrivilegeBean {
            /**
             * resConsumable : false
             * userConsumable : false
             * type : 0
             * remainTime : 0
             */

            private boolean resConsumable;
            private boolean userConsumable;
            private int type;
            private int remainTime;

            public boolean isResConsumable() {
                return resConsumable;
            }

            public void setResConsumable(boolean resConsumable) {
                this.resConsumable = resConsumable;
            }

            public boolean isUserConsumable() {
                return userConsumable;
            }

            public void setUserConsumable(boolean userConsumable) {
                this.userConsumable = userConsumable;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getRemainTime() {
                return remainTime;
            }

            public void setRemainTime(int remainTime) {
                this.remainTime = remainTime;
            }
        }
    }
}
