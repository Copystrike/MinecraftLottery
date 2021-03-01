package github.copystrike.lotty.game;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * GameManager - The lottery manager, here the lottery will be managed.
 *
 * @author Copystrike
 * @since 28/02/2021 @ 20:12
 */
public class GameManager {

    private final Map<UUID, Game> lotteryGameList;

    public GameManager(Map<UUID, Game> lotteryGameList) {
        this.lotteryGameList = new HashMap<>();
    }

    /**
     * Add a {@link LotteryGame} instance to the map
     *
     * @param uuid        - An unique identified for the game
     * @param game - Instance of {@link LotteryGame}
     */
    public void addGame(UUID uuid, Game game) {
        lotteryGameList.put(uuid, game);
    }

    /**
     * Removes the {@link LotteryGame} from the map.
     *
     * @param lotteryGameUUID the unique identifier of the game. (If no one messed with the ID of the game ID object it should be fine to use {})
     */
    public void removeGame(UUID lotteryGameUUID) {
        lotteryGameList.remove(lotteryGameUUID);
    }

    /**
     * An unmodifiable map object that cannot be modified.
     * To modify the contents of the map please use:
     * <ul>
     *     <li>{@link GameManager#addGame(UUID, Game)}</li>
     *     <li>{@link GameManager#removeGame(UUID)}</li>
     * </ul>
     *
     * @return An unmodifiable map object.
     */
    public Map<UUID, Game> getLotteryGameList() {
        return Collections.unmodifiableMap(lotteryGameList);
    }
}
