import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.nio.file.Files.*;

/**
 * Created by Hernan Y.Ke on 2015/10/9.
 */
public class Exec {
    Path path = Paths.get("xx");

       // Stream<String> stream = Files.lines(path);

    //Function<String, Stream<String>> splitIntoWords = line ->Stream.of(line.split(" "));
    //equal to
    //Function<String, Stream<String>> splitIntoWords = line -> Pattern.compile(" ").splitAsStream(line);

   // Stream.of(s1,s2).flatMap(Function.identity()).flatMap(splitIntoWords);


}
