import java.io.*;

public class Main {
    public static void main(String[] args) {

        String inputFile = args[0];
        String outputFile = args[1];

        try (
                FileReader fr = new FileReader(inputFile);
                FileWriter fw = new FileWriter(outputFile)) {

            StringBuilder sb = new StringBuilder();
            int ch;
            while ((ch = fr.read()) != -1) {
                sb.append((char) ch);
            }
            String content = sb.toString();

            String CT = cloneWords(content, 'у');
            String IT = invertText(CT);
            String dop = Case(IT);
            fw.write(dop);
        }
        catch (IOException e) {
            System.err.println("er with fr or fw: " + e.getMessage());
        }
    }

    private static String cloneWords(String text, char target) {
        StringBuilder result = new StringBuilder();
        String[] words = text.split("_");

        for (String word : words) {
            if (word.toLowerCase().contains(String.valueOf(target).toLowerCase())) {
                result.append(word).append(word).append("_");
            } else {
                result.append(word).append("_");
            }
        }
        if (result.length() > 0 && result.charAt(result.length() - 1) == '_') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    private static String invertText(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    private static String Case(String text){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(Character.toUpperCase(ch));
            }
        }
        return result.toString();
    }
}