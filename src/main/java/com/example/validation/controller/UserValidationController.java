package com.example.validation.controller;

import com.example.validation.util.I18nUtil;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @SneakyThrows
    public String i18nValidation(@PathVariable String language,@PathVariable String country) {
        Locale locale = new Locale(language, country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", locale, I18nUtil.getResourceBundleClassLoader());
        return resourceBundle.getString("hello");
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
