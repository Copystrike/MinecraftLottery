package github.copystrike.lotty.player;

import org.bukkit.permissions.ServerOperator;

/**
 * LotteryUser - The base of a LocalUser
 *
 * @author Copystrike
 * @since 28/02/2021 @ 21:41
 */
public interface LotteryUser extends ServerOperator {

    int getWins();

    int getLosses();

    int addWin(int amount);

    int addLoss(int amount);

    void setWins(int amount);

    void setLoss(int amount);
}
