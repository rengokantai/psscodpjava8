import java.util.stream.Stream;

/**
 * Created by Hernan Y.Ke on 2015/10/10.
 */
public class ParallelStreams {
    public static void main(String[] args){

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","2");
        Stream.iterate("+",s->s+"+").parallel().limit(6).peek(s->System.out.print(s +" work at "+ Thread.currentThread().getName())).forEach(System.out::println);
    }
}
