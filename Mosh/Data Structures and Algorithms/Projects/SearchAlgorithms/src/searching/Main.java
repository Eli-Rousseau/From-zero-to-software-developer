package searching;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 1, 8, 54, 58, 89, 99, 108, 163};
        var searcher = new ExponentialSearch();
        var indexQuery = searcher.exponentialSearching(numbers, 1);
        System.out.println(indexQuery);
    }
}
