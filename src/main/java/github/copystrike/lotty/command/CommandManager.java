package github.copystrike.lotty.command;

import github.copystrike.lotty.LotteryBase;
import github.copystrike.lotty.command.annotations.Command;
import github.copystrike.lotty.command.exception.CommandAnnotationNotFound;

import java.util.HashMap;
import java.util.Map;

/**
 * CommandManager - Here the commands will be handled
 *
 * @author Copystrike
 * @since 28/02/2021 @ 22:30
 */
public class CommandManager {

    private final CommandHandler commandHandler;
    private final LotteryBase lotteryBase;
    private final Map<String, LotteryCommand> lotteryCommands;

    public CommandManager(LotteryBase lotteryBase) {
        this.lotteryBase = lotteryBase;
        this.lotteryCommands = new HashMap<>();
        this.commandHandler = new CommandHandler();
    }

    /**
     * Register the command to a map and registering it to the command executor.
     * @param lotteryCommand The command instance.
     */
    public void registerCommand(LotteryCommand lotteryCommand) {
        Command commandAnnotation = lotteryCommand.getClass().getAnnotation(Command.class);
        if (commandAnnotation == null) throw new CommandAnnotationNotFound(lotteryCommand);
        lotteryBase.getServer().getPluginCommand(commandAnnotation.value()).setExecutor(commandHandler);
        lotteryCommands.put(commandAnnotation.value(), lotteryCommand);
    }

    public Map<String, LotteryCommand> getLotteryCommands() {
        return lotteryCommands;
    }
}
