package com.kirin.bigfileupload.controller;

import com.kirin.bigfileupload.bean.UploadFile;
import com.kirin.bigfileupload.bean.Result;
import com.kirin.bigfileupload.servie.ChunkService;
import com.kirin.bigfileupload.servie.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin
@Slf4j
public class FileController {

    @Value("${file.path}")
    private String filePath;

    private final FileService fileService;
    private final ChunkService chunkService;

    public FileController(FileService fileService, ChunkService chunkService) {
        this.fileService = fileService;
        this.chunkService = chunkService;
    }

    @GetMapping("/check")
    public Result checkFile(@RequestParam("md5") String md5) {
        log.info("检查MD5:{}", md5);
        //首先检查是否有完整的文件
        Boolean isUploaded = fileService.selectFileByMd5(md5);
        Map<String, Object> data = new HashMap<>();
        data.put("isUploaded", isUploaded);
        //如果有，就返回秒传
        if (isUploaded) {
            return new Result(201, "文件已经秒传", data);
        }
        //如果没有，就查找分片信息，并返回给前端
        List<Integer> chunkList = chunkService.selectChunkListByMd5(md5);
        data.put("chunkList", chunkList);
        return new Result(201, "", data);
    }

    @PostMapping("/upload/chunk")
    public Result uploadChunk(@RequestParam("chunk") MultipartFile chunk,
                              @RequestParam("md5") String md5,
                              @RequestParam("index") Integer index,
                              @RequestParam("chunkTotal") Integer chunkTotal,
                              @RequestParam("fileSize") Long fileSize,
                              @RequestParam("fileName") String fileName,
                              @RequestParam("chunkSize") Long chunkSize
    ) {
        String[] splits = fileName.split("\\.");
        String type = splits[splits.length - 1];
        String resultFileName = filePath + md5 + "." + type;
        chunkService.saveChunk(chunk, md5, index, chunkSize, resultFileName);
        log.info("上传分片：" + index + " ," + chunkTotal + "," + fileName + "," + resultFileName);
        if (Objects.equals(index, chunkTotal)) {
            UploadFile filePO = new UploadFile(null, md5, fileName, fileSize);
            fileService.addFile(filePO);
            chunkService.deleteChunkByMd5(md5);
            return new Result(200, "文件上传成功", index);
        } else {
            return new Result(201, "分片上传成功", index);
        }
    }

    @GetMapping("/fileList")
    public Result getFileList() {
        log.info("查询文件列表");
        List<UploadFile> fileList = fileService.selectFileList();
        return new Result(201, "文件列表查询成功", fileList);
    }
}
