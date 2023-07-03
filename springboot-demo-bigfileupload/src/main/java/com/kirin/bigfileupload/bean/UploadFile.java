package com.kirin.bigfileupload.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadFile {

    Integer fileId;

    String md5;

    String name;

    Long size;
}
