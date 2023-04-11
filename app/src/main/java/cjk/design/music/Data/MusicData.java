package cjk.design.music.Data;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import cjk.design.music.R;
import cjk.design.music.model.Music;

public class MusicData {
    public List<Music> musicList = new ArrayList<>();
    public MusicData(){
        Uri setDataSourceuri = Uri.parse("android.resource://cjk.design.music/"+ R.raw.yanyuan_xuezhiqian);
        musicList.add(
                new Music((long)1,1,01,"演员","薛之谦","热血专辑",01,
                        "http://p2.music.126.net/oS3ZLQ66uGPMnnOJDzDlBw==/19093019417022416.jpg",344000,
                        setDataSourceuri.toString(),null,100,null)
        );
        musicList.add(
                new Music((long)1,1,02,"你的名字","袁娅维","热血专辑",02,
                        "https://img.zcool.cn/community/0193b9599c0626a80120179466c7bd.jpg@1280w_1l_2o_100sh.jpg",344000,
                        setDataSourceuri.toString(),null,100,null)
        );
        musicList.add(
                new Music((long)1,1,03,"不期而遇的夏天","陈奕迅","热血专辑",03,
                        "https://img.zcool.cn/community/01d65c5544b8770000019ae9c15029.jpg@1280w_1l_2o_100sh.jpg",344000,
                        setDataSourceuri.toString(),null,100,null)
        );
        musicList.add(
                new Music((long)1,1,04,"让浪漫作主","蔡健雅","热血专辑",04,
                        "https://img.sj33.cn/uploads/allimg/201508/7-150P4221924.jpg",344000,
                        setDataSourceuri.toString(),null,100,null)
        );
        musicList.add(
                new Music((long)1,1,05,"刻在我心底的名字","五月天","热血专辑",05,
                        "https://img.zcool.cn/community/01fd635e875573a801216518e19acd.png@2o.png",344000,
                        setDataSourceuri.toString(),null,100,null)
        );
        musicList.add(
                new Music((long)1,1,06,"普通爱情故事","汪苏泷","热血专辑",06,
                        "https://img.zcool.cn/community/0166fa5d996936a8012060bedfc7e9.jpg@1280w_1l_2o_100sh.jpg",344000,
                        setDataSourceuri.toString(),null,100,null)
        );
        musicList.add(new Music((long)1,1,07,"我非独自生活","郭静","热血专辑",0,
                        "http://pic.ntimg.cn/file/20200531/30259836_232148066151_2.jpg",344000,
                        setDataSourceuri.toString(),null,100,null)
        );
    }
}
