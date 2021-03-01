package github.copystrike.lotty.command;

import github.copystrike.lotty.command.annotations.Command;

/**
 * CommandHelper -
 *
 * @author Copystrike
 * @since 01/03/2021 @ 03:50
 */
public class CommandHelper {

    /**
     * Will check if the class has an @Command annotation and get the value.
     * @param clazz The LotteryCommand class
     * @return The command name or null if annotation is not found or name is null.
     */
    public String getCommandNameByClass(Class<? extends LotteryCommand> clazz){
        Command commandAnnotation = this.getClass().getAnnotation(Command.class);
        if (commandAnnotation == null) return null;
        return commandAnnotation.value();
    }
}
