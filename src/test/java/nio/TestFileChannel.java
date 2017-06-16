package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Future;

import org.junit.Test;

public class TestFileChannel {    
    @Test
    public void asyncReadFile() throws IOException, InterruptedException, URISyntaxException{
        URI file = this.getClass().getResource("/nio_read.txt").toURI();
        Path path = Paths.get(file);
        AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //read only once, if bytebuffer's size is too small then not all
        //content is read
        asynchronousFileChannel.read(buffer, 0, buffer,
                new CompletionHandler<Integer, ByteBuffer>() {
                  @Override
                  public void completed(Integer readCount, ByteBuffer buffer) {
                    System.out.println(new String(buffer.array()));
                  }
                  @Override
                  public void failed(Throwable exc, ByteBuffer buffer) {
                    System.err.println("Error:" + exc);
                  }
                });
        System.out.println("continue doing other things");
        Thread.sleep(10000);
    }

}
