package com.kirin.spring.service.impl;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.kirin.spring.entitys.User;
import com.kirin.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private List<User> cachedDataList = new ArrayList<>();

    @Override
    public void downloadExcel(ServletOutputStream outputStream) {
        EasyExcelFactory.write(outputStream, User.class).sheet("User").doWrite(this::getUserList);
    }

    @Override
    public void uploadExcel(InputStream inputStream) {
        // ReadListener不是必须的，它主要的设计是读取excel数据的后置处理(并考虑一次性读取到内存潜在的内存泄漏问题)
        EasyExcelFactory.read(inputStream, User.class, new ReadListener<User>() {
            @Override
            public void invoke(User user, AnalysisContext analysisContext) {
                cachedDataList.add(user);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                cachedDataList.forEach(user -> log.info(user.toString()));
            }
        }).sheet().doRead();
    }


    private List<User> getUserList() {
        return Collections.singletonList(User.builder().id(1L).userName("kirin").email("easyarchayuan@126.com").phoneNumber(121231231231L).description("hello world").build());
    }
}
