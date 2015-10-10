import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

/**
 * Created by Hernan Y.Ke on 2015/10/10.
 */
public class ParallelStreams {
    public static void main(String[] args){

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","2");

        List<String> strings = new ArrayList<>();//may cause race condition
        List<String> stringsafe = new CopyOnWriteArrayList<>(); //Thread safe but terrible performance (concurrent)
        Stream.iterate("+",s->s+"+").parallel().limit(6).peek(s->System.out.print(s +" work at "+ Thread.currentThread().getName())).forEach(System.out::println);
        Stream.iterate("+",s->s+"+").parallel().limit(1000).forEach(s -> strings.add(s));
        System.out.println(strings.size());
    }
}
