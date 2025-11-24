package java8.streams;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFile1 {
    private static List<String> filterAndConvertToUpper(Stream<String> stream, int length) {
        return stream.filter(s -> s.length() == length)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String fileName = "./testFiles/streamFileTest.txt";

        //reading
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            List<String> filteredStrings = filterAndConvertToUpper(lines, 5);
            System.out.println("Filtered strings with length 5 (converted to uppercase): " + filteredStrings);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //writing
        String[] words = {"Hello", "World", "all", "good", "how", "are", "?", "just", "enjoy", "your", "life"};
        try (
                PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Path.of(fileName)))
        ) {
            Stream.of(words).forEach(pw::println);
            System.out.println("Words written to the file successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //parallel reading
        try (Stream<String> text = Files.lines(Paths.get(fileName))) {
            text.parallel().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

