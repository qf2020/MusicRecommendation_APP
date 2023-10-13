package cjk.design.music.onLineMusicBean;

import java.util.List;

public class UserMusicActionBean {
    /**
     * total : 1
     * rows : [{"userMusicActionId":1,"userId":1,"musicId":"1","listenHour":"12","pointTimes":"12"}]
     * code : 200
     * msg : 查询成功
     */

    private int total;
    private int code;
    private String msg;
    private List<RowsBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * userMusicActionId : 1
         * userId : 1
         * musicId : 1
         * listenHour : 12
         * pointTimes : 12
         */

        private int userMusicActionId;
        private int userId;
        private String musicId;
        private String listenHour;
        private String pointTimes;

        public RowsBean(int userId,String musicId,String listenHour,String pointTimes){
            this.userId = userId;
            this.musicId = musicId;
            this.listenHour = listenHour;
            this.pointTimes = pointTimes;
        }
        public int getUserMusicActionId() {
            return userMusicActionId;
        }

        public void setUserMusicActionId(int userMusicActionId) {
            this.userMusicActionId = userMusicActionId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getMusicId() {
            return musicId;
        }

        public void setMusicId(String musicId) {
            this.musicId = musicId;
        }

        public String getListenHour() {
            return listenHour;
        }

        public void setListenHour(String listenHour) {
            this.listenHour = listenHour;
        }

        public String getPointTimes() {
            return pointTimes;
        }

        public void setPointTimes(String pointTimes) {
            this.pointTimes = pointTimes;
        }
    }
}
