package github.copystrike.lotty.command.exception;

import github.copystrike.lotty.command.LotteryCommand;
import github.copystrike.lotty.command.annotations.Endless;

import javax.management.RuntimeErrorException;

/**
 * MainCommandEndlessAnnotationException - This exception will be thrown if you try to register a subcommand to a command which has the {@link Endless} annotation.
 *
 * @author Copystrike
 * @since 01/03/2021 @ 15:30
 */
public class MainCommandEndlessAnnotationException extends RuntimeException {

    public MainCommandEndlessAnnotationException(Class<? extends LotteryCommand> mainCommand) {
        super("Class " + mainCommand.getCanonicalName() + " has an endless annotation, this will prevent the subcommands being executed and being completely useless.");
    }
}
