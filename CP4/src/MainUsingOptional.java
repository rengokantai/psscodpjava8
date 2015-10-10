import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Hernan Y.Ke on 2015/10/10.
 */
public class MainUsingOptional {
    public static void main(String[] args){
        List<Double> result = new ArrayList<>();

        //ThreadLocalRandom.current().doubles(10_000).boxed().forEach(d->NewMath.inv(d).ifPresent(inv->NewMath.sqrt(inv)));
        Function<Double,Stream<Double>> flatMapper = d->NewMath.inv(d).flatMap(inv->NewMath.sqrt(inv)).map(sqrt->Stream.of(sqrt)).orElseGet(()->Stream.empty());

        List<Double> rightResults = ThreadLocalRandom.current().doubles(10_000).parallel().map(d->d * 20 -10).boxed().flatMap(flatMapper).collect(Collectors.toList());

        System.out.println(rightResults.size());
    }
}
