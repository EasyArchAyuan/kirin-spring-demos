package com.kirin.spring.service;

import javax.servlet.ServletOutputStream;
import java.io.InputStream;

public interface UserService {
    void downloadExcel(ServletOutputStream outputStream);

    void uploadExcel(InputStream inputStream);
}
