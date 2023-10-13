package cjk.design.music.activity.newMusic;

import java.util.List;

public class NewMusicBean {

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
         * starred : false
         * popularity : 5
         * starredNum : 0
         * playedNum : 0
         * dayPlays : 0
         * hearTime : 0
         * mp3Url : http://m2.music.126.net/hmZoNQaqzZALvVp0rE7faA==/0.mp3
         * rtUrls : null
         * status : 0
         * no : 1
         * disc : 01
         * audition : null
         * album : {"songs":[],"paid":false,"onSale":false,"status":1,"picId":109951168557512370,"artist":{"img1v1Id":18686200114669624,"topicPerson":0,"picId":0,"albumSize":0,"img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","followed":false,"alias":[],"musicSize":0,"briefDesc":"","trans":"","name":"","id":0,"img1v1Id_str":"18686200114669622"},"publishTime":1682006400000,"picUrl":"http://p4.music.126.net/H8ZbWI32Y7rDaYyAMlZ6-A==/109951168557512370.jpg","commentThreadId":"R_AL_3_164098642","tags":"","alias":["剧集《偶像漩涡》原声"],"artists":[{"img1v1Id":18686200114669624,"topicPerson":0,"picId":0,"albumSize":0,"img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","followed":false,"alias":[],"musicSize":0,"briefDesc":"","trans":"","name":"The Weeknd","id":185858,"img1v1Id_str":"18686200114669622"},{"img1v1Id":18686200114669624,"topicPerson":0,"picId":0,"albumSize":0,"img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picUrl":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","followed":false,"alias":[],"musicSize":0,"briefDesc":"","trans":"","name":"Future","id":33794,"img1v1Id_str":"18686200114669622"}],"company":"Republic Records","blurPicUrl":"http://p3.music.126.net/H8ZbWI32Y7rDaYyAMlZ6-A==/109951168557512370.jpg","companyId":0,"pic":109951168557512370,"copyrightId":7003,"briefDesc":"","subType":"录音室版","description":"","name":"Double Fantasy","id":164098642,"type":"Single","size":2,"picId_str":"109951168557512370"}
         * fee : 8
         * ringtone :
         * hMusic : {"bitrate":320000,"playTime":268235,"volumeDelta":-44500,"dfsId":0,"sr":44100,"name":null,"id":8057252905,"size":10732191,"extension":"mp3"}
         * mvid : 14620680
         * ftype : 0
         * rtype : 0
         * rurl : null
         * commentThreadId : R_SO_4_2040961321
         * alias : ["剧集《偶像漩涡》原声"]
         * artists : [{"img1v1Id":18686200114669624,"topicPerson":0,"picId":0,"albumSize":0,"img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picUrl":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","followed":false,"alias":[],"musicSize":0,"briefDesc":"","trans":"","name":"The Weeknd","id":185858,"img1v1Id_str":"18686200114669622"},{"img1v1Id":18686200114669624,"topicPerson":0,"picId":0,"albumSize":0,"img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","followed":false,"alias":[],"musicSize":0,"briefDesc":"","trans":"","name":"Future","id":33794,"img1v1Id_str":"18686200114669622"}]
         * score : 5
         * copyrightId : 7003
         * crbt : null
         * bMusic : {"bitrate":128000,"playTime":268235,"volumeDelta":-40216,"dfsId":0,"sr":44100,"name":null,"id":8057252904,"size":4292902,"extension":"mp3"}
         * rtUrl : null
         * mMusic : {"bitrate":192000,"playTime":268235,"volumeDelta":-41918,"dfsId":0,"sr":44100,"name":null,"id":8057252900,"size":6439332,"extension":"mp3"}
         * lMusic : {"bitrate":128000,"playTime":268235,"volumeDelta":-40216,"dfsId":0,"sr":44100,"name":null,"id":8057252904,"size":4292902,"extension":"mp3"}
         * copyFrom :
         * position : 0
         * duration : 268235
         * name : Double Fantasy
         * id : 2040961321
         * exclusive : false
         * privilege : {"id":2040961321,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":260,"preSell":false}
         */

        private boolean starred;
        private int popularity;
        private int starredNum;
        private int playedNum;
        private int dayPlays;
        private int hearTime;
        private String mp3Url;
        private Object rtUrls;
        private int status;
        private int no;
        private String disc;
        private Object audition;
        private AlbumBean album;
        private int fee;
        private String ringtone;
        private HMusicBean hMusic;
        private int mvid;
        private int ftype;
        private int rtype;
        private Object rurl;
        private String commentThreadId;
        private int score;
        private int copyrightId;
        private Object crbt;
        private BMusicBean bMusic;
        private Object rtUrl;
        private MMusicBean mMusic;
        private LMusicBean lMusic;
        private String copyFrom;
        private int position;
        private int duration;
        private String name;
        private int id;
        private boolean exclusive;
        private PrivilegeBean privilege;
        private List<String> alias;
        private List<ArtistsBeanX> artists;

        public boolean isStarred() {
            return starred;
        }

        public void setStarred(boolean starred) {
            this.starred = starred;
        }

        public int getPopularity() {
            return popularity;
        }

        public void setPopularity(int popularity) {
            this.popularity = popularity;
        }

        public int getStarredNum() {
            return starredNum;
        }

        public void setStarredNum(int starredNum) {
            this.starredNum = starredNum;
        }

        public int getPlayedNum() {
            return playedNum;
        }

        public void setPlayedNum(int playedNum) {
            this.playedNum = playedNum;
        }

        public int getDayPlays() {
            return dayPlays;
        }

        public void setDayPlays(int dayPlays) {
            this.dayPlays = dayPlays;
        }

        public int getHearTime() {
            return hearTime;
        }

        public void setHearTime(int hearTime) {
            this.hearTime = hearTime;
        }

        public String getMp3Url() {
            return mp3Url;
        }

        public void setMp3Url(String mp3Url) {
            this.mp3Url = mp3Url;
        }

        public Object getRtUrls() {
            return rtUrls;
        }

        public void setRtUrls(Object rtUrls) {
            this.rtUrls = rtUrls;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getDisc() {
            return disc;
        }

        public void setDisc(String disc) {
            this.disc = disc;
        }

        public Object getAudition() {
            return audition;
        }

        public void setAudition(Object audition) {
            this.audition = audition;
        }

        public AlbumBean getAlbum() {
            return album;
        }

        public void setAlbum(AlbumBean album) {
            this.album = album;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public String getRingtone() {
            return ringtone;
        }

        public void setRingtone(String ringtone) {
            this.ringtone = ringtone;
        }

        public HMusicBean getHMusic() {
            return hMusic;
        }

        public void setHMusic(HMusicBean hMusic) {
            this.hMusic = hMusic;
        }

        public int getMvid() {
            return mvid;
        }

        public void setMvid(int mvid) {
            this.mvid = mvid;
        }

        public int getFtype() {
            return ftype;
        }

        public void setFtype(int ftype) {
            this.ftype = ftype;
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

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getCopyrightId() {
            return copyrightId;
        }

        public void setCopyrightId(int copyrightId) {
            this.copyrightId = copyrightId;
        }

        public Object getCrbt() {
            return crbt;
        }

        public void setCrbt(Object crbt) {
            this.crbt = crbt;
        }

        public BMusicBean getBMusic() {
            return bMusic;
        }

        public void setBMusic(BMusicBean bMusic) {
            this.bMusic = bMusic;
        }

        public Object getRtUrl() {
            return rtUrl;
        }

        public void setRtUrl(Object rtUrl) {
            this.rtUrl = rtUrl;
        }

        public MMusicBean getMMusic() {
            return mMusic;
        }

        public void setMMusic(MMusicBean mMusic) {
            this.mMusic = mMusic;
        }

        public LMusicBean getLMusic() {
            return lMusic;
        }

        public void setLMusic(LMusicBean lMusic) {
            this.lMusic = lMusic;
        }

        public String getCopyFrom() {
            return copyFrom;
        }

        public void setCopyFrom(String copyFrom) {
            this.copyFrom = copyFrom;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

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

        public boolean isExclusive() {
            return exclusive;
        }

        public void setExclusive(boolean exclusive) {
            this.exclusive = exclusive;
        }

        public PrivilegeBean getPrivilege() {
            return privilege;
        }

        public void setPrivilege(PrivilegeBean privilege) {
            this.privilege = privilege;
        }

        public List<String> getAlias() {
            return alias;
        }

        public void setAlias(List<String> alias) {
            this.alias = alias;
        }

        public List<ArtistsBeanX> getArtists() {
            return artists;
        }

        public void setArtists(List<ArtistsBeanX> artists) {
            this.artists = artists;
        }

        public static class AlbumBean {
            /**
             * songs : []
             * paid : false
             * onSale : false
             * status : 1
             * picId : 109951168557512370
             * artist : {"img1v1Id":18686200114669624,"topicPerson":0,"picId":0,"albumSize":0,"img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","followed":false,"alias":[],"musicSize":0,"briefDesc":"","trans":"","name":"","id":0,"img1v1Id_str":"18686200114669622"}
             * publishTime : 1682006400000
             * picUrl : http://p4.music.126.net/H8ZbWI32Y7rDaYyAMlZ6-A==/109951168557512370.jpg
             * commentThreadId : R_AL_3_164098642
             * tags :
             * alias : ["剧集《偶像漩涡》原声"]
             * artists : [{"img1v1Id":18686200114669624,"topicPerson":0,"picId":0,"albumSize":0,"img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","followed":false,"alias":[],"musicSize":0,"briefDesc":"","trans":"","name":"The Weeknd","id":185858,"img1v1Id_str":"18686200114669622"},{"img1v1Id":18686200114669624,"topicPerson":0,"picId":0,"albumSize":0,"img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picUrl":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","followed":false,"alias":[],"musicSize":0,"briefDesc":"","trans":"","name":"Future","id":33794,"img1v1Id_str":"18686200114669622"}]
             * company : Republic Records
             * blurPicUrl : http://p3.music.126.net/H8ZbWI32Y7rDaYyAMlZ6-A==/109951168557512370.jpg
             * companyId : 0
             * pic : 109951168557512370
             * copyrightId : 7003
             * briefDesc :
             * subType : 录音室版
             * description :
             * name : Double Fantasy
             * id : 164098642
             * type : Single
             * size : 2
             * picId_str : 109951168557512370
             */

            private boolean paid;
            private boolean onSale;
            private int status;
            private long picId;
            private ArtistBean artist;
            private long publishTime;
            private String picUrl;
            private String commentThreadId;
            private String tags;
            private String company;
            private String blurPicUrl;
            private int companyId;
            private long pic;
            private int copyrightId;
            private String briefDesc;
            private String subType;
            private String description;
            private String name;
            private int id;
            private String type;
            private int size;
            private String picId_str;
            private List<?> songs;
            private List<String> alias;
            private List<ArtistsBean> artists;

            public boolean isPaid() {
                return paid;
            }

            public void setPaid(boolean paid) {
                this.paid = paid;
            }

            public boolean isOnSale() {
                return onSale;
            }

            public void setOnSale(boolean onSale) {
                this.onSale = onSale;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public long getPicId() {
                return picId;
            }

            public void setPicId(long picId) {
                this.picId = picId;
            }

            public ArtistBean getArtist() {
                return artist;
            }

            public void setArtist(ArtistBean artist) {
                this.artist = artist;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getCommentThreadId() {
                return commentThreadId;
            }

            public void setCommentThreadId(String commentThreadId) {
                this.commentThreadId = commentThreadId;
            }

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getBlurPicUrl() {
                return blurPicUrl;
            }

            public void setBlurPicUrl(String blurPicUrl) {
                this.blurPicUrl = blurPicUrl;
            }

            public int getCompanyId() {
                return companyId;
            }

            public void setCompanyId(int companyId) {
                this.companyId = companyId;
            }

            public long getPic() {
                return pic;
            }

            public void setPic(long pic) {
                this.pic = pic;
            }

            public int getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(int copyrightId) {
                this.copyrightId = copyrightId;
            }

            public String getBriefDesc() {
                return briefDesc;
            }

            public void setBriefDesc(String briefDesc) {
                this.briefDesc = briefDesc;
            }

            public String getSubType() {
                return subType;
            }

            public void setSubType(String subType) {
                this.subType = subType;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getPicId_str() {
                return picId_str;
            }

            public void setPicId_str(String picId_str) {
                this.picId_str = picId_str;
            }

            public List<?> getSongs() {
                return songs;
            }

            public void setSongs(List<?> songs) {
                this.songs = songs;
            }

            public List<String> getAlias() {
                return alias;
            }

            public void setAlias(List<String> alias) {
                this.alias = alias;
            }

            public List<ArtistsBean> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsBean> artists) {
                this.artists = artists;
            }

            public static class ArtistBean {
                /**
                 * img1v1Id : 18686200114669624
                 * topicPerson : 0
                 * picId : 0
                 * albumSize : 0
                 * img1v1Url : http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
                 * picUrl : http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * followed : false
                 * alias : []
                 * musicSize : 0
                 * briefDesc :
                 * trans :
                 * name :
                 * id : 0
                 * img1v1Id_str : 18686200114669622
                 */

                private long img1v1Id;
                private int topicPerson;
                private int picId;
                private int albumSize;
                private String img1v1Url;
                private String picUrl;
                private boolean followed;
                private int musicSize;
                private String briefDesc;
                private String trans;
                private String name;
                private int id;
                private String img1v1Id_str;
                private List<?> alias;

                public long getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(long img1v1Id) {
                    this.img1v1Id = img1v1Id;
                }

                public int getTopicPerson() {
                    return topicPerson;
                }

                public void setTopicPerson(int topicPerson) {
                    this.topicPerson = topicPerson;
                }

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public boolean isFollowed() {
                    return followed;
                }

                public void setFollowed(boolean followed) {
                    this.followed = followed;
                }

                public int getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(int musicSize) {
                    this.musicSize = musicSize;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public String getTrans() {
                    return trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

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

                public String getImg1v1Id_str() {
                    return img1v1Id_str;
                }

                public void setImg1v1Id_str(String img1v1Id_str) {
                    this.img1v1Id_str = img1v1Id_str;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }

            public static class ArtistsBean {
                /**
                 * img1v1Id : 18686200114669624
                 * topicPerson : 0
                 * picId : 0
                 * albumSize : 0
                 * img1v1Url : http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
                 * picUrl : http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * followed : false
                 * alias : []
                 * musicSize : 0
                 * briefDesc :
                 * trans :
                 * name : The Weeknd
                 * id : 185858
                 * img1v1Id_str : 18686200114669622
                 */

                private long img1v1Id;
                private int topicPerson;
                private int picId;
                private int albumSize;
                private String img1v1Url;
                private String picUrl;
                private boolean followed;
                private int musicSize;
                private String briefDesc;
                private String trans;
                private String name;
                private int id;
                private String img1v1Id_str;
                private List<?> alias;

                public long getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(long img1v1Id) {
                    this.img1v1Id = img1v1Id;
                }

                public int getTopicPerson() {
                    return topicPerson;
                }

                public void setTopicPerson(int topicPerson) {
                    this.topicPerson = topicPerson;
                }

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public boolean isFollowed() {
                    return followed;
                }

                public void setFollowed(boolean followed) {
                    this.followed = followed;
                }

                public int getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(int musicSize) {
                    this.musicSize = musicSize;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public String getTrans() {
                    return trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

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

                public String getImg1v1Id_str() {
                    return img1v1Id_str;
                }

                public void setImg1v1Id_str(String img1v1Id_str) {
                    this.img1v1Id_str = img1v1Id_str;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }
        }

        public static class HMusicBean {
            /**
             * bitrate : 320000
             * playTime : 268235
             * volumeDelta : -44500
             * dfsId : 0
             * sr : 44100
             * name : null
             * id : 8057252905
             * size : 10732191
             * extension : mp3
             */

            private int bitrate;
            private int playTime;
            private int volumeDelta;
            private int dfsId;
            private int sr;
            private Object name;
            private long id;
            private int size;
            private String extension;

            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }

            public int getVolumeDelta() {
                return volumeDelta;
            }

            public void setVolumeDelta(int volumeDelta) {
                this.volumeDelta = volumeDelta;
            }

            public int getDfsId() {
                return dfsId;
            }

            public void setDfsId(int dfsId) {
                this.dfsId = dfsId;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }
        }

        public static class BMusicBean {
            /**
             * bitrate : 128000
             * playTime : 268235
             * volumeDelta : -40216
             * dfsId : 0
             * sr : 44100
             * name : null
             * id : 8057252904
             * size : 4292902
             * extension : mp3
             */

            private int bitrate;
            private int playTime;
            private int volumeDelta;
            private int dfsId;
            private int sr;
            private Object name;
            private long id;
            private int size;
            private String extension;

            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }

            public int getVolumeDelta() {
                return volumeDelta;
            }

            public void setVolumeDelta(int volumeDelta) {
                this.volumeDelta = volumeDelta;
            }

            public int getDfsId() {
                return dfsId;
            }

            public void setDfsId(int dfsId) {
                this.dfsId = dfsId;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }
        }

        public static class MMusicBean {
            /**
             * bitrate : 192000
             * playTime : 268235
             * volumeDelta : -41918
             * dfsId : 0
             * sr : 44100
             * name : null
             * id : 8057252900
             * size : 6439332
             * extension : mp3
             */

            private int bitrate;
            private int playTime;
            private int volumeDelta;
            private int dfsId;
            private int sr;
            private Object name;
            private long id;
            private int size;
            private String extension;

            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }

            public int getVolumeDelta() {
                return volumeDelta;
            }

            public void setVolumeDelta(int volumeDelta) {
                this.volumeDelta = volumeDelta;
            }

            public int getDfsId() {
                return dfsId;
            }

            public void setDfsId(int dfsId) {
                this.dfsId = dfsId;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }
        }

        public static class LMusicBean {
            /**
             * bitrate : 128000
             * playTime : 268235
             * volumeDelta : -40216
             * dfsId : 0
             * sr : 44100
             * name : null
             * id : 8057252904
             * size : 4292902
             * extension : mp3
             */

            private int bitrate;
            private int playTime;
            private int volumeDelta;
            private int dfsId;
            private int sr;
            private Object name;
            private long id;
            private int size;
            private String extension;

            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }

            public int getVolumeDelta() {
                return volumeDelta;
            }

            public void setVolumeDelta(int volumeDelta) {
                this.volumeDelta = volumeDelta;
            }

            public int getDfsId() {
                return dfsId;
            }

            public void setDfsId(int dfsId) {
                this.dfsId = dfsId;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }
        }

        public static class PrivilegeBean {
            /**
             * id : 2040961321
             * fee : 8
             * payed : 0
             * st : 0
             * pl : 128000
             * dl : 0
             * sp : 7
             * cp : 1
             * subp : 1
             * cs : false
             * maxbr : 999000
             * fl : 128000
             * toast : false
             * flag : 260
             * preSell : false
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
        }

        public static class ArtistsBeanX {
            /**
             * img1v1Id : 18686200114669624
             * topicPerson : 0
             * picId : 0
             * albumSize : 0
             * img1v1Url : http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
             * picUrl : http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
             * followed : false
             * alias : []
             * musicSize : 0
             * briefDesc :
             * trans :
             * name : The Weeknd
             * id : 185858
             * img1v1Id_str : 18686200114669622
             */

            private long img1v1Id;
            private int topicPerson;
            private int picId;
            private int albumSize;
            private String img1v1Url;
            private String picUrl;
            private boolean followed;
            private int musicSize;
            private String briefDesc;
            private String trans;
            private String name;
            private int id;
            private String img1v1Id_str;
            private List<?> alias;

            public long getImg1v1Id() {
                return img1v1Id;
            }

            public void setImg1v1Id(long img1v1Id) {
                this.img1v1Id = img1v1Id;
            }

            public int getTopicPerson() {
                return topicPerson;
            }

            public void setTopicPerson(int topicPerson) {
                this.topicPerson = topicPerson;
            }

            public int getPicId() {
                return picId;
            }

            public void setPicId(int picId) {
                this.picId = picId;
            }

            public int getAlbumSize() {
                return albumSize;
            }

            public void setAlbumSize(int albumSize) {
                this.albumSize = albumSize;
            }

            public String getImg1v1Url() {
                return img1v1Url;
            }

            public void setImg1v1Url(String img1v1Url) {
                this.img1v1Url = img1v1Url;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public int getMusicSize() {
                return musicSize;
            }

            public void setMusicSize(int musicSize) {
                this.musicSize = musicSize;
            }

            public String getBriefDesc() {
                return briefDesc;
            }

            public void setBriefDesc(String briefDesc) {
                this.briefDesc = briefDesc;
            }

            public String getTrans() {
                return trans;
            }

            public void setTrans(String trans) {
                this.trans = trans;
            }

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

            public String getImg1v1Id_str() {
                return img1v1Id_str;
            }

            public void setImg1v1Id_str(String img1v1Id_str) {
                this.img1v1Id_str = img1v1Id_str;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }
        }
    }
}
