package BuySunscreen.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class intExtractionFromString {
    public static int extractNumerals(String S)
    {
        Pattern intsOnly = Pattern.compile("\\d+");
        Matcher makeMatch = intsOnly.matcher(S);
        makeMatch.find();
        String inputInt = makeMatch.group();
        int temperature = Integer.parseInt(inputInt);
        return temperature;
    }
}
