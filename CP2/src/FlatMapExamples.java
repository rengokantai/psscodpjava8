

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Hernan Y.Ke on 2015/10/9.
 */
public class FlatMapExamples {

    public static void main(String[] args)throws IOException{

        Stream<String> stream1 = Files.lines(Paths.get("CP2/1.txt"));
        Stream<String> stream2 = Files.lines(Paths.get("CP2/2.txt"));
        Stream<String> stream3 = Files.lines(Paths.get("CP2/3.txt"));

        Stream<Stream<String>> streamOfStreams = Stream.of(stream1,stream2,stream3);
        System.out.println(streamOfStreams.count());

        System.out.println(stream1.count());
        System.out.println(stream2.count());
        System.out.println(stream3.count());
    }
}
