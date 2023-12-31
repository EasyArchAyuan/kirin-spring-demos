package com.kirin.spring.controller;

import com.kirin.spring.anno.ApiVersion;
import com.kirin.spring.entitys.JsonResponse;
import com.kirin.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Autowired
    private UserService userService;

    @PostMapping("/upload")
    public JsonResponse upload(@RequestParam(value = "file") MultipartFile file) {
        try {
            // 本地文件保存位置
            String uploadPath = "D://upload2/";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            log.info(uploadDir.getAbsolutePath());
            // 本地文件
            File localFile = new File(uploadPath + File.separator + file.getOriginalFilename());
            // transfer to local
            file.transferTo(localFile);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResponse.fail("上传失败");
        }
        return JsonResponse.success();
    }


    @GetMapping("/download")
    public void download(@RequestParam(value = "filename") String filename, HttpServletResponse response) {
        response.reset();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=file_" + System.currentTimeMillis() + ".hprof");
        // 从文件读到servlet response输出流中
        File file = new File(filename); // 改这里
        try (FileInputStream inputStream = new FileInputStream(file)) {
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read(b)) > 0) {
                response.getOutputStream().write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/excel/download")
    public void download(HttpServletResponse response) {
        try {
            response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition",
                    "attachment;filename=user_excel_" + System.currentTimeMillis() + ".xlsx");
            userService.downloadExcel(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @PostMapping("/excel/upload")
    public JsonResponse uploadExcel(@RequestParam(value = "file") MultipartFile file) {
        try {
            userService.uploadExcel(file.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResponse.fail("上传失败");
        }
        return JsonResponse.success();
    }
}
