package string.manipulations;

import java.io.CharArrayReader;
import java.util.*;

public class StringUtils {

    private static Character[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public static int countVowels(String string) {
        Set<Character> vowels = new HashSet<>();
        for (Character ch : VOWELS) {
            vowels.add(ch);
        }

        var counter = 0;
        for (Character ch : string.toLowerCase().toCharArray()) {
            if (vowels.contains(ch)) {
                counter++;
            }
        }

        return counter;
    }

    public static String reverseString(String string) {
        var reverseString = new StringBuilder();
        for (int i = string.length() - 1; i > -1; i--) {
            reverseString.append(string.charAt(i));
        }

        return reverseString.toString();
    }

    public static String reverseWords(String string) {
        var splitSentence = string.trim().split(" ");
        var reverseWords = new StringBuilder();
        for (int i = splitSentence.length - 1; i > -1; i--) {
            reverseWords.append(splitSentence[i] + " ");
        }

        return reverseWords.toString().trim();
    }

    public static boolean areRotations(String string1, String string2) {
        return (string1.length() == string2.length() && (string1 + string1).contains(string2));
    }

    public static String removeDuplicates(String string) {
        var uniqueString = new StringBuilder();
        var lastCh = "";
        for (Character ch : string.toCharArray()) {
            if (!ch.toString().toLowerCase().equals(lastCh)) {
                uniqueString.append(ch);
                lastCh = ch.toString().toLowerCase();
            }
        }
        return uniqueString.toString();
    }

    public static ArrayList<Character> mostAbundantCharacter(String string) {
        Map<Character, Integer> charAbundanceTable = new HashMap<>();

        for (Character ch : string.toCharArray()) {
            charAbundanceTable.merge(ch, 1, Integer::sum);
        }

        ArrayList<Character> mostAbundantChar = new ArrayList<>();
        var abundance = 0;
        for (Character ch: charAbundanceTable.keySet()) {
            if (charAbundanceTable.get(ch) == abundance) {
                abundance = charAbundanceTable.get(ch);
                mostAbundantChar.add(ch);
            }
            else if (charAbundanceTable.get(ch) > abundance) {
                abundance = charAbundanceTable.get(ch);
                mostAbundantChar.clear();
                mostAbundantChar.add(ch);
            }
        }

        return mostAbundantChar;
    }

    public static boolean areAnagrams(String string1, String string2) {
        var string1Array = string1.toCharArray();
        var string2Array = string2.toCharArray();
        Arrays.sort(string1Array);
        Arrays.sort(string2Array);

        return Arrays.equals(string1Array, string2Array);
    }
}
