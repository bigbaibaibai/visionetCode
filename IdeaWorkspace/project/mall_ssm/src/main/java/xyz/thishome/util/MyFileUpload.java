package xyz.thishome.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传
 */
public class MyFileUpload {

    /**
     * 上传图片，返回图片url集合
     *
     * @param multipartFiles
     * @return
     */
    public static List<String> upload_images(MultipartFile[] multipartFiles) throws IOException {
        String PICTURE_WINDOWS_PATH = PropertiesUtil.getValue("properties/myUpload.properties","PICTURE_WINDOWS_PATH");
        if (multipartFiles != null && multipartFiles.length > 0) {
            List<String> upload_images = new ArrayList<>();

            for (MultipartFile file : multipartFiles) {
                //原始文件名，带后缀
                String originalFilename = file.getOriginalFilename();
                //完整文件名，uuid加原始文件名
                String name = UUID.randomUUID().toString() + originalFilename;
                //完整文件上传路径
                String upload_name = PICTURE_WINDOWS_PATH + "/" + name;
                try {
                    //上传文件
                    file.transferTo(new File(upload_name));
                    upload_images.add(name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return upload_images;
        }
        return null;
    }

}
