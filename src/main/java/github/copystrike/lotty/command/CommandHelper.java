package github.copystrike.lotty.command;

import github.copystrike.lotty.command.annotations.Command;
import github.copystrike.lotty.command.annotations.Endless;
import github.copystrike.lotty.command.annotations.Permission;
import github.copystrike.lotty.command.annotations.Subcommand;

/**
 * CommandHelper -
 *
 * @author Copystrike
 * @since 01/03/2021 @ 03:50
 */
public class CommandHelper {

    /**
     * Will check if the class has an @Command annotation and get the value.
     *
     * @param clazz The LotteryCommand class
     * @return The command name or null if annotation is not found or name is null.
     */
    public String getCommandName(Class<? extends LotteryCommand> clazz) {
        Command commandAnnotation = clazz.getAnnotation(Command.class);
        if (commandAnnotation == null) return null;
        return commandAnnotation.value();
    }

    /**
     * Will check if the class has an @Subcommand annotation and get the value.
     *
     * @param clazz The LotteryCommand class
     * @return The subcommand name or null if annotation is not found or name is null.
     */
    public String getSubcommandName(Class<? extends LotteryCommand> clazz) {
        Subcommand subcommandAnnotation = clazz.getAnnotation(Subcommand.class);
        if (subcommandAnnotation == null) return null;
        return subcommandAnnotation.value();
    }

    /**
     * This will check if the command class is endless.
     * @param clazz The lotteryCommand class
     * @return true if it has an endless annotation, false if not.
     */
    public boolean isCommandArgumentsEndless(Class<? extends LotteryCommand> clazz) {
        return clazz.getAnnotation(Endless.class) != null;
    }

    /**
     * returns the permission of the command.
     * @param clazz The command class
     * @return The permission, if none defined it will return null.
     */
    public String getCommandPermission(Class<? extends LotteryCommand> clazz) {
        Permission permissionAnnotation = clazz.getAnnotation(Permission.class);
        if (permissionAnnotation == null) return null;
        return permissionAnnotation.value();
    }
}
