package github.copystrike.lotty.game;

import github.copystrike.lotty.game.enums.GameState;
import github.copystrike.lotty.player.LotteryPlayer;

import java.util.HashMap;
import java.util.UUID;

/**
 * Game -
 *
 * @author Copystrike
 * @since 28/02/2021 @ 21:55
 */
public interface Game {

    /**
     * Generate random numbers based on and invoke them into {@link Game#setRaffleNumbers(int[])};
     * The random generated numbers will also be returned when calling this method.
     * <ul>
     *     <li>{@link Game#getMinRange()}</li>
     *     <li>{@link Game#getMaxRange()}</li>
     *     <li>{@link Game#getWinners()}</li>
     * </ul>
     * @return The Integer array of random generated numbers.
     */
    int[] generateRaffleNumbers();

    UUID getUuid();

    HashMap<UUID, LotteryPlayer> getLotteryPlayerHashMap();

    GameState getGameState();

    void setGameState(GameState gameState);

    int getWinners();

    void setWinners(int winners);

    int getMinRange();

    void setMinRange(int minRange);

    int getMaxRange();

    void setMaxRange(int maxRange);

    int[] getRaffleNumbers();

    void setRaffleNumbers(int[] raffleNumbers);
}
