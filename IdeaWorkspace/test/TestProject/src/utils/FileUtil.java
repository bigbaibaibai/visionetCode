package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FileUtil {

    /**
     * 迭代获取文件夹中所有符合后缀的文件，如果是单个文件，则如果满足后缀集合中只有一个对象
     *
     * @param file
     * @param suffix
     * @return
     * @throws FileNotFoundException
     */
    public static Set<File> getFilesForSuffix(File file, String suffix) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        Set<File> files = new HashSet<>();
        //判断是否是文件夹
        if (file.isDirectory()) {
            //new一个栈，用户存储文件夹
            Stack<File> stack = new Stack<>();
            stack.push(file);
            while (!stack.isEmpty()) {
                File pop = stack.pop();
                //把文件夹和符合后缀的筛选出来
                File[] listFiles = pop.listFiles((pathname) -> pathname.isDirectory() || pathname.getName().endsWith(suffix));
                //遍历
                for (File listFile : listFiles) {
                    //如果是文件夹，压入栈中，继续遍历
                    if (listFile.isDirectory()) {
                        stack.push(listFile);
                    } else {   //如果是文件，则添加到集合中
                        files.add(listFile);
                    }
                }
            }
        } else {
            if (file.getName().endsWith(suffix))
                files.add(file);
        }
        return files;
    }

}
