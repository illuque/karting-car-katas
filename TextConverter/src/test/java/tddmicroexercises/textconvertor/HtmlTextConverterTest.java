package tddmicroexercises.textconvertor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class HtmlTextConverterTest {

    @Test
    public void testGetFileName() {
        HtmlTextConverter converter = new HtmlTextConverter("foo");
        assertEquals("fixme", converter.getFilename());
    }

    @Test
    public void whenText_hasNoLines_thenEmpty() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("empty_file");
        assertEquals("", converter.convertToHtml());
    }

    @Test
    public void whenText_hasOneLine_thenOneLineAndBr() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("one_line_file");
        assertEquals("line1<br />", converter.convertToHtml());
    }

    @Test
    public void whenText_hasTwoLines_thenBrAfterEach() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("two_line_file");
        assertEquals("line1<br />line2<br />", converter.convertToHtml());
    }

    @Test
    public void whenText_hasAnd_thenItsEscaped() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("file_with_and");
        assertEquals("li&amp;ne<br />", converter.convertToHtml());
    }

    @Test
    public void whenText_hasLowerThan_thenItsEscaped() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("file_with_lower");
        assertEquals("li&lt;ne<br />", converter.convertToHtml());
    }

    @Test
    public void whenText_hasGreaterThan_thenItsEscaped() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("file_with_greater");
        assertEquals("li&gt;ne<br />", converter.convertToHtml());
    }

    @Test
    public void whenText_hasDoubleQuote_thenItsEscaped() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("file_with_double_quote");
        assertEquals("li&quot;ne<br />", converter.convertToHtml());
    }

    @Test
    public void whenText_hasSingleQuote_thenItsEscaped() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter("file_with_single_quote");
        assertEquals("li&quot;ne<br />", converter.convertToHtml());
    }

}
