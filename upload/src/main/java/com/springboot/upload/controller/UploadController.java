package com.springboot.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/*
* 上传文件控制器
* 直接上传到服务器
* */
@Controller
public class UploadController {
    //指定一个临时目录作为上传目录
//    private static String UPLOAD_FOLDER = "E:/temp/";
//    遇到http://loaclhost:8080,则跳转到upload.html页面
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    @GetMapping("/")
    public String index(){
        return "upload";
    }
//
    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file")MultipartFile srcFile, RedirectAttributes redirectAttributes){
        //前端没有选择文件。srcFile为空
        if(srcFile.isEmpty()){
            redirectAttributes.addFlashAttribute("message","请选择一个文件");
            return "redirect:upload_status";
        }
        //选择了文件，开始进行上传操作
        try {
//            构建上传目标路径,找到项目的target的classes目录
            File destFile = new File(ResourceUtils.getURL("classPath").getPath());
            if(!destFile.exists()){
                destFile = new File("");
            }
            System.out.println("file path:"+destFile.getAbsolutePath());
            //拼接static目录
            File upload = new File(destFile.getAbsolutePath(),df.format(new Date())+"/");
            String fileName= srcFile.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            fileName= UUID.randomUUID() +suffixName;

//            若木比奥文件夹不存在，则自动创建
            if(!upload.exists()){
                upload.mkdirs();
            }
            System.out.println("完整的上传路径："+upload.getAbsolutePath()+"/"+fileName);



            //更具srcFlie的大小准备字节数组,装备一个字节数组
            byte[] bytes = srcFile.getBytes();
            //拼接上传路径
//            Path path = Paths.get(UPLOAD_FOLDER + srcFile.getOriginalFilename());
            //最重要的一步，开始将源文件写入目标地址
            Path path = Paths.get(upload.getAbsolutePath()+"/"+fileName);
            Files.write(path,bytes);
            //将文件上传成功的信息写入messages
            redirectAttributes.addFlashAttribute("message","文件上传成功"+fileName);
        }catch (IOException e){
            e.printStackTrace();
        }
        return "redirect:upload_status";
    }
    //匹配upload_status页面
    @GetMapping("/upload_status")
    public String uploadStatusPage(){
        return "upload_status";
    }
}
