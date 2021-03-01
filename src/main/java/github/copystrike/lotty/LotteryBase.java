package github.copystrike.lotty;

import github.copystrike.lotty.command.CommandHandler;
import github.copystrike.lotty.command.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * LotteryBase - The base class of the main plugin
 *
 * @author Copystrike
 * @since 28/02/2021 @ 19:58
 */
public abstract class LotteryBase extends JavaPlugin {

    static LotteryPlugin getInstance() {
        return LotteryPlugin.getLotteryPlugin();
    }

    abstract public CommandHandler getCommandHandler();

    abstract public CommandManager getCommandManager();

    public Logger getLotteryLogger() {
        return Bukkit.getLogger();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return getCommandHandler().onCommand(sender, command, label, args);
    }

}
