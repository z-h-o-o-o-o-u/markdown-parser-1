//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

// some changes
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        int openBracket;
        int closeBracket;
        int openParen;
        int closeParen;
        while(currentIndex < markdown.length()) {
            openBracket = markdown.indexOf("[", currentIndex);
            closeBracket = markdown.indexOf("]", openBracket);
            openParen = markdown.indexOf("(", closeBracket);
            closeParen = markdown.indexOf(")", openParen);
            if (openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1){return toReturn;}
            else if (hasNewLine(markdown.substring(openBracket, closeBracket))){currentIndex = openBracket; continue;}
            else if (openParen - 1 != closeBracket){currentIndex = closeBracket; continue;}
            else if (hasSpace(markdown.substring(openParen, closeParen))){currentIndex = closeParen; continue;}
            else if (openBracket != 0 && markdown.charAt(openBracket - 1) == '!'){currentIndex = closeParen; continue;}
            else {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;}
        }
        return toReturn;
    }

    public static boolean hasNewLine(String sub) {
        return sub.contains("\n");
    }

    public static boolean hasSpace(String sub) {
        return sub.contains("\n") || sub.contains(" ");
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
