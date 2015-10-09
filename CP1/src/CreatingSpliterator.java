import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by Hernan Y.Ke on 2015/10/8.
 */
public class CreatingSpliterator {
    public static void main(String[] args){
        Path path = Paths.get("CP1/person.txt");   //relative path
        //Path path = Paths.get("CP1\\person.txt");   //Or windows style -- need to escape
        try( Stream<String> lines = Files.lines(path)) {

            Spliterator<String> lineSpliterator = lines.spliterator();
            Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSpliterator);

            Stream<Person> people = StreamSupport.stream(peopleSpliterator, false);
            people.forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
