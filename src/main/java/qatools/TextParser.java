package qatools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    public static int getLastNumberFromString(String str) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        int lastNumber = -1;

        while (matcher.find()) {
            lastNumber = Integer.parseInt(matcher.group());
        }

        return lastNumber;
    }
}
