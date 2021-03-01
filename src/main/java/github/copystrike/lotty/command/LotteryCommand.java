package github.copystrike.lotty.command;

import github.copystrike.lotty.command.exception.MainCommandEndlessAnnotationException;
import github.copystrike.lotty.player.LotteryPlayer;
import github.copystrike.lotty.player.LotteryUser;
import org.apache.commons.lang.ArrayUtils;
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

    private final CommandHelper commandHelper;
    private final Map<String, LotteryCommand> subcommands;

    protected LotteryCommand() {
        this.commandHelper = new CommandHelper();
        this.subcommands = new HashMap<>();
    }

    /**
     * This method will be executed once the user execute a command that is associated with what is defined in {@link LotteryCommand#getCommandName()}.
     * If the class has an permission annotation it will also check if the player requires the correct permission.
     *
     * @param lotteryUser The executor of the command
     * @param args        The arguments that have been passed in.
     */
    protected abstract void execute(LotteryUser lotteryUser, String[] args);

    public void registerSubcommand(LotteryCommand... lotteryCommand) {
        Arrays.stream(lotteryCommand).forEach(lotteryCommandObj -> {
            if (isEndless()) throw new MainCommandEndlessAnnotationException(this.getClass());
            this.subcommands.put(lotteryCommandObj.getSubcommandName(), lotteryCommandObj);
        });
    }

    /**
     * To check if the command is fully usable for in-game use, what I mean with this is that it will check for all the required annotations and everything necessary.
     *
     * @return True if the command is usable false if it is not.
     */
    public boolean isValid() {
        return true;
    }

    public void unRegisterSubcommand(String commandName) {
        subcommands.remove(commandName);
    }

    /**
     * Returns a map with all the subcommands. To modify the map please use;
     * <ul>
     *     <li>{@link LotteryCommand#registerSubcommand(LotteryCommand...)}</li>
     *     <li>{@link LotteryCommand#unRegisterSubcommand(String)}</li>
     * </ul>
     *
     * @return a unmodifiable map of the command and lotteryCommands
     */
    public Map<String, LotteryCommand> getSubcommands() {
        return Collections.unmodifiableMap(subcommands);
    }

    public String getCommandName() {
        return commandHelper.getCommandName(this.getClass());
    }

    public String getSubcommandName() {
        return commandHelper.getSubcommandName(this.getClass());
    }

    public boolean isEndless() {
        return commandHelper.isCommandArgumentsEndless(this.getClass());
    }

    /**
     * @return Will return null if permission annotation is not found.
     */
    public String getPermission() {
        return commandHelper.getCommandPermission(this.getClass());
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        LotteryPlayer lotteryUser = new LotteryPlayer(commandSender);
        executeCommand(lotteryUser, this, args);
        return true;
    }

    private void executeCommand(LotteryPlayer lotteryPlayer, LotteryCommand lotteryCommand, String[] args) {
        if (lotteryCommand.getPermission() == null || ((CommandSender) lotteryPlayer).hasPermission(lotteryCommand.getPermission())) {
            if (args.length == 0) {
                lotteryCommand.execute(lotteryPlayer, args);
            } else {
                for (int i = 0; i < args.length; i++) {
                    String argument = args[i];
                    System.out.println("The first arguments " + argument);
                    Map<String, LotteryCommand> subcommands = lotteryCommand.getSubcommands();

                    System.out.println(subcommands.keySet());

                    LotteryCommand lotterySubcommand = subcommands.get(argument);
                    if (lotterySubcommand != null) {
                        if (lotterySubcommand.getPermission() == null || ((CommandSender) lotteryPlayer).hasPermission(lotterySubcommand.getPermission())) {
                            String nextArgument = args[i + 1];
                            System.out.println("The next arguments " + nextArgument);
                            LotteryCommand nextLotterySubcommand = lotterySubcommand.getSubcommands().get(nextArgument);
                            if (nextLotterySubcommand != null) {
                                nextLotterySubcommand.executeCommand(lotteryPlayer, nextLotterySubcommand, Arrays.copyOfRange(args, i + 1, args.length));
                                System.out.println("The copyarray arguments " + Arrays.toString(Arrays.copyOfRange(args, i + 1, args.length)));
                            }
                        } else {
                            lotteryPlayer.sendFormattedMessage("You do not have the right permissions to execute this command.");
                            break;
                        }
                    } else {
                        lotteryPlayer.sendFormattedMessage("This command doesn't exist");
                        break;
                    }
                }
            }

        }
    }
}
