package github.copystrike.lotty.command.exception;

import github.copystrike.lotty.command.LotteryCommand;
import github.copystrike.lotty.command.annotations.Command;

/**
 * CommandAnnotationNotFound - This exception will be thrown when the command is not found
 *
 * @author Copystrike
 * @since 28/02/2021 @ 23:01
 */
public class CommandAnnotationNotFound extends RuntimeException {

    public CommandAnnotationNotFound(LotteryCommand commandClass) {
        super("Command  (" + commandClass.getClass().getName() + ") Does not have a @Command annotation.");
    }
}
