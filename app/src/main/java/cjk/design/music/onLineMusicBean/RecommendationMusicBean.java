package cjk.design.music.onLineMusicBean;

import java.util.List;

public class RecommendationMusicBean {
    /**
     * total : 30
     * rows : [{"userRecommendationId":121,"userId":3,"musicId":1400285170,"musicContent":null,"musicBack":null},{"userRecommendationId":122,"userId":3,"musicId":31877160,"musicContent":null,"musicBack":null},{"userRecommendationId":123,"userId":3,"musicId":1918915734,"musicContent":null,"musicBack":null},{"userRecommendationId":124,"userId":3,"musicId":28234434,"musicContent":null,"musicBack":null},{"userRecommendationId":125,"userId":3,"musicId":29819412,"musicContent":null,"musicBack":null},{"userRecommendationId":126,"userId":3,"musicId":27949887,"musicContent":null,"musicBack":null},{"userRecommendationId":127,"userId":3,"musicId":210049,"musicContent":null,"musicBack":null},{"userRecommendationId":128,"userId":3,"musicId":30482452,"musicContent":null,"musicBack":null},{"userRecommendationId":129,"userId":3,"musicId":5257205,"musicContent":null,"musicBack":null},{"userRecommendationId":130,"userId":3,"musicId":534511863,"musicContent":null,"musicBack":null}]
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
         * userRecommendationId : 121
         * userId : 3
         * musicId : 1400285170
         * musicContent : null
         * musicBack : null
         */

        private int userRecommendationId;
        private int userId;
        private int musicId;
        private Object musicContent;
        private Object musicBack;

        public int getUserRecommendationId() {
            return userRecommendationId;
        }

        public void setUserRecommendationId(int userRecommendationId) {
            this.userRecommendationId = userRecommendationId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getMusicId() {
            return musicId;
        }

        public void setMusicId(int musicId) {
            this.musicId = musicId;
        }

        public Object getMusicContent() {
            return musicContent;
        }

        public void setMusicContent(Object musicContent) {
            this.musicContent = musicContent;
        }

        public Object getMusicBack() {
            return musicBack;
        }

        public void setMusicBack(Object musicBack) {
            this.musicBack = musicBack;
        }
    }
}
