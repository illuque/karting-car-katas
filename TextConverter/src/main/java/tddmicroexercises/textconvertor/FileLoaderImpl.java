package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileLoaderImpl implements FileLoader {

    private String filePath;
    private BufferedReader reader;

    FileLoaderImpl(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        this.reader = new BufferedReader(new FileReader(filePath));
    }

    public String readLine() throws IOException {
        return reader.readLine();

    }

    public String getFilePath() {
        return filePath;
    }

}
