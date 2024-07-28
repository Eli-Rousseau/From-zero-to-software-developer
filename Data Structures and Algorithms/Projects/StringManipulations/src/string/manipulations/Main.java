package string.manipulations;

public class Main {
    public static void main(String[] args) {
        var string = "Hello Enjoyable World";
        System.out.println(StringUtils.countVowels(string));
        System.out.println(StringUtils.reverseString(string));
        System.out.println(StringUtils.reverseWords(string));
        System.out.println(StringUtils.areRotations("ABCD", "CDAB"));
        System.out.println(StringUtils.removeDuplicates(string));
        System.out.println(StringUtils.mostAbundantCharacter(string));
        System.out.println(StringUtils.areAnagrams("ABCD", "ACDB"));
    }
}
