package github.copystrike.lotty.command;

import github.copystrike.lotty.LotteryBase;
import github.copystrike.lotty.LotteryPlugin;
import github.copystrike.lotty.player.LotteryPlayer;
import github.copystrike.lotty.player.LotteryStats;
import github.copystrike.lotty.player.LotteryUser;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * LotteryCommand -You will need to create commands to the lottery plugin.
 *
 * @author Copystrike
 * @since 28/02/2021 @ 22:49
 */
public abstract class LotteryCommand implements CommandExecutor {

    private final CommandManager commandManager;
    private final String commandName;
    private final Map<String, LotteryCommand> subcommands;

    public LotteryCommand() {
        CommandHelper commandHelper = new CommandHelper();
        this.commandManager = LotteryPlugin.getLotteryPlugin().getCommandManager();
        this.commandName = commandHelper.getCommandNameByClass(this.getClass());
        this.subcommands = new HashMap<>();
    }

    protected abstract void execute(LotteryCommand lotteryCommand, LotteryUser lotteryUser);

    public void registerSubcommand(LotteryCommand... lotteryCommand) {
        Arrays.stream(lotteryCommand).forEach(lotteryCommandObj -> this.subcommands.put(lotteryCommandObj.commandName, lotteryCommandObj));
    }

    public String getCommandName() {
        return commandName;
    }

    public void addSubcommand(LotteryCommand lotteryCommand) {
        subcommands.put(lotteryCommand.commandName, lotteryCommand);
    }

    public void removeSubcommand(String commandName) {
        subcommands.remove(commandName);
    }

    /**
     * Returns a map with all the subcommands. To modify the map please use;
     * <ul>
     *     <li>{@link LotteryCommand#addSubcommand(LotteryCommand)}</li>
     *     <li>{@link LotteryCommand#addSubcommand(LotteryCommand)}</li>
     * </ul>
     *
     * @return a unmodifiable map of the command and lotteryCommands
     */
    public Map<String, LotteryCommand> getSubcommands() {
        return Collections.unmodifiableMap(subcommands);
    }


    // todo make this a LOT better lmfao
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] strings) {
        execute(this, new LotteryPlayer(commandSender));
        return true;
    }
}
