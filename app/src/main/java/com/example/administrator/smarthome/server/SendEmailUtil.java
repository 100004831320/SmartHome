package com.example.administrator.smarthome.server;



import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Administrator on 2021/4/20 0020.
 */

public class SendEmailUtil {
    public SendEmailUtil(){}
    public int sendEmail(String emailaddress) throws MessagingException {
        try {
            Random random = new Random();
            int code = random.nextInt(9000)+1000;
            //创建连接对象 连接到邮件服务器
            Properties properties = new Properties();
                    //设置发送邮件的基本参数
                    //发送邮件服务器(注意，此处根据你的服务器来决定，如果使用的是QQ服务器，请填写smtp.qq.com)
                    properties.put("mail.smtp.host", "smtp.qq.com");
                    //发送端口（根据实际情况填写，一般均为25）
                    properties.put("mail.smtp.port", "25");
                    properties.put("mail.smtp.auth", "true");
                    //设置发送邮件的账号和密码
                    Session session = Session.getInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            //两个参数分别是发送邮件的账户和密码(注意，如果配置后不生效，请检测是否开启了 POP3/SMTP 服务，QQ邮箱对应设置位置在: [设置-账户-POP3/IMAP/SMTP/Exchange/CardDAV/CalDAV服务])
                            return new PasswordAuthentication("412473895@qq.com","lyx19990321.");
                        }
                    });
                    //创建邮件对象
                    MimeMessage message = new MimeMessage(session);
                    //设置发件人
                    message.setFrom(new InternetAddress("admin@huic188.com"));
                    //设置收件人
                    message.setRecipient(Message.RecipientType.TO,new InternetAddress(emailaddress));
                    //设置主题
                    message.setSubject("这是一份测试邮件");
                    //设置邮件正文  第二个参数是邮件发送的类型
                    message.setContent(code,"text/html;charset=UTF-8");
                    //发送一封邮件
                    Transport.send(message);
            /*HtmlEmail email = new HtmlEmail();// 不用更改
            email.setHostName("smtp.qq.com");// 需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
            email.setCharset("UTF-8");
            email.addTo(emailaddress);// 收件地址

            email.setFrom("412473895@qq.com", "智能家居");// 此处填邮箱地址和用户名,用户名可以任意填写
            //hhhjkkkhhjklj（IMAP/SMTP服务）---这里需要改为你自己
            email.setAuthentication("412473895@qq.com", "gkikktsnpjagcagc");// 此处填写邮箱地址和客户端授权码

            email.setSubject("智能家居");// 此处填写邮件名，邮件名可任意填写
            email.setMsg("尊敬的用户您好,您本次注册的验证码是:" + code);// 此处填写邮件内容

            email.send();*/
            return code;
        } catch (Exception e) {
            return 0;
        }
    }
}
