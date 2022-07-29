package com.example.validation.controller;

import com.example.validation.util.I18nUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

@RestController
@RequestMapping("user")
public class UserValidationController {

    @GetMapping("basic")
    public String basicValidation() {
        return "success";
    }

    /**
     * ResourceBundle中会有cacheList进行缓存,所以不用担心
     * <a href="https://docs.oracle.com/javase/8/docs/api/">官方文档</a>
     * @param language
     * @param country
     * @return
     */
    @GetMapping("i18n/{language}/{country}")
    public String i18nValidation(@PathVariable String language,@PathVariable String country) {
//        不区分大小写, zh_CN 和 zh_cn 都可以,不过为了规范，还是使用zh_CN
        Locale locale = new Locale(language, country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", locale, I18nUtil.getResourceBundleClassLoader());
        return resourceBundle.getString("hello");
    }

    @GetMapping("bye/{language}/{country}/{name}")
    public String i18nMessage(@PathVariable String language, @PathVariable String country, @PathVariable String name) {
        Locale locale = new Locale(language, country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", locale, I18nUtil.getResourceBundleClassLoader());
        return MessageFormat.format(resourceBundle.getString("bye"), name);
    }

    @GetMapping("error")
    public String i18nErrorMessage() {
        return "";
    }

    @GetMapping("customer")
    public String customerValidation() {
        return "";
    }
}
