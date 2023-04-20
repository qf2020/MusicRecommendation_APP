package cjk.design.music.activity.ui.personal_information;

import java.util.List;

public class MusicListLikeBean {
    /**
     * total : 1
     * rows : [{"musicListId":1,"userId":1,"userMusiclistLikeId":123}]
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
         * musicListId : 1
         * userId : 1
         * userMusiclistLikeId : 123
         */

        private Long musicListId;
        private int userId;
        private Long userMusiclistLikeId;

        public RowsBean(Long musicListId,int userId){
            this.musicListId = musicListId;
            this.userId = userId;
        }
        public Long getMusicListId() {
            return musicListId;
        }

        public void setMusicListId(Long musicListId) {
            this.musicListId = musicListId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Long getUserMusiclistLikeId() {
            return userMusiclistLikeId;
        }

        public void setUserMusiclistLikeId(Long userMusiclistLikeId) {
            this.userMusiclistLikeId = userMusiclistLikeId;
        }
    }
}
