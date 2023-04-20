package cjk.design.music.activity.ui.personal_information;

import java.io.Serializable;
import java.util.List;

public class MusicLikeBean implements Serializable {
    /**
     * total : 1
     * rows : [{"musicId":12,"userId":1,"userMusicLikeId":1}]
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
         * musicId : 12
         * userId : 1
         * userMusicLikeId : 1
         */

        private long musicId;
        private int userId;
        private int userMusicLikeId;

        public RowsBean(int userId,long musicId){
            this.musicId = musicId;
            this.userId = userId;
        }

        public long getMusicId() {
            return musicId;
        }

        public void setMusicId(long musicId) {
            this.musicId = musicId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getUserMusicLikeId() {
            return userMusicLikeId;
        }

        public void setUserMusicLikeId(int userMusicLikeId) {
            this.userMusicLikeId = userMusicLikeId;
        }
    }
}
