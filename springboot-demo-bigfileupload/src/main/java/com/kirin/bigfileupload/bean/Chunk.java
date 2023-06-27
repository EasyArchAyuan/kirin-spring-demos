package com.kirin.bigfileupload.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chunk {

    Integer chunkId;

    String md5;

    Integer index;
}
