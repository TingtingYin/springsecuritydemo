package com.test.image;

import com.test.validate.ValidateCodeGenerator;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component("imageCodeGenerator")
public class SuperImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode createImageCode(HttpServletRequest request) {

        System.out.println("更高级的图形验证码");
        return null;
    }
}
