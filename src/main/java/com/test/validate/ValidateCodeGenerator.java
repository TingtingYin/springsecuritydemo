package com.test.validate;

import com.test.image.ImageCode;

import javax.servlet.http.HttpServletRequest;

public interface ValidateCodeGenerator {
    ImageCode createImageCode(HttpServletRequest request);
}
