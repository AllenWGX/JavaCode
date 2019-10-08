package guava_learning.io;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Test;

import com.google.common.io.Files;

public class FilesTest {
    @Test
    public void newFileReaderTest() {
        try( BufferedReader br = Files.newReader(new File("io/READ.txt"), Charset.forName("UTF-8")) ){
            String line = null;
            while( (line = br.readLine()) != null ){
                System.out.println(line);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @Test
    public void newFileWriterTest(){
        try( BufferedWriter bw = Files.newWriter(new File("io/WRITE.txt"), Charset.forName("UTF-8")) ){
            bw.write("南京\n");
            bw.write("苏州\n");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @Test
    public void copyAndEqualTest() throws IOException{
        File source = new File("io/READ.txt");
        File to = new File("io/READ_cpy.txt");
        Files.copy(source, to);
        assert(Files.equal(source, to));
    }
    
    @Test
    public void Test() throws IOException{
        MappedByteBuffer mapBuffer = Files.map(new File("io/READ.txt"), MapMode.READ_WRITE);
        byte[] bytes = new byte[mapBuffer.capacity()];
        mapBuffer.get(bytes);
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes, Charset.forName("UTF-8")));
    }
}
