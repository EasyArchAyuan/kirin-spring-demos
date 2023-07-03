package com.kirin.bigfileupload.servie;

import com.kirin.bigfileupload.bean.UploadFile;

import java.util.List;

public interface FileService {
    void addFile(UploadFile filePO);

    Boolean selectFileByMd5(String md5);

    List<UploadFile> selectFileList();
}
