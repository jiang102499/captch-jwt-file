package com.example.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 *@ClassName FileController
 *
 *@Author lenovo
 *@Date 2020/12/12 10:52
 * description: 参数
 */
@Data
@Component
@PropertySource(value = {"classpath:captchaParameter.properties"})
public class CaptchaParameterConfig {

    /**
     * 验证码有效期
     */
    @Value("${project.valid-duration}")
    private Integer validDuration;

    /**
     * 边框颜色
     */
    @Value("${captcha.border.color}")
    private String captchaBorderColor;

    /**
     * 边框宽度
     */
    @Value("${captcha.border.thickness}")
    private String captchaBorderThickness;

    /**
     * 图片宽度
     */
    @Value("${captcha.image.width}")
    private String captchaImageWidth;

    /**
     * 图片高度
     */
    @Value("${captcha.image.height}")
    private String captchaImageHeight;

    /**
     * 图片实现类
     */
    @Value("${captcha.producer.impl}")
    private String captchaProducerImpl;

    /**
     * 验证码值
     */
    @Value("${captcha.textproducer.char.string}")
    private String captchaTextProducerCharString;

    /**
     * 验证码长度
     */
    @Value("${captcha.textproducer.char.length}")
    private String captchaTextProducerCharLength;

    /**
     * 文字间隔
     */
    @Value("${captcha.textproducer.char.space}")
    private String captchaTextProducerCharSpace;

    /**
     * 字体
     */
    @Value("${captcha.textproducer.font.name}")
    private String captchaTextProducerFontName;

    /**
     * 字体大小
     */
    @Value("${captcha.textproducer.font.size}")
    private String captchaTextProducerFontSize;

    /**
     * 字体颜色
     */
    @Value("${captcha.textproducer.font.color}")
    private String captchaTextProducerFontColor;

    /**
     * 干扰线实现类
     */
    @Value("${captcha.nosie.impl}")
    private String captchaNosieImpl;

    /**
     * 干扰颜色
     */
    @Value("${captcha.nosie.color}")
    private String captchaNosieColor;

    /**
     * 图片样式
     */
    @Value("${captcha.obscurificator.impl}")
    private String captchaObscurificatorImpl;

    /**
     * 背景实现类
     */
    @Value("${captcha.background.impl}")
    private String captchaBackgroundImpl;

    /**
     * 背景渐变开始
     */
    @Value("${captcha.background.clear.from}")
    private String captchaBackgroundClearFrom;

    /**
     * 背景渐变结束
     */
    @Value("${captcha.background.clear.to}")
    private String captchaBackgroundClearTo;

    /**
     * 文字渲染器
     */
    @Value("${captcha.word}")
    private String captchaWord;

    /**
     * session key
     */
    @Value("${captcha.session.key}")
    private String captchaSessionKey;

    /**
     * session date
     */
    @Value("${captcha.session.date}")
    private String captchaSessionDate;
}
