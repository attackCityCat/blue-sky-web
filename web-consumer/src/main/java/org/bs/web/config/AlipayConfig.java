package org.bs.web.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    //public static String app_id = "2016092800619262";

    // 商户私钥，您的PKCS8格式RSA2私钥
    //public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCuc4G3s28j07Xd8WktVE2vYdfPxos8VlL+KJ6mxESTvvb4kZthNhhUROZlM3DWesmY/v4VnJWWvPKfhdlggNBrv1gGRORBVOW5pSWe5kFMtaKC0e9UaWNcP8jGaAYjHWTA7tF+5GPkCRpMLo2JKObP6QVzGPXryEYm26sZD9KryEsTRFrmj/PS73to96qzoTI5KmWhdaaCCMEiD9qnhoCcDwKRmYp8KRsZMlvCHJE3SsVlsS5ked/yYxX+3ILpMN2J1eMFRLx9Yhj/PfxEchVQ+99Y9BjzY69ey5SkNahJV45iGZ4rvPVJRgBwXcLe2debNmLESlz9Ns84tPH/Kz/PAgMBAAECggEBAIiiS10YGtpSvUUCCcDJILdWyPMhrHgrnIEYS3qOiq+1iDYTxUEUX2XROSrWaXBzZ2Z/gX5nz/nqL5Wl/iXJfnSFv2nZl3VcCzmmEZss+MQeFxSjXPIeQQZFpvlPDE+AfCNoaYkbVOmL/57fb1eYQ39gITaOvD5Z9CgHMTFF5VlJD4H/e956ox1/vzArP88UJrsvjtEgcAx/zKqnN3rAovVI9MOP1X9n3/Ct0Bpq891y5aS5U+SwLBpS9jQF07QXtdu8qeSaIiuKOV8t+pGBD3Gh7b1sM448jKGzmgizXSYXsZa0aGkEIDLjRZyjRF7DvfCb4c4D+0x5WTfpRs5kGgECgYEA7yJlCGMvjv+0jI0spmkf6W3bpT8QJttD8SAApxZ01LT76LZW8NxfYo/ufQJwxTif/LEP5KrdNgMmJ4VD6JM3+8BZ9KffE5ZHLUJEdNRBU1ub4HBUKW6ncUU28GT+WZ5HFA1izJF1m5Mqg25mVl2zL9sCHtXr/VhSqsIy0Cy8dYECgYEAusE/kZAzkdcTfWCLNXl52B0UHEH2ajD1bFvaGwd1NdAX6JbH8julN4BE6d6MIsW/cjJ3NjRcJ1Vpy4TRRTZdiWJfkKLwviaDHykdB7mgOEto4Fbsy6rWip1I+ZvS7EVRiMWygQ9eZVY2qCYKXuYdNKvWNkvXpiw5bWvfc5sjfU8CgYEAqYWNb+u4XDwjRvwRagreB4HMkpFpJtKLkJTqQYjm259NcURJz8e5isqT+2TOgtFIgT8YEDecR9zloGCVqnsq1bofSxPyTRVccdYnZ1bM1IX9s5aN4y1BYEf70WEW+nr80ldG8dQwNlCWc8PAonscOtGb6DYobFm/iLPQh8ke9IECgYEAuOcSwFVsqa2vj0giLGy8dXu86IlqpxMYOxPqKy7EHuaMdW2sQ6pIV145XPBKATeW6EMNAu7uesc3exhidktwatCqW7Ln9ux8kEKNipOADZykFtIZm0DnL9Cwauqb9/Bd3LQYm22TAXRNo0gepnzhV7/21EVdGxrYNP1D/NsSVUMCgYAUAwPYwUbzW+zr2tIzKCQan1gX8Hj1d6HxrR+CBruBPD46Wq25yXKlWs+ePutxBFgwBOokJs0ztA7HBki8es1DJbfQY5chUvRew3mgeDvYwFKiftyq7NX5Zr4ZlhdrSBSplfRbQD1ImGPe1xsJynSKWVLOJGlzj1XGnVnMqnFbog==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
   //public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArnOBt7NvI9O13fFpLVRNr2HXz8aLPFZS/iiepsREk772+JGbYTYYVETmZTNw1nrJmP7+FZyVlrzyn4XZYIDQa79YBkTkQVTluaUlnuZBTLWigtHvVGljXD/IxmgGIx1kwO7RfuRj5AkaTC6NiSjmz+kFcxj168hGJturGQ/Sq8hLE0Ra5o/z0u97aPeqs6EyOSploXWmggjBIg/ap4aAnA8CkZmKfCkbGTJbwhyRN0rFZbEuZHnf8mMV/tyC6TDdidXjBUS8fWIY/z38RHIVUPvfWPQY82OvXsuUpDWoSVeOYhmeK7z1SUYAcF3C3tnXmzZixEpc/TbPOLTx/ys/zwIDAQAB";

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092900625747";


    // 商户私钥，您的PKCS8格式RSA2私钥
    public  static  String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCLHHVw8rPml3iQ0tXb8gJbmD+xyQFSL1imHNleH7uG9Ap9nNgOJ0CBPbeppZmq9KT5SUUlFLpJlIRJAo7mopYcdcP+x2t9QP1vZ0ozncR9p3lyFCjiLhNnG+NV6W9L6+2Cho1qIvWuepPAHQWG+G9Q/Ts7EMLkz6MjHCgvv5Zt64f3pjUucgeyXIOB24abCClCMUF6smTBUij31LJ7x+xv795pJG62OKdM4bMbuYpWKEusXttYcXg9bRtVtwU/wfyQnCIarOZ858Esx/hJNSCRrnBMdgsVNPtFJxmsg3Tui4U91pA05KhvnusKew6Sry6zvt0QYZQ4BG3u/z+visvPAgMBAAECggEADR9EHMFoIupK3y5kKfksK8OyzmxtiXkZ3aF/B5fqspI2ox62aq9dMFPIDWKnmi61mSZGNXc9E0/FIrXxEORpUInzUQcypoAI6AdQQooxTMENfatVJ/C8t88zpJj+fKTmpJdYo5hkoG7DnS2fpdmtdnBMtAeiur6zXs57I/XolLmtM1ZCu9SUpNbIOG39lcyP4nmzOhsDIgFUz5c8tFoGzBwe4fUe33jSzQNyM+g6KEZ0y7K3vLzrPc3WVlVMzUUEWrR5wryMoCTiebqta/ByWqjsamgQ/9VaZrLNgqcshn6QVs+AEUmxc/gdG5zN773d0u0tWmVerSDdDXnmCjcf0QKBgQDQrypNjSx1CuHpOW7AQ24tAssjplM7GFbQ1nAUQ/uzQ8k80YaP1dX7UIbCm1Gf44KR0YK+QqYOKny/98xLvN/a1cPpuko6OII/PCdMysOQ6D+JUF5KK8Z6+aVu9KynlVpjUoEsLymU03bn241WcvvsFPXeshCPsKzPjzYKnX2HDQKBgQCqpwFTn/mbNXVCHHArebe7MKyG2tJl/pl/rkUNDLNUVQbJbQvny/DyeSgJdR/b2bv15NGJMG+RDYLHW8dQI6WFtNjdDrYEcWN+hNRiqywlG6xk0VZO3xB9T643Sb3S/nUtSqrTYlWsQ2PY9LWAnG/conh63b+KGTWSWd3EWKZnSwKBgQC3DE8hA2oxqEANIZGiGAO2e7LQLH7pYSoVuWNKg29vCVClhmxwEnPGJBZw8WihxSCs44e5eCDMYDxY7vVGogABpmxYwk2F0Dd/XDZkx57PpsjEm7h5evh4ui6AqyIfRYSphp9DsILaxrqQGidZ4zZTGPeqRar9P032KnqOySJoqQKBgQCp7wX+LSaU7SXoAIOed2WDbRPQciTj1iUqpPIz7XrCNq08dW9OkqJMAmPhDxX7ipWGZiZV87qVehvJw9X1MpoITC9L6fNM91C5UzJfUs7x4N3Jwz+r6Kr17huxCKiTbDppMJptRtXDZZQPHpeDC8TEs7E/wIOU1Eephf21IQYLgwKBgHdYjGP0Ebi4YdfBdqA3/RuwQLGgGfgl+t2a/B66x8O+cUutDMw2knFB3IuYxl5nGeKqsne5PHgJZMh56VB3vaPv9ZxM1pw+uZfwbr6BZr2h1fG6PT8ZsmfVv9gqigYjP61h6BtaC/qioIx4GZSi4Ka4haZNJTBrFKuPsE+VdU4T";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAixx1cPKz5pd4kNLV2/ICW5g/sckBUi9YphzZXh+7hvQKfZzYDidAgT23qaWZqvSk+UlFJRS6SZSESQKO5qKWHHXD/sdrfUD9b2dKM53Efad5chQo4i4TZxvjVelvS+vtgoaNaiL1rnqTwB0FhvhvUP07OxDC5M+jIxwoL7+WbeuH96Y1LnIHslyDgduGmwgpQjFBerJkwVIo99Sye8fsb+/eaSRutjinTOGzG7mKVihLrF7bWHF4PW0bVbcFP8H8kJwiGqzmfOfBLMf4STUgka5wTHYLFTT7RScZrIN07ouFPdaQNOSob57rCnsOkq8us77dEGGUOARt7v8/r4rLzwIDAQAB";


    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8082/page/toPayMent";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8082/page/toSuccess";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";

    //支付成功后,分单
    //public static String

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
