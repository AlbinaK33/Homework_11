import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestTaskStream {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("John", "Merry", "Katty", "Michel", "Larry", "Perry");
        System.out.println(TaskStream.returnNames(names));
        System.out.println(TaskStream.returnSortNames(names));

        String[] numbers = {"1, 2, 0", "4, 5"};
        System.out.println(TaskStream.returnSortArray(numbers));


        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        TaskStream.randomStream(0, a, c, m)
                .limit(10)
                .forEach(System.out::println);


        Stream<Integer> first = Stream.of(1, 3, 5, 7, 9);
        Stream<Integer> second = Stream.of(2, 4, 6, 8);
        Stream<Integer> result= TaskStream.zip(first, second);
        result.forEach(System.out::println);


    }
}
