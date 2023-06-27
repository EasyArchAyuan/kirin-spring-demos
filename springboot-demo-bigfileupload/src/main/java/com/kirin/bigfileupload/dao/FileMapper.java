package com.kirin.bigfileupload.dao;

import com.kirin.bigfileupload.bean.UploadFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    Integer insertFile(UploadFile filePO) ;

    UploadFile selectFileByMd5(String md5);

    List<UploadFile> selectFileList();
}
