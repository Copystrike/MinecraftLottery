package github.copystrike.lotty.utils;

/**
 * Numbers -
 *
 * @author Copystrike
 * @since 28/02/2021 @ 22:18
 */
public class NumberUtils {

    /**
     * Generates a random number using a formula.
     * Both paramerer
     * @apiNote The 2 parameters min & max are not zero index.
     * @param min the minimum amount.
     * @param max the maximum amount.
     * @return A generated number between those 2 values.
     */
    public static int getRandomInt(int min, int max){
        double minCeil = Math.ceil(min);
        return (int) Math.round(Math.floor(Math.random() * (Math.floor(max) - minCeil) + minCeil));
    }
}
