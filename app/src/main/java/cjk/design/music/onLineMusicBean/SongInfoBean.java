package cjk.design.music.onLineMusicBean;

import java.util.List;

public class SongInfoBean {
    /**
     * songs : [{"name":"海阔天空","id":347230,"pst":0,"t":0,"ar":[{"id":11127,"name":"Beyond","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"600902000004240302","fee":1,"v":114,"crbt":null,"cf":"","al":{"id":34209,"name":"海阔天空","picUrl":"https://p2.music.126.net/8y8KJC1eCSO_vUKf2MyZwA==/109951165796899183.jpg","tns":[],"pic_str":"109951165796899183","pic":109951165796899180},"dt":326000,"h":{"br":320001,"fid":0,"size":13042460,"vd":-5649,"sr":44100},"m":{"br":192001,"fid":0,"size":7825493,"vd":-3083,"sr":44100},"l":{"br":128001,"fid":0,"size":5217010,"vd":-1486,"sr":44100},"sq":{"br":798710,"fid":0,"size":32547445,"vd":-5639,"sr":44100},"hr":null,"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":8192,"originCoverType":1,"originSongSimpleData":null,"tagPicList":null,"resourceState":true,"version":114,"songJumpInfo":null,"entertainmentTags":null,"awardTags":null,"single":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7002,"mv":376199,"publishTime":747504000000}]
     * privileges : [{"id":347230,"fee":1,"payed":0,"st":0,"pl":0,"dl":0,"sp":0,"cp":0,"subp":0,"cs":false,"maxbr":999000,"fl":0,"toast":false,"flag":260,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000,"maxBrLevel":"lossless","playMaxBrLevel":"lossless","downloadMaxBrLevel":"lossless","plLevel":"none","dlLevel":"none","flLevel":"none","rscl":null,"freeTrialPrivilege":{"resConsumable":true,"userConsumable":false,"listenType":null},"chargeInfoList":[{"rate":128000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":192000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":320000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":999000,"chargeUrl":null,"chargeMessage":null,"chargeType":1}]}]
     * code : 200
     */

    private int code;
    private List<SongsBean> songs;
    private List<PrivilegesBean> privileges;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<SongsBean> getSongs() {
        return songs;
    }

    public void setSongs(List<SongsBean> songs) {
        this.songs = songs;
    }

    public List<PrivilegesBean> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegesBean> privileges) {
        this.privileges = privileges;
    }

    public static class SongsBean {
        /**
         * name : 海阔天空
         * id : 347230
         * pst : 0
         * t : 0
         * ar : [{"id":11127,"name":"Beyond","tns":[],"alias":[]}]
         * alia : []
         * pop : 100
         * st : 0
         * rt : 600902000004240302
         * fee : 1
         * v : 114
         * crbt : null
         * cf :
         * al : {"id":34209,"name":"海阔天空","picUrl":"https://p2.music.126.net/8y8KJC1eCSO_vUKf2MyZwA==/109951165796899183.jpg","tns":[],"pic_str":"109951165796899183","pic":109951165796899180}
         * dt : 326000
         * h : {"br":320001,"fid":0,"size":13042460,"vd":-5649,"sr":44100}
         * m : {"br":192001,"fid":0,"size":7825493,"vd":-3083,"sr":44100}
         * l : {"br":128001,"fid":0,"size":5217010,"vd":-1486,"sr":44100}
         * sq : {"br":798710,"fid":0,"size":32547445,"vd":-5639,"sr":44100}
         * hr : null
         * a : null
         * cd : 1
         * no : 1
         * rtUrl : null
         * ftype : 0
         * rtUrls : []
         * djId : 0
         * copyright : 1
         * s_id : 0
         * mark : 8192
         * originCoverType : 1
         * originSongSimpleData : null
         * tagPicList : null
         * resourceState : true
         * version : 114
         * songJumpInfo : null
         * entertainmentTags : null
         * awardTags : null
         * single : 0
         * noCopyrightRcmd : null
         * rtype : 0
         * rurl : null
         * mst : 9
         * cp : 7002
         * mv : 376199
         * publishTime : 747504000000
         */

        private String name;
        private int id;
        private int pst;
        private int t;
        private int pop;
        private int st;
        private String rt;
        private int fee;
        private int v;
        private Object crbt;
        private String cf;
        private AlBean al;
        private int dt;
        private HBean h;
        private MBean m;
        private LBean l;
        private SqBean sq;
        private Object hr;
        private Object a;
        private String cd;
        private int no;
        private Object rtUrl;
        private int ftype;
        private int djId;
        private int copyright;
        private int s_id;
        private int mark;
        private int originCoverType;
        private Object originSongSimpleData;
        private Object tagPicList;
        private boolean resourceState;
        private int version;
        private Object songJumpInfo;
        private Object entertainmentTags;
        private Object awardTags;
        private int single;
        private Object noCopyrightRcmd;
        private int rtype;
        private Object rurl;
        private int mst;
        private int cp;
        private int mv;
        private long publishTime;
        private List<ArBean> ar;
        private List<?> alia;
        private List<?> rtUrls;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPst() {
            return pst;
        }

        public void setPst(int pst) {
            this.pst = pst;
        }

        public int getT() {
            return t;
        }

        public void setT(int t) {
            this.t = t;
        }

        public int getPop() {
            return pop;
        }

        public void setPop(int pop) {
            this.pop = pop;
        }

        public int getSt() {
            return st;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public String getRt() {
            return rt;
        }

        public void setRt(String rt) {
            this.rt = rt;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public Object getCrbt() {
            return crbt;
        }

        public void setCrbt(Object crbt) {
            this.crbt = crbt;
        }

        public String getCf() {
            return cf;
        }

        public void setCf(String cf) {
            this.cf = cf;
        }

        public AlBean getAl() {
            return al;
        }

        public void setAl(AlBean al) {
            this.al = al;
        }

        public int getDt() {
            return dt;
        }

        public void setDt(int dt) {
            this.dt = dt;
        }

        public HBean getH() {
            return h;
        }

        public void setH(HBean h) {
            this.h = h;
        }

        public MBean getM() {
            return m;
        }

        public void setM(MBean m) {
            this.m = m;
        }

        public LBean getL() {
            return l;
        }

        public void setL(LBean l) {
            this.l = l;
        }

        public SqBean getSq() {
            return sq;
        }

        public void setSq(SqBean sq) {
            this.sq = sq;
        }

        public Object getHr() {
            return hr;
        }

        public void setHr(Object hr) {
            this.hr = hr;
        }

        public Object getA() {
            return a;
        }

        public void setA(Object a) {
            this.a = a;
        }

        public String getCd() {
            return cd;
        }

        public void setCd(String cd) {
            this.cd = cd;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public Object getRtUrl() {
            return rtUrl;
        }

        public void setRtUrl(Object rtUrl) {
            this.rtUrl = rtUrl;
        }

        public int getFtype() {
            return ftype;
        }

        public void setFtype(int ftype) {
            this.ftype = ftype;
        }

        public int getDjId() {
            return djId;
        }

        public void setDjId(int djId) {
            this.djId = djId;
        }

        public int getCopyright() {
            return copyright;
        }

        public void setCopyright(int copyright) {
            this.copyright = copyright;
        }

        public int getS_id() {
            return s_id;
        }

        public void setS_id(int s_id) {
            this.s_id = s_id;
        }

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }

        public int getOriginCoverType() {
            return originCoverType;
        }

        public void setOriginCoverType(int originCoverType) {
            this.originCoverType = originCoverType;
        }

        public Object getOriginSongSimpleData() {
            return originSongSimpleData;
        }

        public void setOriginSongSimpleData(Object originSongSimpleData) {
            this.originSongSimpleData = originSongSimpleData;
        }

        public Object getTagPicList() {
            return tagPicList;
        }

        public void setTagPicList(Object tagPicList) {
            this.tagPicList = tagPicList;
        }

        public boolean isResourceState() {
            return resourceState;
        }

        public void setResourceState(boolean resourceState) {
            this.resourceState = resourceState;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public Object getSongJumpInfo() {
            return songJumpInfo;
        }

        public void setSongJumpInfo(Object songJumpInfo) {
            this.songJumpInfo = songJumpInfo;
        }

        public Object getEntertainmentTags() {
            return entertainmentTags;
        }

        public void setEntertainmentTags(Object entertainmentTags) {
            this.entertainmentTags = entertainmentTags;
        }

        public Object getAwardTags() {
            return awardTags;
        }

        public void setAwardTags(Object awardTags) {
            this.awardTags = awardTags;
        }

        public int getSingle() {
            return single;
        }

        public void setSingle(int single) {
            this.single = single;
        }

        public Object getNoCopyrightRcmd() {
            return noCopyrightRcmd;
        }

        public void setNoCopyrightRcmd(Object noCopyrightRcmd) {
            this.noCopyrightRcmd = noCopyrightRcmd;
        }

        public int getRtype() {
            return rtype;
        }

        public void setRtype(int rtype) {
            this.rtype = rtype;
        }

        public Object getRurl() {
            return rurl;
        }

        public void setRurl(Object rurl) {
            this.rurl = rurl;
        }

        public int getMst() {
            return mst;
        }

        public void setMst(int mst) {
            this.mst = mst;
        }

        public int getCp() {
            return cp;
        }

        public void setCp(int cp) {
            this.cp = cp;
        }

        public int getMv() {
            return mv;
        }

        public void setMv(int mv) {
            this.mv = mv;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public List<ArBean> getAr() {
            return ar;
        }

        public void setAr(List<ArBean> ar) {
            this.ar = ar;
        }

        public List<?> getAlia() {
            return alia;
        }

        public void setAlia(List<?> alia) {
            this.alia = alia;
        }

        public List<?> getRtUrls() {
            return rtUrls;
        }

        public void setRtUrls(List<?> rtUrls) {
            this.rtUrls = rtUrls;
        }

        public static class AlBean {
            /**
             * id : 34209
             * name : 海阔天空
             * picUrl : https://p2.music.126.net/8y8KJC1eCSO_vUKf2MyZwA==/109951165796899183.jpg
             * tns : []
             * pic_str : 109951165796899183
             * pic : 109951165796899180
             */

            private int id;
            private String name;
            private String picUrl;
            private String pic_str;
            private long pic;
            private List<?> tns;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getPic_str() {
                return pic_str;
            }

            public void setPic_str(String pic_str) {
                this.pic_str = pic_str;
            }

            public long getPic() {
                return pic;
            }

            public void setPic(long pic) {
                this.pic = pic;
            }

            public List<?> getTns() {
                return tns;
            }

            public void setTns(List<?> tns) {
                this.tns = tns;
            }
        }

        public static class HBean {
            /**
             * br : 320001
             * fid : 0
             * size : 13042460
             * vd : -5649
             * sr : 44100
             */

            private int br;
            private int fid;
            private int size;
            private int vd;
            private int sr;

            public int getBr() {
                return br;
            }

            public void setBr(int br) {
                this.br = br;
            }

            public int getFid() {
                return fid;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getVd() {
                return vd;
            }

            public void setVd(int vd) {
                this.vd = vd;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }
        }

        public static class MBean {
            /**
             * br : 192001
             * fid : 0
             * size : 7825493
             * vd : -3083
             * sr : 44100
             */

            private int br;
            private int fid;
            private int size;
            private int vd;
            private int sr;

            public int getBr() {
                return br;
            }

            public void setBr(int br) {
                this.br = br;
            }

            public int getFid() {
                return fid;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getVd() {
                return vd;
            }

            public void setVd(int vd) {
                this.vd = vd;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }
        }

        public static class LBean {
            /**
             * br : 128001
             * fid : 0
             * size : 5217010
             * vd : -1486
             * sr : 44100
             */

            private int br;
            private int fid;
            private int size;
            private int vd;
            private int sr;

            public int getBr() {
                return br;
            }

            public void setBr(int br) {
                this.br = br;
            }

            public int getFid() {
                return fid;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getVd() {
                return vd;
            }

            public void setVd(int vd) {
                this.vd = vd;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }
        }

        public static class SqBean {
            /**
             * br : 798710
             * fid : 0
             * size : 32547445
             * vd : -5639
             * sr : 44100
             */

            private int br;
            private int fid;
            private int size;
            private int vd;
            private int sr;

            public int getBr() {
                return br;
            }

            public void setBr(int br) {
                this.br = br;
            }

            public int getFid() {
                return fid;
            }

            public void setFid(int fid) {
                this.fid = fid;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getVd() {
                return vd;
            }

            public void setVd(int vd) {
                this.vd = vd;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }
        }

        public static class ArBean {
            /**
             * id : 11127
             * name : Beyond
             * tns : []
             * alias : []
             */

            private int id;
            private String name;
            private List<?> tns;
            private List<?> alias;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<?> getTns() {
                return tns;
            }

            public void setTns(List<?> tns) {
                this.tns = tns;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }
        }
    }

    public static class PrivilegesBean {
        /**
         * id : 347230
         * fee : 1
         * payed : 0
         * st : 0
         * pl : 0
         * dl : 0
         * sp : 0
         * cp : 0
         * subp : 0
         * cs : false
         * maxbr : 999000
         * fl : 0
         * toast : false
         * flag : 260
         * preSell : false
         * playMaxbr : 999000
         * downloadMaxbr : 999000
         * maxBrLevel : lossless
         * playMaxBrLevel : lossless
         * downloadMaxBrLevel : lossless
         * plLevel : none
         * dlLevel : none
         * flLevel : none
         * rscl : null
         * freeTrialPrivilege : {"resConsumable":true,"userConsumable":false,"listenType":null}
         * chargeInfoList : [{"rate":128000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":192000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":320000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":999000,"chargeUrl":null,"chargeMessage":null,"chargeType":1}]
         */

        private int id;
        private int fee;
        private int payed;
        private int st;
        private int pl;
        private int dl;
        private int sp;
        private int cp;
        private int subp;
        private boolean cs;
        private int maxbr;
        private int fl;
        private boolean toast;
        private int flag;
        private boolean preSell;
        private int playMaxbr;
        private int downloadMaxbr;
        private String maxBrLevel;
        private String playMaxBrLevel;
        private String downloadMaxBrLevel;
        private String plLevel;
        private String dlLevel;
        private String flLevel;
        private Object rscl;
        private FreeTrialPrivilegeBean freeTrialPrivilege;
        private List<ChargeInfoListBean> chargeInfoList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getPayed() {
            return payed;
        }

        public void setPayed(int payed) {
            this.payed = payed;
        }

        public int getSt() {
            return st;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public int getPl() {
            return pl;
        }

        public void setPl(int pl) {
            this.pl = pl;
        }

        public int getDl() {
            return dl;
        }

        public void setDl(int dl) {
            this.dl = dl;
        }

        public int getSp() {
            return sp;
        }

        public void setSp(int sp) {
            this.sp = sp;
        }

        public int getCp() {
            return cp;
        }

        public void setCp(int cp) {
            this.cp = cp;
        }

        public int getSubp() {
            return subp;
        }

        public void setSubp(int subp) {
            this.subp = subp;
        }

        public boolean isCs() {
            return cs;
        }

        public void setCs(boolean cs) {
            this.cs = cs;
        }

        public int getMaxbr() {
            return maxbr;
        }

        public void setMaxbr(int maxbr) {
            this.maxbr = maxbr;
        }

        public int getFl() {
            return fl;
        }

        public void setFl(int fl) {
            this.fl = fl;
        }

        public boolean isToast() {
            return toast;
        }

        public void setToast(boolean toast) {
            this.toast = toast;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public boolean isPreSell() {
            return preSell;
        }

        public void setPreSell(boolean preSell) {
            this.preSell = preSell;
        }

        public int getPlayMaxbr() {
            return playMaxbr;
        }

        public void setPlayMaxbr(int playMaxbr) {
            this.playMaxbr = playMaxbr;
        }

        public int getDownloadMaxbr() {
            return downloadMaxbr;
        }

        public void setDownloadMaxbr(int downloadMaxbr) {
            this.downloadMaxbr = downloadMaxbr;
        }

        public String getMaxBrLevel() {
            return maxBrLevel;
        }

        public void setMaxBrLevel(String maxBrLevel) {
            this.maxBrLevel = maxBrLevel;
        }

        public String getPlayMaxBrLevel() {
            return playMaxBrLevel;
        }

        public void setPlayMaxBrLevel(String playMaxBrLevel) {
            this.playMaxBrLevel = playMaxBrLevel;
        }

        public String getDownloadMaxBrLevel() {
            return downloadMaxBrLevel;
        }

        public void setDownloadMaxBrLevel(String downloadMaxBrLevel) {
            this.downloadMaxBrLevel = downloadMaxBrLevel;
        }

        public String getPlLevel() {
            return plLevel;
        }

        public void setPlLevel(String plLevel) {
            this.plLevel = plLevel;
        }

        public String getDlLevel() {
            return dlLevel;
        }

        public void setDlLevel(String dlLevel) {
            this.dlLevel = dlLevel;
        }

        public String getFlLevel() {
            return flLevel;
        }

        public void setFlLevel(String flLevel) {
            this.flLevel = flLevel;
        }

        public Object getRscl() {
            return rscl;
        }

        public void setRscl(Object rscl) {
            this.rscl = rscl;
        }

        public FreeTrialPrivilegeBean getFreeTrialPrivilege() {
            return freeTrialPrivilege;
        }

        public void setFreeTrialPrivilege(FreeTrialPrivilegeBean freeTrialPrivilege) {
            this.freeTrialPrivilege = freeTrialPrivilege;
        }

        public List<ChargeInfoListBean> getChargeInfoList() {
            return chargeInfoList;
        }

        public void setChargeInfoList(List<ChargeInfoListBean> chargeInfoList) {
            this.chargeInfoList = chargeInfoList;
        }

        public static class FreeTrialPrivilegeBean {
            /**
             * resConsumable : true
             * userConsumable : false
             * listenType : null
             */

            private boolean resConsumable;
            private boolean userConsumable;
            private Object listenType;

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
        }

        public static class ChargeInfoListBean {
            /**
             * rate : 128000
             * chargeUrl : null
             * chargeMessage : null
             * chargeType : 1
             */

            private int rate;
            private Object chargeUrl;
            private Object chargeMessage;
            private int chargeType;

            public int getRate() {
                return rate;
            }

            public void setRate(int rate) {
                this.rate = rate;
            }

            public Object getChargeUrl() {
                return chargeUrl;
            }

            public void setChargeUrl(Object chargeUrl) {
                this.chargeUrl = chargeUrl;
            }

            public Object getChargeMessage() {
                return chargeMessage;
            }

            public void setChargeMessage(Object chargeMessage) {
                this.chargeMessage = chargeMessage;
            }

            public int getChargeType() {
                return chargeType;
            }

            public void setChargeType(int chargeType) {
                this.chargeType = chargeType;
            }
        }
    }
}
