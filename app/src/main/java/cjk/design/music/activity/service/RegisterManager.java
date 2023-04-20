package cjk.design.music.activity.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description 登录管理器
 * @author cjk
 * @time 2021/12/2 17:36
 */
public class RegisterManager {

    public String verifyCode;
    //BufferedReader fIn = null;

    public RegisterManager(){
        verifyCode="";
    }

    /**
     * @description 判断传来的电话号码是否是正常格式
     * @param phone:电话号码
     * @return Boolean类型
     * @author cjk
     * @time 2021/11/29 22:14
     */
    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            return m.matches();
        }

    }

    public void sendMessage(String phone) {
        Service haha = new Service(phone);
        this.verifyCode = haha.init();
    }
    /**
     * @description 判断电话号码是否正常，主要是为了隐藏底层函数
     * @param phone
     * @return boolean型
     * @author cjk
     * @time 2021/11/29 22:16
     */
    public boolean register(String phone) {
        if (isPhone(phone)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean registerOk(String phone, String verify) {
    //     if ((verify.equals(verifyCode)) & (user.phone.equals(phone))) {
            return true;
    //   } else {
    // 如果故意捣乱直接关掉呢
    //     return false;
    // }
    }





}
