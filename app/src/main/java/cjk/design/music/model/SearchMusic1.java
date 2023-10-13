package cjk.design.music.model;

import java.util.List;

public class SearchMusic1 {


    private ResultBean result;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * songs : [{"id":347230,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":34209,"name":"海阔天空","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":747504000000,"size":10,"copyrightId":1003,"status":1,"picId":109951165796899180,"mark":0},"duration":326000,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":376199,"fee":1,"rUrl":null,"mark":8192},{"id":346089,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":34110,"name":"Beyond 25th Anniversary","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1205164800000,"size":48,"copyrightId":5003,"status":1,"picId":109951165796417310,"alia":["Beyond 25周年精选"],"mark":0},"duration":322560,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":376199,"fee":8,"rUrl":null,"mark":0},{"id":1357375695,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":78372827,"name":"华纳廿三周年纪念精选系列 - Beyond","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":999273600000,"size":15,"copyrightId":7002,"status":3,"picId":109951163984013010,"mark":0},"duration":239506,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":8192},{"id":400162138,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":34430029,"name":"华纳23周年纪念精选系列","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":999273600000,"size":14,"copyrightId":7002,"status":3,"picId":3273246124149810,"mark":0},"duration":323693,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"transNames":["Boundless Oceans, Vast Skies"],"mvid":376199,"fee":1,"rUrl":null,"mark":8192},{"id":1357374736,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":78372154,"name":"华纳超极品音色系列","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":820425600000,"size":14,"copyrightId":7002,"status":1,"picId":109951163984007060,"mark":0},"duration":239506,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":8192},{"id":387717,"name":"海阔天空","artists":[{"id":13283,"name":"信乐团","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":38408,"name":"海阔天空","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1075564800000,"size":10,"copyrightId":1416078,"status":1,"picId":109951164094157630,"mark":0},"duration":276626,"copyrightId":1416078,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":5343895,"fee":1,"rUrl":null,"mark":8192},{"id":346573,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":34147,"name":"光辉岁月十五年","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":930758400000,"size":13,"copyrightId":5003,"status":1,"picId":29686813951246,"mark":0},"duration":323693,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"transNames":["Boundless Oceans, Vast Skies"],"mvid":376199,"fee":8,"rUrl":null,"mark":0},{"id":469391964,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":35336928,"name":"超越BEYOND精选","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1053964800000,"size":19,"copyrightId":7003,"status":1,"picId":109951166888743780,"mark":0},"duration":323693,"copyrightId":7003,"status":0,"alias":[],"rtype":0,"ftype":0,"transNames":["Boundless Oceans, Vast Skies"],"mvid":0,"fee":8,"rUrl":null,"mark":8192},{"id":1915878785,"name":"海阔天空","artists":[{"id":939088,"name":"易烊千玺","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":13227487,"name":"许君聪","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":51360764,"name":"田雨","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":12061206,"name":"王宁","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":51360728,"name":"公磊","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":37632161,"name":"黄尧","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":34953331,"name":"齐溪","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":139600364,"name":"海阔天空","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1643731200000,"size":2,"copyrightId":-1,"status":0,"picId":109951166991639040,"alia":["《奇迹·笨小孩》电影陪伴曲"],"mark":0},"duration":322058,"copyrightId":0,"status":0,"alias":["《奇迹·笨小孩》电影陪伴曲"],"rtype":0,"ftype":0,"mvid":14502220,"fee":8,"rUrl":null,"mark":536870912},{"id":346509,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":34141,"name":"Super Collection","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":936806400000,"size":42,"copyrightId":5003,"status":1,"picId":60473139541494,"mark":0},"duration":307000,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":376199,"fee":8,"rUrl":null,"mark":0},{"id":387668,"name":"海阔天空","artists":[{"id":13283,"name":"信乐团","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":38400,"name":"挑信","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1101830400000,"size":28,"copyrightId":14025,"status":3,"picId":119846767442613,"mark":0},"duration":279000,"copyrightId":14025,"status":0,"alias":["偶像剧《死了都要爱-信乐团的故事》片头曲"],"rtype":0,"ftype":0,"mvid":5343895,"fee":0,"rUrl":null,"mark":0},{"id":27515047,"name":"海阔天空","artists":[{"id":9881,"name":"汪小敏","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":2623243,"name":"一声所爱 大地飞歌（第九期）","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1375200000007,"size":12,"copyrightId":0,"status":1,"picId":5630599045913351,"mark":0},"duration":178677,"copyrightId":0,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":0,"rUrl":null,"mark":0},{"id":347351,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":34222,"name":"乐与怒","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":737308800000,"size":12,"copyrightId":7002,"status":1,"picId":109951167634724320,"mark":0},"duration":324825,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"transNames":["Boundless Oceans, Vast Skies"],"mvid":376199,"fee":1,"rUrl":null,"mark":8192},{"id":1890718615,"name":"海阔天空","artists":[{"id":2112,"name":"陈小春","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":4479,"name":"MC HotDog 热狗","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":1211046,"name":"GAI周延","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":3692,"name":"林志炫","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":6079,"name":"言承旭","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":135434990,"name":"披荆斩棘的哥哥 第12期","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1635436800000,"size":8,"copyrightId":2709527,"status":0,"picId":109951166567184820,"mark":0},"duration":287738,"copyrightId":2709527,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":536870912},{"id":29017036,"name":"海阔天空","artists":[{"id":6211,"name":"幼稚园杀手","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":2965013,"name":"热门华语236","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1388505600004,"size":44,"copyrightId":0,"status":2,"picId":109951166361218460,"mark":0},"duration":224000,"copyrightId":0,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":0,"rUrl":null,"mark":524416},{"id":25780157,"name":"海阔天空","artists":[{"id":9263,"name":"Robynn & Kendy","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":2313008,"name":"Dear Diary","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1356969600000,"size":10,"copyrightId":7003,"status":1,"picId":2336462209041205,"mark":0},"duration":195626,"copyrightId":7003,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":1,"rUrl":null,"mark":8192},{"id":2034842398,"name":"海阔天空","artists":[{"id":33575412,"name":"谢宇星Yuingboy","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},{"id":46874701,"name":"爱丽丝天下无敌^_^","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":162769002,"name":"云·星·海 FAMILY TREE","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1680192000000,"size":6,"copyrightId":22036,"status":1,"picId":109951168507359780,"mark":0},"duration":277999,"copyrightId":22036,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":536879104},{"id":406243336,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":34545843,"name":"华纳23周年纪念精选系列 (群星精选)","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1004025600007,"size":13,"copyrightId":7002,"status":3,"picId":3299634402151480,"mark":0},"duration":239542,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":0},{"id":5255728,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":512090,"name":"乐坛班霸","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1183939200000,"size":48,"copyrightId":7003,"status":1,"picId":109951165816561420,"alia":["宝丽金 华纳 10年对垒"],"mark":0},"duration":323693,"copyrightId":7003,"status":0,"alias":[],"rtype":0,"ftype":0,"transNames":["Boundless Oceans, Vast Skies"],"mvid":376199,"fee":8,"rUrl":null,"mark":8192},{"id":2008692248,"name":"海阔天空","artists":[{"id":12258318,"name":"李昂星","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":156299727,"name":"风吹半夏 年代经典OST原声带","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1670428800000,"size":29,"copyrightId":753018,"status":-1,"picId":109951168167715250,"mark":0},"duration":252450,"copyrightId":753018,"status":0,"alias":["《风吹半夏》电视剧插曲"],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":536870912},{"id":5258732,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":512274,"name":"依然\u2026爱","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1156435200000,"size":45,"copyrightId":5003,"status":1,"picId":37383395361212,"mark":0},"duration":323000,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":376199,"fee":8,"rUrl":null,"mark":0},{"id":431259311,"name":"海阔天空","artists":[{"id":9491,"name":"谭晶","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":34874812,"name":"蒙面唱将猜猜猜 第一期","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1474128000007,"size":7,"copyrightId":0,"status":-1,"picId":18733479114231668,"mark":0},"duration":270784,"copyrightId":0,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":1,"rUrl":null,"mark":536936448},{"id":1366049980,"name":"海阔天空","artists":[{"id":3706,"name":"林子祥","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":79214673,"name":"港乐。林子祥2002","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1041177600000,"size":23,"copyrightId":7002,"status":3,"picId":109951164081833900,"mark":0},"duration":330066,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":8192},{"id":5264677,"name":"海阔天空","artists":[{"id":122455,"name":"群星","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":512629,"name":"蓝月亮钢琴集","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1104508800000,"size":73,"copyrightId":5003,"status":1,"picId":558551906922194,"mark":0},"duration":230530,"copyrightId":5003,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":0,"rUrl":null,"mark":0},{"id":1886188381,"name":"海阔天空","artists":[{"id":48026866,"name":"裴子豪","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":134604888,"name":"爱与诚","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1633881600000,"size":9,"copyrightId":743010,"status":1,"picId":109951166510685460,"mark":0},"duration":68638,"copyrightId":743010,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":139392},{"id":346200,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":34115,"name":"The Ultimate Story","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1104595200000,"size":46,"copyrightId":5003,"status":3,"picId":1781208837010258,"mark":0},"duration":324826,"copyrightId":5003,"status":0,"alias":[],"rtype":0,"ftype":0,"transNames":["Boundless Oceans, Vast Skies"],"mvid":0,"fee":0,"rUrl":null,"mark":128},{"id":27598595,"name":"海阔天空","artists":[{"id":9881,"name":"汪小敏","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":2643274,"name":"一声所爱·大地飞歌（精选集）","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1376841600007,"size":14,"copyrightId":0,"status":1,"picId":3175389581096890,"mark":0},"duration":178677,"copyrightId":0,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":0,"rUrl":null,"mark":0},{"id":347257,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":34211,"name":"遥望黄家驹不死音乐精神","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":754675200000,"size":13,"copyrightId":5003,"status":3,"picId":109951165591971860,"alia":["特别纪念集92'-93'"],"mark":0},"duration":323693,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"transNames":["Boundless Oceans, Vast Skies"],"mvid":376199,"fee":1,"rUrl":null,"mark":8192},{"id":27937677,"name":"海阔天空","artists":[{"id":2116,"name":"陈奕迅","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":2698078,"name":"热门华语185","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1356969600004,"size":32,"copyrightId":0,"status":2,"picId":109951166361218460,"mark":0},"duration":327000,"copyrightId":0,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":0,"rUrl":null,"mark":524288},{"id":5279393,"name":"海阔天空","artists":[{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":513531,"name":"牵手连心","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":807984000000,"size":13,"copyrightId":5003,"status":1,"picId":116548232561248,"mark":0},"duration":323693,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"transNames":["Boundless Oceans, Vast Skies"],"mvid":376199,"fee":1,"rUrl":null,"mark":8192}]
         * hasMore : true
         * songCount : 600
         */

        private boolean hasMore;
        private int songCount;
        private List<SongsBean> songs;

        public boolean isHasMore() {
            return hasMore;
        }

        public void setHasMore(boolean hasMore) {
            this.hasMore = hasMore;
        }

        public int getSongCount() {
            return songCount;
        }

        public void setSongCount(int songCount) {
            this.songCount = songCount;
        }

        public List<SongsBean> getSongs() {
            return songs;
        }

        public void setSongs(List<SongsBean> songs) {
            this.songs = songs;
        }

        public static class SongsBean {
            /**
             * id : 347230
             * name : 海阔天空
             * artists : [{"id":11127,"name":"Beyond","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}]
             * album : {"id":34209,"name":"海阔天空","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":747504000000,"size":10,"copyrightId":1003,"status":1,"picId":109951165796899180,"mark":0}
             * duration : 326000
             * copyrightId : 7002
             * status : 0
             * alias : []
             * rtype : 0
             * ftype : 0
             * mvid : 376199
             * fee : 1
             * rUrl : null
             * mark : 8192
             * transNames : ["Boundless Oceans, Vast Skies"]
             */

            private int id;
            private String name;
            private AlbumBean album;
            private int duration;
            private int copyrightId;
            private int status;
            private int rtype;
            private int ftype;
            private int mvid;
            private int fee;
            private Object rUrl;
            private String  mark;
            private List<ArtistsBean> artists;
            private List<?> alias;
            private List<String> transNames;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public AlbumBean getAlbum() {
                return album;
            }

            public void setAlbum(AlbumBean album) {
                this.album = album;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(int copyrightId) {
                this.copyrightId = copyrightId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getRtype() {
                return rtype;
            }

            public void setRtype(int rtype) {
                this.rtype = rtype;
            }

            public int getFtype() {
                return ftype;
            }

            public void setFtype(int ftype) {
                this.ftype = ftype;
            }

            public int getMvid() {
                return mvid;
            }

            public void setMvid(int mvid) {
                this.mvid = mvid;
            }

            public int getFee() {
                return fee;
            }

            public void setFee(int fee) {
                this.fee = fee;
            }

            public Object getRUrl() {
                return rUrl;
            }

            public void setRUrl(Object rUrl) {
                this.rUrl = rUrl;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public List<ArtistsBean> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsBean> artists) {
                this.artists = artists;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            public List<String> getTransNames() {
                return transNames;
            }

            public void setTransNames(List<String> transNames) {
                this.transNames = transNames;
            }

            public static class AlbumBean {
                /**
                 * id : 34209
                 * name : 海阔天空
                 * artist : {"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"fansGroup":null,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}
                 * publishTime : 747504000000
                 * size : 10
                 * copyrightId : 1003
                 * status : 1
                 * picId : 109951165796899180
                 * mark : 0
                 */

                private int id;
                private String name;
                private ArtistBean artist;
                private long publishTime;
                private int size;
                private int copyrightId;
                private int status;
                private long picId;
                private int mark;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public int getCopyrightId() {
                    return copyrightId;
                }

                public void setCopyrightId(int copyrightId) {
                    this.copyrightId = copyrightId;
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

                public int getMark() {
                    return mark;
                }

                public void setMark(int mark) {
                    this.mark = mark;
                }

                public static class ArtistBean {
                    /**
                     * id : 0
                     * name :
                     * picUrl : null
                     * alias : []
                     * albumSize : 0
                     * picId : 0
                     * fansGroup : null
                     * img1v1Url : https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * img1v1 : 0
                     * trans : null
                     */

                    private int id;
                    private String name;
                    private Object picUrl;
                    private int albumSize;
                    private int picId;
                    private Object fansGroup;
                    private String img1v1Url;
                    private int img1v1;
                    private Object trans;
                    private List<?> alias;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public Object getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(Object picUrl) {
                        this.picUrl = picUrl;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public int getPicId() {
                        return picId;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public Object getFansGroup() {
                        return fansGroup;
                    }

                    public void setFansGroup(Object fansGroup) {
                        this.fansGroup = fansGroup;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public int getImg1v1() {
                        return img1v1;
                    }

                    public void setImg1v1(int img1v1) {
                        this.img1v1 = img1v1;
                    }

                    public Object getTrans() {
                        return trans;
                    }

                    public void setTrans(Object trans) {
                        this.trans = trans;
                    }

                    public List<?> getAlias() {
                        return alias;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }
                }
            }

            public static class ArtistsBean {
                /**
                 * id : 11127
                 * name : Beyond
                 * picUrl : null
                 * alias : []
                 * albumSize : 0
                 * picId : 0
                 * fansGroup : null
                 * img1v1Url : https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * img1v1 : 0
                 * trans : null
                 */

                private int id;
                private String name;
                private Object picUrl;
                private int albumSize;
                private int picId;
                private Object fansGroup;
                private String img1v1Url;
                private int img1v1;
                private Object trans;
                private List<?> alias;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Object getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(Object picUrl) {
                    this.picUrl = picUrl;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public Object getFansGroup() {
                    return fansGroup;
                }

                public void setFansGroup(Object fansGroup) {
                    this.fansGroup = fansGroup;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public int getImg1v1() {
                    return img1v1;
                }

                public void setImg1v1(int img1v1) {
                    this.img1v1 = img1v1;
                }

                public Object getTrans() {
                    return trans;
                }

                public void setTrans(Object trans) {
                    this.trans = trans;
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
}
