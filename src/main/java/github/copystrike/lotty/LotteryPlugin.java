package github.copystrike.lotty;

import github.copystrike.lotty.command.CommandHandler;
import github.copystrike.lotty.command.CommandManager;

import java.util.logging.Logger;

/**
 * LotteryPlugin - The main class
 *
 * @author Copystrike
 * @since 28/02/2021 @ 19:57
 */
public class LotteryPlugin extends LotteryBase {

    private static LotteryPlugin lotteryPlugin;
    private CommandManager commandManager;
    private CommandHandler commandHandler;

    /**
     * To avoid new instances of this class.
     */
    private LotteryPlugin() {}

    @Override
    public void onEnable() {
        initializeInstances();
    }

    private void initializeInstances() {
        lotteryPlugin = this;
        commandManager = new CommandManager(this);
        commandHandler = new CommandHandler();
    }

    @Override
    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    @Override
    public CommandManager getCommandManager() {
        return commandManager;
    }

    public static LotteryPlugin getLotteryPlugin() {
        return lotteryPlugin;
    }
}
