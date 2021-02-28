package github.copystrike.lotty.game;

import github.copystrike.lotty.game.enums.GameState;
import github.copystrike.lotty.player.LotteryPlayer;
import github.copystrike.lotty.utils.NumberUtils;

import java.util.HashMap;
import java.util.UUID;

/**
 * Lottery - The LotteryGame object, this is what a lottery will exist out of.
 *
 * @author Copystrike
 * @since 28/02/2021 @ 20:12
 */
public class LotteryGame implements Game {

    private final UUID uuid;
    private final HashMap<UUID, LotteryPlayer> lotteryPlayerHashMap;
    private GameState gameState;
    private int winners;
    private int minRange;
    private int maxRange;
    private int[] raffleNumbers;

    public LotteryGame(UUID uuid, HashMap<UUID, LotteryPlayer> lotteryPlayerHashMap, int winners, int minRange, int maxRange) {
        this.uuid = uuid;
        this.lotteryPlayerHashMap = lotteryPlayerHashMap;
        this.winners = winners;
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.raffleNumbers = new int[maxRange];
    }

    @Override
    public int[] generateRaffleNumbers() {
        for (int i = 0; i < winners; i++) raffleNumbers[i] = NumberUtils.getRandomInt(minRange, maxRange);
        return raffleNumbers;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public HashMap<UUID, LotteryPlayer> getLotteryPlayerHashMap() {
        return lotteryPlayerHashMap;
    }

    @Override
    public GameState getGameState() {
        return gameState;
    }

    @Override
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public int getWinners() {
        return winners;
    }

    @Override
    public void setWinners(int winners) {
        this.winners = winners;
    }

    @Override
    public int getMinRange() {
        return minRange;
    }

    @Override
    public void setMinRange(int minRange) {
        this.minRange = minRange;
    }

    @Override
    public int getMaxRange() {
        return maxRange;
    }

    @Override
    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    @Override
    public int[] getRaffleNumbers() {
        return raffleNumbers;
    }

    @Override
    public void setRaffleNumbers(int[] raffleNumbers) {
        this.raffleNumbers = raffleNumbers;
    }
}
