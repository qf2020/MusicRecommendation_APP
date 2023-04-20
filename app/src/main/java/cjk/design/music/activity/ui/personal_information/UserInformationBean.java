package cjk.design.music.activity.ui.personal_information;

import java.util.List;

public class UserInformationBean {
    /**
     * total : 1
     * rows : [{"userInformationId":1,"userId":1,"userName":"陈骏科","userSex":1,"userCover":null,"userAddress":null,"userBirthday":null,"userReserve1":null,"userReserve2":null}]
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
         * userInformationId : 1
         * userId : 1
         * userName : 陈骏科
         * userSex : 1
         * userCover : null
         * userAddress : null
         * userBirthday : null
         * userReserve1 : null
         * userReserve2 : null
         */

        private int userInformationId;
        private int userId;
        private String userName;
        private int userSex;
        private Object userCover;
        private String userAddress;
        private String userBirthday;
        private Object userReserve1;
        private Object userReserve2;

        public int getUserInformationId() {
            return userInformationId;
        }

        public void setUserInformationId(int userInformationId) {
            this.userInformationId = userInformationId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getUserSex() {
            return userSex;
        }

        public void setUserSex(int userSex) {
            this.userSex = userSex;
        }

        public Object getUserCover() {
            return userCover;
        }

        public void setUserCover(Object userCover) {
            this.userCover = userCover;
        }

        public String getUserAddress() {
            return userAddress;
        }

        public void setUserAddress(String userAddress) {
            this.userAddress = userAddress;
        }

        public String getUserBirthday() {
            return userBirthday;
        }

        public void setUserBirthday(String userBirthday) {
            this.userBirthday = userBirthday;
        }

        public Object getUserReserve1() {
            return userReserve1;
        }

        public void setUserReserve1(Object userReserve1) {
            this.userReserve1 = userReserve1;
        }

        public Object getUserReserve2() {
            return userReserve2;
        }

        public void setUserReserve2(Object userReserve2) {
            this.userReserve2 = userReserve2;
        }
    }
}
