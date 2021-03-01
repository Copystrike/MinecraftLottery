package github.copystrike.lotty.command;

import github.copystrike.lotty.LotteryBase;
import github.copystrike.lotty.LotteryPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * CommandHandler -
 *
 * @author Copystrike
 * @since 28/02/2021 @ 23:22
 */
public class CommandHandler {

    private CommandManager commandManager;

    public CommandHandler() {
        LotteryBase lotteryBase = LotteryPlugin.getLotteryPlugin();
        this.commandManager = lotteryBase.getCommandManager();
    }
}
