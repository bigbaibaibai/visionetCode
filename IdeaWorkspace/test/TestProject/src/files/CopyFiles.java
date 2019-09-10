package files;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class CopyFiles {

    private static void copyFileUsingFileChannels(File source, File dest) throws IOException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();
        }
    }

    private static void copyFileUsingFiles(File source, File dest) throws IOException{
        Files.copy(source.toPath(), dest.toPath());
    }

    private static void generateFile(File file, List<String> content) throws IOException{
        Files.write(file.toPath(), content, Charset.forName("UTF-8"));
    }

    @Test
    public void testCopyFile(){
        try {
            generateFile(new File("D:\\Documents\\hello.txt"), Arrays.asList("hello world!"));

            copyFileUsingFiles(new File("D:\\Documents\\hello.txt"), new File("D:\\Documents\\hello1.txt"));
            copyFileUsingFileChannels(new File("D:\\Documents\\hello.txt"), new File("D:\\Documents\\hello2.txt"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
