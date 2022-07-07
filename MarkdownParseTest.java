import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class MarkdownParseTest {

    public static String loadfile(String path) throws IOException {
        String file = Files.readString(Path.of(path));
        //"/Users/zhou/Documents/GitHub/markdown-parser-1/", 
        return file;
    }
    
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test1() throws IOException{
        List<String> l = List.of("https://something.com", "some-thing.html");
        String file = loadfile("test-file.md");
        assertEquals(l, MarkdownParse.getLinks(file));
    }

    @Test
    public void test2() throws IOException{
        List<String> l = List.of("https://google.com", "some-thing.html");
        String file = loadfile("test-file2.md");
        assertEquals(l, MarkdownParse.getLinks(file));
    }

    @Test
    public void test3() throws IOException{
        List<String> l = List.of();
        String file = loadfile("test-file3.md");
        assertEquals(l, MarkdownParse.getLinks(file));
    }

    @Test
    public void test4() throws IOException{
        List<String> l = List.of();
        String file = loadfile("test-file4.md");
        assertEquals(l, MarkdownParse.getLinks(file));
    }

    @Test
    public void test5() throws IOException{
        List<String> l = List.of();
        String file = loadfile("test-file5.md");
        assertEquals(l, MarkdownParse.getLinks(file));
    }
    
    @Test
    public void test6() throws IOException{
        List<String> l = List.of();
        String file = loadfile("test-file6.md");
        assertEquals(l, MarkdownParse.getLinks(file));
    }

    @Test
    public void test7() throws IOException{
        List<String> l = List.of();
        String file = loadfile("test-file7.md");
        assertEquals(l, MarkdownParse.getLinks(file));
    }

    @Test
    public void test8() throws IOException{
        List<String> l = List.of();
        String file = loadfile("test-file8.md");
        assertEquals(l, MarkdownParse.getLinks(file));
    }
    


}