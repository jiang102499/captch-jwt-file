package com.example.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


/**
 *@ClassName FileController
 *
 *@Author lenovo
 *@Date 2020/12/12 10:52
 * description: 验证码配置
 */
@Configuration
public class CaptchaConfig {

    @Autowired
    private CaptchaParameterConfig parameterConfig;


    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();

        //边框
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.border.color", parameterConfig.getCaptchaBorderColor());
        properties.put("kaptcha.border.thickness", parameterConfig.getCaptchaBorderThickness());
        //图片
        properties.put("kaptcha.image.width", parameterConfig.getCaptchaImageWidth());
        properties.put("kaptcha.image.height", parameterConfig.getCaptchaImageHeight());
        //图片实现类
        properties.put("kaptcha.producer.impl", parameterConfig.getCaptchaProducerImpl());

        //文本
        properties.put("kaptcha.textproducer.char.space", parameterConfig.getCaptchaTextProducerCharSpace());
        properties.put("kaptcha.textproducer.char.length", parameterConfig.getCaptchaTextProducerCharLength());
        properties.put("kaptcha.textproducer.char.string", parameterConfig.getCaptchaTextProducerCharString());
        properties.put("kaptcha.textproducer.font.name", parameterConfig.getCaptchaTextProducerFontName());
        properties.put("kaptcha.textproducer.font.size", parameterConfig.getCaptchaTextProducerFontSize());
        properties.put("kaptcha.textproducer.font.color", parameterConfig.getCaptchaTextProducerFontColor());

        //干扰
        properties.put("kaptcha.noise.impl", parameterConfig.getCaptchaNosieImpl());
        properties.put("kaptcha.noise.color", parameterConfig.getCaptchaNosieColor());

        //图片样式
        properties.put("kaptcha.background.impl", parameterConfig.getCaptchaBackgroundImpl());
        //渐变
        properties.put("kaptcha.background.clear.from", parameterConfig.getCaptchaBackgroundClearFrom());
        properties.put("kaptcha.background.clear.to", parameterConfig.getCaptchaBackgroundClearTo());

        //文字渲染器
        properties.put("kaptcha.word", parameterConfig.getCaptchaWord());

        //session
        properties.put("kaptcha.session.key", parameterConfig.getCaptchaSessionKey());
        properties.put("kaptcha.session.date", parameterConfig.getCaptchaSessionDate());

        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }
}
