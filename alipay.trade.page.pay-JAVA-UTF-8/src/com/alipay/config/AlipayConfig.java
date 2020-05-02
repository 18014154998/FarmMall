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
	public static String app_id = "2016102200737506";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQChU4/CF43luKbQiI+fLY23l6zVtqpSkcefpzQ2AIGFWMKeXuGprGT91Si7WB3h1XF2zg84ioWgS7HHlKyYpPz8DX3AuNZl0pSxJg+wQHwMumijZg5LivD2BbliVjjsCzhXmxrnntxokTkYeE2i0uE/ovX3ePiAIhcUNYpuSAKwxQuHYvwrOLH7CIn1zxn+vigjsRz1DDJl2nBPj3EIr0/QxWegVO5NwHJ2gjg+1gDEY6Q4u5H1FqWzSNztgVbuDAorpWiidKzJVeHM6nP0dHVRUNruX6jBsdEuaGa+Re7FFC6haJZ86CVz7TKQ2/ZScI18kXCl67TzUv9eswehKY03AgMBAAECggEAL0o6as/SxZMyOxC84RFOaJHqlR8doGShWrh9wpK1ZOxW6GuxxLYHSK0SapBy+f9CamwO5Cke8JUfwPxg98HtcslVoofMOT7YXXFlyemtM2H1SGijKhvJdKTK6fuSZgcH9g4+fcUAoRpo3TZus5sTcj8H0QpB9fWIRGFJefhb6YryHIMD14bh1J52bAq0LPujTzgLR13iuQiGH4KHRQoI1NA2f3HQSEMNI8MPju6qbrcwH8QU9a7KMDK3Gx6QtjP3YiOIxzf5GxFDQvL9/nb/L50kHqdaaULR/tWgTY388T9PW/KsW3DsUO+2dBCQ4CNSWyXQehbi3do8r+lhIcINAQKBgQDQ9E1O9zMz8yL7BxRY78G6ynv0yk/3fc42W4o9QSvODczZ7dhj4E9eBw6m79Ua1XQT+PoTm/31YeQtPvyxy+kQWypbDdu2eVu/37An5hGbRNx67cTLOfTcYePhpm6+O3HxCITLctGQUANkOz5X6dpCnzPbXEBxvaaFOufMd1hDtwKBgQDFphXfKtf+XS1iH/P1Xbd9SbSEbbirw0rNQUmQ57RcUYPsP2NmFlqUqGBLXLMIAIfg21gNCvHOWq6/FqLet37PCZiBAs3qBowthGeGeE/vFPBOvCho+bkaCRaHGleJPmFSs6JR5No71VTOYJvwx1SGBklYrwvLY3I1wBcRLBgCgQKBgCRG5c0Z2cfhJGeUmRG/vlChqtea8Ds1mkGRrvRnhiVl+/Sx+GmOnfjjHMYayVK5UEfPaAtTf8nETwsT7mcn0bTHPxlD1KtfcnBjc3/Zz6C3Wdf1w77Mtxgz3o5kiMF6LJP+OJ/htURqv8v9BRvaO8xpO2WQJJgapvhme6vh5G8NAoGAavvVhvDX7XVeJWkKUlwiAA0vSydg+IhDKwsV2PuyYu40rGI7WXzsFt91EBXjSoePBSV1acnszTfEsuZ7znYgi8yz4dE0yGI26kRrDRx+l/kLgnLSpM/XY8JbkVGu5DkB0RQu3okzn4N/3h3pCtG6bLlmZjyJ89OmdHW/hqoJbQECgYEAqIn2D7049+mhp/RIOETnDiPyV5nPYjkEBYD798BMvyp7l/LiaWYyddEqwLWMGKcQHWrRwjywr0YyBsUPHadgWGvaDQGucUrxpOSzN/3zdF5Zhr8RS5EY7knMbP9S8wTRnwqnDLZf/wICQoY5Xo1tGZ7hIgHzTqTKW0uCY2IN8no=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn2jfmjw3KaFW3tPWe6jt8Xo3br/Jn5hL/b9Pk664SLpT9s/NKG8uo37XBwxLTXBKKTTjKoZHf4PD00fhGnzl8A0xzqYJJrbwZqTR9jEht4UIDrV4Vx6RB7HYH3KIseo7FCiRbrVzVrNHrjAH/05jN8AxI26aQ8LpMLKchAVSJRzTJXbBAi4fHCpQif8JA553myWt0cY4+zvrZH3NFpTrV2AEjov37fOMBeMpTmzHpUfPj/9FvZFuvQIT8/FIqqjN6Yie5iGqWWNR3uM9JXsE4VA5lDQSK9zH3kO40EM7bNb3swNkP1AFskG6oi7qZsMhNz3SUJw0O6bXxPUAaaZlhQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


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

