package tddmicroexercises.textconvertor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HtmlTextConverterTest {

    private static final String FILE_NAME = "fake_file.txt";

    @Mock
    private FileLoader fileLoader;

    @Before
    public void setUp() {
        when(fileLoader.getFilePath()).thenReturn(FILE_NAME);
    }

    @Test
    public void testGetFileName() {
        HtmlTextConverter converter = new HtmlTextConverter(fileLoader);
        assertEquals(FILE_NAME, converter.getFilename());
    }

    @Test
    public void whenText_hasNoLines_thenEmpty() throws IOException {
        when(fileLoader.readLine()).thenReturn(null);

        HtmlTextConverter converter = new HtmlTextConverter(fileLoader);
        assertEquals("", converter.convertToHtml());
    }

    @Test
    public void whenText_hasOneLine_thenOneLineAndBr() throws IOException {
        when(fileLoader.readLine()).thenReturn("line1").thenReturn(null);

        HtmlTextConverter converter = new HtmlTextConverter(fileLoader);
        assertEquals("line1<br />", converter.convertToHtml());
    }

    @Test
    public void whenText_hasTwoLines_thenBrAfterEach() throws IOException {
        when(fileLoader.readLine()).thenReturn("line1").thenReturn("line2").thenReturn(null);

        HtmlTextConverter converter = new HtmlTextConverter(fileLoader);
        assertEquals("line1<br />line2<br />", converter.convertToHtml());
    }

    @Test
    public void whenText_hasAnd_thenItsEscaped() throws IOException {
        when(fileLoader.readLine()).thenReturn("li&ne").thenReturn(null);

        HtmlTextConverter converter = new HtmlTextConverter(fileLoader);
        assertEquals("li&amp;ne<br />", converter.convertToHtml());
    }

    @Test
    public void whenText_hasLowerThan_thenItsEscaped() throws IOException {
        when(fileLoader.readLine()).thenReturn("li<ne").thenReturn(null);

        HtmlTextConverter converter = new HtmlTextConverter(fileLoader);
        assertEquals("li&lt;ne<br />", converter.convertToHtml());
    }

    @Test
    public void whenText_hasGreaterThan_thenItsEscaped() throws IOException {
        when(fileLoader.readLine()).thenReturn("li>ne").thenReturn(null);

        HtmlTextConverter converter = new HtmlTextConverter(fileLoader);
        assertEquals("li&gt;ne<br />", converter.convertToHtml());
    }

    @Test
    public void whenText_hasDoubleQuote_thenItsEscaped() throws IOException {
        when(fileLoader.readLine()).thenReturn("li\"ne").thenReturn(null);

        HtmlTextConverter converter = new HtmlTextConverter(fileLoader);
        assertEquals("li&quot;ne<br />", converter.convertToHtml());
    }

    @Test
    public void whenText_hasSingleQuote_thenItsEscaped() throws IOException {
        when(fileLoader.readLine()).thenReturn("li'ne").thenReturn(null);

        HtmlTextConverter converter = new HtmlTextConverter(fileLoader);
        assertEquals("li&quot;ne<br />", converter.convertToHtml());
    }

}
