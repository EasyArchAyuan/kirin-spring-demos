package com.kirin.bigfileupload.dao;

import com.kirin.bigfileupload.bean.Chunk;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChunkMapper {
    List<Chunk> selectChunkListByMd5(String md5);

    Integer insertChunk(Chunk chunkPO);

    void deleteChunkByMd5(String md5);
}
