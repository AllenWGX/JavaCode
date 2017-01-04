package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import opt.BasicOpt;

public class FileReaderUtil {
    public static void _buffer_reader(String _file, BasicOpt _opt) throws IOException{
        _buffer_reader(new File(_file), _opt);
    }
    
    public static void _buffer_reader(File _file, BasicOpt _opt) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(_file));
        String line;
        while( (line = br.readLine()) != null ){
            _opt.opterateString(line);
        }
        br.close();
    }
    
}
