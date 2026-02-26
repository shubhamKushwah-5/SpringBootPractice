import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,5,7,8,11,9);

        Stream<Integer> data = nums.stream(); //returns stream of data
       // long count = data.count();
        //System.out.println(count);

//        Predicate<Integer> predi = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer n) {
//                if(n%2 ==1)
//                    return true;
//                else
//                     return false;
//            }
//        };

        Predicate<Integer> predi =  n -> (n%2 == 1);

       int result =  nums.stream()
                .filter(n -> n%2 ==1)
                .sorted()
                .map(n -> n*2)
                .reduce(0,(c,e) -> c+e);
               //.forEach(n -> System.out.println(n));

        System.out.println(result);

//        Stream<Integer> mappedData = data.map(n -> n*2);
//
//        Stream<Integer> sortedData = data.sorted();
//        sortedData.forEach(n -> System.out.println(n));

        //data.forEach(n -> System.out.println(n));

//        for(int n: nums){
//            System.out.println(n*2);
//        }

    }
}