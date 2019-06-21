package org.bs.web.common;

public class CommonConf {


    // 排期信息缓存键
    public static final String PAI_QI_KEY = "paiqi";

    //放映厅可用座位总数缓存键
    public static final String SUM_SEATS_KEY = "sumSeats";

    //放映厅key
    public static final String HALL_SEATS_KEY = "hallSeats";

    //具体座椅信息key

    public static final String ORDER_KEY = "orderKey";

    public static final String  NOTE_KEY ="noteKey";

    public static final  Long  ORDER_TIME_OUT = 10L;

    /**
     * 短信验证码接口地址
     */
    public   static  final   String   SMS_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";

    /**
     * 短信验证  开发者主账号ID
     */
    // public   static  final   String   SMS_ACCOUNTSID = "9abff00fd151499a97a7d36d01142bd1";
    public   static  final   String   SMS_ACCOUNTSID = "077945a7ee754bd1a108adc8ba860887";

    /**
     *
     */
    //  public   static  final   String   SMS_AUTH_TOKEN = "5794d15d20fe4a6eb321bc29c12f2159";
    public   static  final   String   SMS_AUTH_TOKEN = "5bcab44dbda54b60bc76e4942d8a28bd";

    /**
     * 短信模板ID
     */
//	   public   static  final   String   SMS_TEMPLATEID = "1556658863";
    public   static  final   String   SMS_TEMPLATEID = "1683308697";

    /**
     * 短信 请求状态码 0000 成功
     */
    public   static  final   String   SMS_RESPCODE = "00000";

    // 验证码过期时间  单位 分钟
    public static final Long SMS_CODE_TIME_OUT = 5L;
    // 验证码
    public static final String SMS_CODE_CACHE_KEY = "smscode";
    // 短信验证码重复锁
    public static final String SMS_CODE_LOCK = "lock";
    // 重读获取短信验证码锁时间  单位 秒
    public static final Long SMS_CODE_LOCK_TIME = 60L;


    //具体座位信息key

    public static final String SEATS_INFO_KEY = "seatInfo";

    //排期座位信息缓存key
    public static final String PAI_QI_SEATS_KEY = "paiQiSeats";


    //排期座位已售状态缓存时间    过期不落地   失效
    public static final long PAI_QI_SEAT_CACHE_TIME = 1;


    public static final String ORDER_NUM_KEK = "orderNum";
    public static final String ORDER_NUM_KEK_P = "p";
    public static final String ORDER_NUM_KEK_S = "s";


    //排期座位总数
    public static final String PAI_SEAT_SUM = "paiSeatSum";

    //短信发送成功后  存储订单状态
    public static final String ORDER_STATUS = "orderStatus";

    //轮播图缓存
    public static final String IMGS_KEY = "imgs";
    public static final long IMGS_TIME = 10L;


    public static final String TIME = "time";
}
