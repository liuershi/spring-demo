package com.study.spring.converter;

import org.springframework.core.convert.converter.Converter;

import javax.xml.xpath.XPath;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器，将字符串转Date
 *
 * @Author milindeyu
 * @Date 2021/12/28 10:16 下午
 * @Version 1.0
 */
public class DateConverter implements Converter<String, Date> {

    /**
     * 日期格式
     */
    private String pattern;

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Date convert(String source) {
        if ("".equals(source.trim())) {
            return new Date();
        }
        try {
            SimpleDateFormat default_sdf = new SimpleDateFormat(pattern);
            return default_sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
