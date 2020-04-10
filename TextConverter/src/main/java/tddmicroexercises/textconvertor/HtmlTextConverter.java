package tddmicroexercises.textconvertor;

import java.io.IOException;

public class HtmlTextConverter {

    private FileLoader fileLoader;
    private String filePath;

    public HtmlTextConverter(FileLoader fileLoader) {
        this.filePath = fileLoader.getFilePath();
        this.fileLoader = fileLoader;
    }

    public String convertToHtml() throws IOException {
        String line = fileLoader.readLine();
        String html = "";
        while (line != null) {
            html += StringEscapeUtils.escapeHtml(line);
            html += "<br />";
            line = fileLoader.readLine();
        }
        return html;

    }

    public String getFilename() {
        return filePath;
    }

}
