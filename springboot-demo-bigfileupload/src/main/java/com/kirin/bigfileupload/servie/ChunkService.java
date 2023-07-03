package com.kirin.bigfileupload.servie;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChunkService {
    void saveChunk(MultipartFile chunk, String md5, Integer index, Long chunkSize, String resultFileName);

    List<Integer> selectChunkListByMd5(String md5);

    void deleteChunkByMd5(String md5);

    byte[] getChunk(Integer index, Integer chunkSize, String resultFileName,long offset);
}
