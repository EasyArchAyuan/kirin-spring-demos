package com.kirin.bigfileupload.servie.impl;

import com.kirin.bigfileupload.bean.UploadFile;
import com.kirin.bigfileupload.dao.FileMapper;
import com.kirin.bigfileupload.servie.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;

    @Override
    public void addFile(UploadFile filePO) {
        fileMapper.insertFile(filePO);
    }

    @Override
    public Boolean selectFileByMd5(String md5) {
        UploadFile filePO = fileMapper.selectFileByMd5(md5);
        return Objects.nonNull(filePO);
    }

    @Override
    public List<UploadFile> selectFileList() {
        return fileMapper.selectFileList();
    }
}
