import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * Created by Hernan Y.Ke on 2015/10/9.
 */
public class Shakespeare {

    public static void main(String[] args) throws IOException{
        Set<String> shakespeareWords = Files.lines(Paths.get("CP2/s.txt")).map(word->word.toUpperCase()).collect(Collectors.toSet());

        System.out.println(shakespeareWords.size());

        final int [] scrabble = {1,3,4,5};

        Function<String, Integer> score = word ->word.chars().map(letter -> scrabble[letter - 'a']).sum();

        ToIntFunction<String> intScore = word ->word.chars().map(letter -> scrabble[letter - 'a']).sum();

        System.out.println(intScore.applyAsInt("abc"));


        String bestword = shakespeareWords.stream().filter(word ->shakespeareWords.contains(word)).max(Comparator.comparing(score)).get();
        System.out.println(bestword);
        shakespeareWords.stream().parallel().filter(shakespeareWords::contains).mapToInt(intScore).summaryStatistics();
    }
}
