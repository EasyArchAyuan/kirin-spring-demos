package com.kirin.bigfileupload.servie.impl;

import com.kirin.bigfileupload.bean.Chunk;
import com.kirin.bigfileupload.dao.ChunkMapper;
import com.kirin.bigfileupload.servie.ChunkService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChunkServiceImpl implements ChunkService {
    private final ChunkMapper chunkMapper;

    public ChunkServiceImpl(ChunkMapper chunkMapper) {
        this.chunkMapper = chunkMapper;
    }

    @Override
    public void saveChunk(MultipartFile chunk, String md5, Integer index, Long chunkSize, String resultFileName) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(resultFileName, "rw")) {
            // 偏移量
            long offset = chunkSize * (index - 1);
            // 定位到该分片的偏移量
            randomAccessFile.seek(offset);
            // 写入
            randomAccessFile.write(chunk.getBytes());
            Chunk chunkPO = new Chunk(null,md5, index);
            chunkMapper.insertChunk(chunkPO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Integer> selectChunkListByMd5(String md5) {
        List<Chunk> chunkPOList = chunkMapper.selectChunkListByMd5(md5);
        List<Integer> indexList = new ArrayList<>();
        for (Chunk chunkPO : chunkPOList) {
            indexList.add(chunkPO.getIndex());
        }
        return indexList;
    }

    @Override
    public void deleteChunkByMd5(String md5) {
        chunkMapper.deleteChunkByMd5(md5);
    }

    @Override
    public byte[] getChunk(Integer index, Integer chunkSize, String resultFileName, long offset) {
        File resultFile = new File(resultFileName);
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(resultFileName, "r")) {
            // 定位到该分片的偏移量
            randomAccessFile.seek(offset);
            //读取
            byte[] buffer = new byte[chunkSize];
            randomAccessFile.read(buffer);
            return buffer;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
