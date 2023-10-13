package cjk.design.music.activity.login;

import java.util.List;

public class LoginBean {

    /**
     * total : 1
     * rows : [{"userId":3,"phone":"13142180962","password":"123456Abc","userIdRec":null}]
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
         * userId : 3
         * phone : 13142180962
         * password : 123456Abc
         * userIdRec : null
         */

        private int userId;
        private String phone;
        private String password;
        private String userIdRec;

        public RowsBean(String phone,String password){
            this.phone = phone;
            this.password = password;
        }

        public RowsBean(int userId,String phone,String password,String userIdRec){
            this.userId = userId;
            this.phone = phone;
            this.password = password;
            this.userIdRec = userIdRec;
        }


        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserIdRec() {
            return userIdRec;
        }

        public void setUserIdRec(String userIdRec) {
            this.userIdRec = userIdRec;
        }
    }
}
