package github.copystrike.lotty.command;

import github.copystrike.lotty.LotteryBase;
import github.copystrike.lotty.LotteryPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;

/**
 * CommandHandler -
 *
 * @author Copystrike
 * @since 28/02/2021 @ 23:22
 */
public class CommandHandler implements CommandExecutor, TabExecutor {

    private CommandManager commandManager;

    public CommandHandler() {
        LotteryBase lotteryBase = LotteryPlugin.getLotteryPlugin();
        this.commandManager = lotteryBase.getCommandManager();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        LotteryCommand lotteryCommand = commandManager.getLotteryCommands().get(label);
        if (lotteryCommand != null) {

        }
        return true;
    }

    // todo add tabshit
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }
}
