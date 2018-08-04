package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091900545808";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCxJ8EE9M47DOqTMhx7JnlbTOyBXD1J5HyBDDq76nAXzt2eACLmxaTyNriuUqzT277iS6M/DTmYtOvSiFdqw+ruvaxjkpG7UgWADDFb8EDINGajKbXJm5rB813mfSgOR37SyIQlSEGcm/qlzkvB3c3aHkdY2ITfQ3Ew0+Y2VHuMcCWK18mMMdz8iPWfrz1xHZHK1kesTbqRiC07e5EZmk02EtF6Su6DUTJcLU2iYa7OFTaZJyTNwNs65ZKrt/4Ch6I3dBat4f1AiLr4/IgzvIzd+/WtbBqEkSJcarnKzXxfePs+33HVbpG3ua4AlYgZsOO5I2sH5HD8Ob+ScxVBGOqrAgMBAAECggEBAJIdfeA+ohKmVpvNixwv4YxiZ/dSQuK9Z8twcMkpVgbtAnEdH6xDfAajB7QQUKf06P3w8NZCbCz9nDvrZF6U9SKwoo0GCNj9j7fLVrLD+EqonbcZ4exFQWGS/vHqbK1KXtovtH6jmCo5pIQ5INbnwK+Upbgr7XvQPn3NaGWLTNPJFBpfEfoOSK2qP0WyuoPMqagej1kI1f1y+Fh+KYR2ggwHFrSrUQAPIfPMcrUHjyEnueC40mvAwYULFsJfF3eMd7Np412BcSSgLcxgYKkRfOCwHjZ1oWTPtQArJim3Kk8/GzbvMuyw1wT4pBRF5WesaULnfC8pLzhG2OL6J38FV3ECgYEA32urxiU8wQ0Frndu1a/b3NZHwgWW9liuBtUp4qT879cADJTCbQ2tcSXZlqb0sw2T2Lesyojh6OuhdUAoYu45ZwEhz7GW8xLuDMVL2lmUh68EmWSvDHXW85jCSPkj6jPEKoYj5AGL+1BnZlSla0osCFI4fhzg9mwGDA75KimWmb0CgYEAyvz9ycm/0O1PmB/Nc7TB7CxkqIdyKlQ4weUNWbADeHfgCJgeTp3itxKgB0KH5IOFPs96UZvgDHjm8vz0/rPwC5GMWyA54gQ5ZqNkicaiQby4OauxfYM34vhIo6RGlDIfIu3SP+bn8MlSB1o0Pwj3s2LSffNLjKq2u0M0J5zGuIcCgYBQSYIGB5WojkRvaM30jmjFGF/bEmUoi7+mBu4xWzbl/W4wFzkzNUoRshdaMw8WVRe/Nmoqsjv0ltCDsRWST6djI54B5ACpwzC2eCQFCFH+3F8bvHnHUYV4LnoK/TTx0b55xZCaPBAQtNkjheGYB6SBLQLOFxSkmTcnGC5j/2P2RQKBgC4qVanj+X0Ry81kRjyven81JXtyupNH7lSivGOOdWubj9dEiXgFzn8mfEDKb8+X3eEIHOCcm9saUCQpRar7z3dCFfLPpHpzzX47YO04wMREoH11P/u0sSwsnZCiFu8zawNtpSilYlDP6JkFeeZwKq2gpxDAGYmXddGnGiB8NnHXAoGBAMkzG9U+3whhP/7ZTN9WpaSEgCEYvkgDBCR9oS0Vmcv+bM3iebTVqpD7uxQ5uCHoOIrWcAwChHNQa4ErxNoRH5GKnF4XomRyKk4UR2U7CjeUbUWGITEj6XIXIUT2beccWpPfc17NZPw/dQ60U4vD1b6v857aOxqro9bk5dxsPuvQ";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsSfBBPTOOwzqkzIceyZ5W0zsgVw9SeR8gQw6u+pwF87dngAi5sWk8ja4rlKs09u+4kujPw05mLTr0ohXasPq7r2sY5KRu1IFgAwxW/BAyDRmoym1yZuawfNd5n0oDkd+0siEJUhBnJv6pc5Lwd3N2h5HWNiE30NxMNPmNlR7jHAlitfJjDHc/Ij1n689cR2RytZHrE26kYgtO3uRGZpNNhLRekrug1EyXC1NomGuzhU2mSckzcDbOuWSq7f+AoeiN3QWreH9QIi6+PyIM7yM3fv1rWwahJEiXGq5ys18X3j7Pt9x1W6Rt7muAJWIGbDjuSNrB+Rw/Dm/knMVQRjqqwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://47.93.214.116:8080/api/api/pay/log/return_url.htm";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://47.93.214.116:8080/api/secrets/big-secret.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "https://openapi.alipaydev.com/gateway.do";


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

