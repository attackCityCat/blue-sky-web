package org.bs.web.util;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Lenovo
 * @title: FileUtil
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/1617:59
 */
public class FileUtil {

    public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException{

        //获取服务器的存储路径
        String path = request.getServletContext().getRealPath("")+"//upload";

        //判断不存在 创建
        File savePath = new File(path);

        if(!savePath.exists()){

            savePath.mkdirs();
        }

        //重命名  1. 时间戳  毫秒  2.UUID  16  32  不重复字符串  1 10亿  100 50%

        //获取后缀名     abc.jpg
        int index = file.getOriginalFilename().lastIndexOf(".");

        String suffix = file.getOriginalFilename().substring(index);

        //System.out.println(suffix);
        //重命名
        //时间戳
        String newFileName = System.currentTimeMillis()+suffix;

        String newFileName2 = UUID.randomUUID()+suffix;

        //转存
        file.transferTo(new File(path+"//"+newFileName));

        return newFileName;
    }

    public static ResponseEntity<byte[]> download(String imgname, HttpServletRequest request) throws IOException {
        HttpHeaders httpHeaders  = new HttpHeaders();
        //设置下载文件类型
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //设置下载文件名
        httpHeaders.setContentDispositionFormData("attachment", imgname);
        //获取保存文件的路径
        String path = request.getServletContext().getRealPath("")+"//upload";

        byte[] arr = FileUtils.readFileToByteArray(new File(path+"//"+imgname));

        return new ResponseEntity<byte[]>(arr,httpHeaders, HttpStatus.CREATED);
    }
}
