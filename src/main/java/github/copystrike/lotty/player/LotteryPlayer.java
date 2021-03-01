package github.copystrike.lotty.player;

import org.bukkit.command.CommandSender;

/**
 * LotteryPlayer -
 *
 * @author Copystrike
 * @since 28/02/2021 @ 20:14
 */
public class LotteryPlayer implements LotteryUser {

    private final CommandSender sender;
    private int wins;
    private int losses;

    public LotteryPlayer(CommandSender sender) {
        this.sender = sender;
        this.wins = 0;
        this.losses = 0;
    }

    @Override
    public boolean isOp() {
        return sender.isOp();
    }

    @Override
    public void setOp(boolean value) {
        sender.setOp(value);
    }

    @Override
    public int getWins() {
        return this.wins;
    }

    @Override
    public int getLosses() {
        return this.losses;
    }

    @Override
    public int addWin(int amount) {
        return this.wins =+ amount;
    }

    @Override
    public int addLoss(int amount) {
        return this.losses =- amount;
    }

    @Override
    public void setWins(int amount) {
        this.wins = amount;
    }

    @Override
    public void setLoss(int amount) {
        this.losses = amount;
    }
}
