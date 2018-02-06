import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        long words = 1;
        for (int i = 0; i < contents.length() - 2; i++) {
            if (contents.charAt(i) == ' ' || contents.substring(i, i + 2).contentEquals("\n")) {
                words++;
            }
        }
        System.out.println(words);
        long specificWordCount = 0;
        String specificWord = "Prince";
        for (int i = 0; i < contents.length() - specificWord.length(); i ++) {
            if (specificWord.toLowerCase().contentEquals(contents.substring(i, i+specificWord.length()).toLowerCase())) {
                specificWordCount++;
            }
        }
        System.out.println(specificWordCount);
        return contents;
    }

    public static void main(String[] unused) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(urlToString("https://www.bls.gov/tus/charts/chart9.txt"));
        System.out.println(urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt"));
    }
}
