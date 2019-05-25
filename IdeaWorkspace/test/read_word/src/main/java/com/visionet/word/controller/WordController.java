package com.visionet.word.controller;

import com.visionet.word.utils.ReadWordUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WordController {

    @Value("folderName")
    public static String folderName;

    @RequestMapping("/readWord")
    public Map readWord(@RequestParam("path") String path) {

        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> files = null;
        try {
            files = getFiles(path);
        } catch (Exception e) {
            map.put("msg", "失败！" + e.getMessage());
            return map;
        }

        ArrayList<String> finalFiles = files;
        new Thread(() -> {
            try {
                for (String file : finalFiles) {
                    //获取word文字内容
                    String word = ReadWordUtil.readWord(file);
                    if ("".equals(word))
                        return;

                    //处理文件名
                    //在前面加上处理后作为文件夹名
                    StringBuilder sb = new StringBuilder(file.toString());
                    int index = sb.lastIndexOf("\\");
                    sb.replace(index, index + 1, "\\" + "处理后的文件" + "\\");
                    int index2 = sb.lastIndexOf(".");
                    sb.replace(index2, sb.length(), ".txt");
                    File f = new File(sb.toString());
                    f.getParentFile().mkdirs();

                    try (
                            Writer os = new FileWriter(f);
                            BufferedWriter bw = new BufferedWriter(os);
                    ) {
                        //写文件
                        bw.write(word);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).run();

        map.put("msg", "成功！");
        return map;
    }

    public static ArrayList<String> getFiles(String path) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
//              System.out.println("文件夹：" + tempList[i]);
            }
        }
        return files;
    }


//    public static void main(String[] args) {
//        ArrayList<String> files = getFiles("D:\\文档\\note\\基础\\JavaWeb");
//        try {
//            for (String file : files) {
//                //获取word文字内容
//                String word = ReadWordUtil.readWord(file);
//                //处理文件名
//                //在前面加上处理后作为文件夹名
//                StringBuilder sb = new StringBuilder(file.toString());
//                int index = sb.lastIndexOf("\\");
//                sb.replace(index, index + 1, "\\" + "处理后的文件" + "\\");
//                int index2 = sb.lastIndexOf(".");
//                sb.replace(index2, sb.length(), ".txt");
//                File f = new File(sb.toString());
//                f.getParentFile().mkdirs();
//                OutputStream os = new FileOutputStream(f, false);
//                //写文件
//                os.write(word.getBytes());
//                os.close();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
