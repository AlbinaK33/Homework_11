import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TaskStream {

    public static String returnNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(n -> n % 2 == 0)
                .mapToObj(n -> (n+1) + ". " + names.get(n))
                .collect(Collectors.joining(", "));
    }

    public static List<String> returnSortNames(List<String> names) {
        return names.stream()
                .map(n -> n.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static String returnSortArray(String[] numbers) {
        return Arrays.stream(numbers)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static Stream<Long> randomStream(long seed, long a, long c, long m) {
        return Stream.iterate(seed, n -> (a * n + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstList = new ArrayList<>();
        first.forEach(firstList::add);
        List<T> secondList = new ArrayList<>();
        second.forEach(secondList::add);

        Stream<T> mixedStream = Stream.empty();
        if (!firstList.isEmpty() && !secondList.isEmpty()) {


            List<T> mixedList = new ArrayList<>();
            ListIterator<T> firstIterator = firstList.listIterator();
            ListIterator<T> secondIterator = secondList.listIterator();
            while (firstIterator.hasNext() || secondIterator.hasNext()) {
                if (!firstIterator.hasNext() || !secondIterator.hasNext()) {
                    break;
                }

                if (firstIterator.hasNext()) {
                    mixedList.add(firstIterator.next());
                }

                if (secondIterator.hasNext()) {
                    mixedList.add(secondIterator.next());
                }
            }

            mixedStream = mixedList.stream();

        }

        return mixedStream;
    }
}
