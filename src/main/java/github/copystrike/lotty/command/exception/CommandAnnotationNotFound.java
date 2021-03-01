package github.copystrike.lotty.command.exception;

import github.copystrike.lotty.command.LotteryCommand;

/**
 * CommandAnnotationNotFound - This exception will be thrown when the command is not found
 *
 * @author Copystrike
 * @since 28/02/2021 @ 23:01
 */
public class CommandAnnotationNotFound extends RuntimeException {

    public CommandAnnotationNotFound(Class<? extends LotteryCommand> commandClass) {
        super("Command  " + commandClass.getCanonicalName() + " Does not have a command annotation.");
    }
}
