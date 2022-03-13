package lab2;

import java.io.IOException;

public class FileNotFound extends IOException {
    private String fileName;

    FileNotFound(String fileName){
        this.fileName = fileName;
    }

    @Override
    public String toString(){
        return "FileNotFound - My Exception - File path: " + fileName;
    }
}
