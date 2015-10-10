import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Hernan Y.Ke on 2015/10/10.
 */
public class MainUsingCollectors {

    public static void main(String[] args) throws IOException{
        Path shakePath = Paths.get("CP5/s.txt");
        Path cPath = Paths.get("CP5/t.txt");

        try(Stream<String> c = Files.lines(cPath); Stream<String> s = Files.lines(shakePath);){
            Set<String> scr = c.collect(Collectors.toSet());
            Set<String> skr = s.collect(Collectors.toSet());
            System.out.println(scr.size());
            System.out.println(skr.size());

            final int [] scrabble = {1,3,4,5,6,7,1,3,4,5,6,7,1,3,4,5,6,7,1,3,4,5,6,7,1,2};

            Function<String, Integer> score = word ->word.chars().map(letter -> scrabble[letter - 'a']).sum();



            //filter out word that in scr. i.e. banned words


            final int [] scrabbledis = {1,3,4,5,6,7,1,3,4,5,6,7,1,3,4,5,6,7,1,3,4,5,6,7,1,2};
            Function<String, Map<Integer, Long>> hisToW =word->word.chars().boxed().collect(Collectors.groupingBy(letter->letter, Collectors.counting()));

            Function<String, Long> nblanks  =word->hisToW.apply(word).entrySet().stream().mapToLong(entry->Long.max(entry.getValue()- (long)scrabbledis[entry.getKey()-'a'],0L)).sum();

            Function<String, Integer> score2 = word->hisToW.apply(word).entrySet().stream().mapToInt(entry->scrabble[entry.getKey()-'a']* Integer.min(entry.getValue().intValue(), scrabbledis[entry.getKey()-'a'])).sum();
            Map<Integer, List<String>> histoWords = skr.stream().filter(word -> scr.contains(word)).filter(word->nblanks.apply(word)<=2 ).collect(Collectors.groupingBy(score));
            histoWords.entrySet().stream().sorted(Comparator.comparing(entry-> -entry.getKey())).limit(3).forEach(entry->System.out.println(entry.getKey() + " " +entry.getValue()));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
