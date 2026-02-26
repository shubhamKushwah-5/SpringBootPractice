import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class examplesOfStreams {

    public static void main(String[] args) {
        //creating streams
//        List<String> list  =Arrays.asList("apple", "banaba" ,"cherry");
//        Stream <String> myStream = list.stream ();
//
//        String[] array = {"apple", "banana", "cherry"};
//        Stream<String> stream = Arrays.stream(array);
//
//        Stream<Integer> integerStream = Stream.of(1,2,3);
//
//        Stream<Integer> limit = Stream.iterate(0, n -> n + 1).limit(100);
//
//        Stream<String> limit1 = Stream.generate(() -> "hello").limit(5);
//        Stream<Integer> limit2 = Stream.generate(() -> (int) Math.random() *100).limit(5);

        List<Integer> list1 = Arrays.asList(1, 2,1,1, 4, 5, 6, 67, 54, 34, 3,0,333);
        List<Integer> filteredList = list1.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x /2)
                .distinct()
                .sorted((a,b) -> (b - a ))  //for ascending (a-b)
                .limit(4)
                .skip(1)
                .peek(x -> System.out.println(x))
                .collect(Collectors.toList());
        System.out.println(filteredList);

        //List<Integer> mappedList = filteredList.stream().map(x -> x / 2).collect(Collectors.toList());
        //System.out.println(mappedList);

        List<Integer> collect = Stream.iterate(0, x -> x + 1)
                .limit(101)
                .skip(1)
                .filter(x -> x %2 ==0)
                .map(x -> x/10)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect);

        //.max((a,b) -> a-b)  b-a give max a-b give min these can be used as well
          //      .get()

    }
}
