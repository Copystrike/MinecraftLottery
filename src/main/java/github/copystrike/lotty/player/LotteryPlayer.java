package github.copystrike.lotty.player;

import github.copystrike.lotty.LotteryBase;
import github.copystrike.lotty.LotteryPlugin;
import github.copystrike.lotty.utils.io.imp.MessageConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.ServerOperator;

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

    @Override
    public void sendFormattedMessage(String message) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', LotteryPlugin.getLotteryPlugin().getMessageConfig().getPrefix() + " " + message));
    }

    @Override
    public void sendMessage(String message) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
