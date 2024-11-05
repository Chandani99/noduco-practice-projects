import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpecialUseCases {
    public void parallelProcessing(){
        List<Integer> numbers = IntStream.range(1, 10000).boxed().collect(Collectors.toList());
        long count = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println(count);
    }
}
