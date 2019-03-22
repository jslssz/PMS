package com.briup.party.controller;

import com.briup.party.util.MsgResponse;
import com.briup.party.util.exception.MyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {
    private static String UPLOADED_FOLDER = "D://5720162220//";

    //    form单文件上传
    @PostMapping("/webUpload")
    public MsgResponse FileUpload(MultipartHttpServletRequest Murequest) {
        Map<String, MultipartFile> files = Murequest.getFileMap();//得到文件map对象
        File dir = new File(UPLOADED_FOLDER);
        if (!dir.exists()) {
            dir.mkdir();
        }
        for (MultipartFile file : files.values()) {

            byte[] bytes = new byte[0];
            try {
                bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return MsgResponse.success("接收成功 ", null);
    }

    //    form单文件上传
    @PostMapping("/upload")
//    MultipartFile是Spring上传文件的封装类，包含了文件的二进制流和文件属性等信息，在配置文件中也可对相关属性进行配置，基本的配置信息如下：
    public MsgResponse singleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return MsgResponse.error("上传失败，文件为空");
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            File dir = new File(UPLOADED_FOLDER);
            if (!dir.exists()) {
                dir.mkdir();
            }
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return MsgResponse.success(file.getOriginalFilename(), null);
    }

    @GetMapping("/download")
    public MsgResponse singleFileDownload(HttpServletResponse res) {
        String fileName = "5720162220//styles.css";
        File file = new File("d://" + fileName);
        if (!file.exists()) {
            return MsgResponse.error("文件不存在");
        }
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File("d://"
                    + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new MyException(997, 997 + e.getMessage());
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return MsgResponse.success("下载成功", null);
    }
}
