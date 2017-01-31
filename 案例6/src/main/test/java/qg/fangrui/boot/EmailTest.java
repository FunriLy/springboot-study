package qg.fangrui.boot;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;

/**
 * Created by zggdczfr on 2017/1/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("163")
public class EmailTest {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String Sender;

    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Sender);
        message.setTo(Sender);
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }

    @Test
    public void sendHtmlMail() {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(Sender);
            helper.setTo(Sender);
            helper.setSubject("主题：HTML邮件");

            StringBuffer sb = new StringBuffer();
            sb.append("<h1>大标题-h1</h1>")
                    .append("<p style='color:#F00'>红色字</p>")
                    .append("<p style='text-align:right'>右对齐</p>");
            helper.setText(sb.toString(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }

//    @Autowired
//    private FreeMarkerConfig freeMarkerConfig;
//
//    @Test
//    public void sendTemplateMail(){
//        MimeMessage message = null;
//        try {
//            message = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom(Sender);
//            helper.setTo(Sender);
//            helper.setSubject("主题：模板邮件");
//
//            Map<String, Object> model = new HashedMap();
//            model.put("username", "zggdczfr");
//
//            Configuration cfg= new Configuration(Configuration.VERSION_2_3_23);
//
//            // 设定去哪里读取相应的ftl模板
//
//            cfg.setClassForTemplateLoading(this.getClass(), "/templates");
//
//            // 在模板文件目录中寻找名称为name的模板文件
//
//            RabbitProperties.Template template   = cfg.getTemplate("email.ftl");
//
//            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
