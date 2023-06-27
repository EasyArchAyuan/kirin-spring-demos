package com.kirin.bigfileupload.controller;

import com.kirin.bigfileupload.servie.ChunkService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Controller
@CrossOrigin
@Slf4j
public class DownLoadController {

    @Value("${file.path}")
    private String filePath;

    private final ChunkService chunkService;

    public DownLoadController(ChunkService chunkService) {
        this.chunkService = chunkService;
    }

    @PostMapping("/download")
    public void download(@RequestParam("md5") String md5,
                         @RequestParam("fileName") String fileName,
                         @RequestParam("chunkSize") Integer chunkSize,
                         @RequestParam("chunkTotal") Integer chunkTotal,
                         @RequestParam("index") Integer index,
                         HttpServletResponse response) {
        String[] splits = fileName.split("\\.");
        String type = splits[splits.length - 1];
        String resultFileName = filePath + md5 + "." + type;

        File resultFile = new File(resultFileName);

        long offset = (long) chunkSize * (index - 1);
        if (Objects.equals(index, chunkTotal)) {
            offset = resultFile.length() - chunkSize;
        }
        byte[] chunk = chunkService.getChunk(index, chunkSize, resultFileName, offset);

        log.info("下载文件分片:{},{},{},{},{}", resultFileName, index, chunkSize, chunk.length, offset);
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.addHeader("Content-Length", String.valueOf(chunk.length));
        response.setHeader("filename", fileName);

        response.setContentType("application/octet-stream");
        ServletOutputStream out;
        try {
            out = response.getOutputStream();
            out.write(chunk);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
