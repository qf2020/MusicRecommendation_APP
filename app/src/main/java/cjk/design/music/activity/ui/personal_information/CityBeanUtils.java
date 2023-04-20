package cjk.design.music.activity.ui.personal_information;
import com.contrarywind.interfaces.IPickerViewData;

/**
 *
 * @description 对于city的get与set操作
 * @author guoxiaozhe
 * @time 2021/11/30 8:44
 * @email 1041347917@qq.com
 *
 */
public class CityBeanUtils implements IPickerViewData {
    private long id;
    private String name;
    private String code;
    private String province;
    private String city;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //这个用来显示在PickerView上面的字符串,PickerView会通过getPickerViewText方法获取字符串显示出来。
    @Override
    public String getPickerViewText() {
        return name;
    }
}
