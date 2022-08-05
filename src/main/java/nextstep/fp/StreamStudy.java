package nextstep.fp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

    public static long countWords() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long count = 0;
//        for (String w : words) {
//            if (w.length() > 12) count++;
//        }
        count = words.stream().filter(word -> word.length() > 12 ).count();
        return count;
    }

    public static List<String> printLongestWordTop100() throws IOException {
        String contents = new String(Files.readAllBytes(Paths
                .get("src/main/resources/fp/war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // TODO 이 부분에 구현한다.
        List<String> longestSortedWordsTop100 = words.stream()
                .distinct()
                .filter(word -> word.length() > 12)
                .sorted((a,b) -> {return b.length() - a.length();})
                .limit(100)
                .map(word -> word.toLowerCase())
                .collect(Collectors.toList());

        return longestSortedWordsTop100;
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        long result = numbers.stream()
                .filter(number -> number > 3)
                .map(number -> number * 2)
                .reduce(0, (x, y) -> x + y);

        return result;
    }
}