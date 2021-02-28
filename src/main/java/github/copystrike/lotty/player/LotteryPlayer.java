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

    public LotteryPlayer(CommandSender sender) {
        this.sender = sender;
    }

    @Override
    public boolean isOp() {
        return sender.isOp();
    }

    @Override
    public void setOp(boolean value) {
        sender.setOp(value);
    }
}
