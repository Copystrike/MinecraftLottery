package github.copystrike.lotty;

import github.copystrike.lotty.command.CommandHandler;
import github.copystrike.lotty.command.CommandManager;
import github.copystrike.lotty.command.commands.LotteryDefaultCommand;
import github.copystrike.lotty.command.commands.LotteryResetStats;
import github.copystrike.lotty.command.commands.LotterySetStats;
import github.copystrike.lotty.command.commands.LotteryStartCommand;
import github.copystrike.lotty.utils.io.imp.MessageConfig;

/**
 * LotteryPlugin - The main class
 *
 * @author Copystrike
 * @since 28/02/2021 @ 19:57
 */
public final class LotteryPlugin extends LotteryBase {

    private static LotteryPlugin lotteryPlugin;
    private CommandManager commandManager;
    private CommandHandler commandHandler;
    private MessageConfig messageConfig;

    @Override
    public void onEnable() {
        initializeInstances();
        createConfigs();
        registerCommands();
    }

    @Override
    public void onDisable() {
        uninitializeInstances();
    }

    /**
     * Initialize instances
     */
    private void initializeInstances() {
        lotteryPlugin = this;
        commandManager = new CommandManager(this);
        commandHandler = new CommandHandler();
        messageConfig = new MessageConfig(this);
    }

    /**
     * Create configs
     */
    private void createConfigs() {
        messageConfig.createFile();
    }

    /**
     * uninitialize instances
     */
    private void uninitializeInstances() {
        lotteryPlugin = null;
        commandManager = null;
        commandHandler = null;
        messageConfig = null;
    }

    /**
     * Register all the commands and subcommands.
     */
    private void registerCommands() {
        LotteryDefaultCommand lotteryCommand = new LotteryDefaultCommand();
        lotteryCommand.registerSubcommand(
                new LotteryResetStats(),
                new LotteryResetStats(),
                new LotteryStartCommand(),
                new LotterySetStats());
        commandManager.registerCommand(lotteryCommand);
    }

    @Override
    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    @Override
    public CommandManager getCommandManager() {
        return commandManager;
    }

    @Override
    public MessageConfig getMessageConfig() {
        return messageConfig;
    }

    public static LotteryPlugin getLotteryPlugin() {
        return lotteryPlugin;
    }
}
