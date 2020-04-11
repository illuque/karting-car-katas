package tddmicroexercises.textconvertor;

import java.io.IOException;

public interface FileLoader {

    String getFilePath();

    String readLine() throws IOException;

}
