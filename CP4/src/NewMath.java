import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Hernan Y.Ke on 2015/10/10.
 */
public class NewMath {

    public static Optional<Double> sqrt(Double d){
        return d >0d ? Optional.of(Math.sqrt(d)) :  Optional.empty();
    }
    public static Optional<Double> inv(Double d){
        return d >0d ? Optional.of(Math.sqrt(1d/d)) :  Optional.empty();
    }

}
