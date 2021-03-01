package github.copystrike.lotty.command.commands;

import github.copystrike.lotty.LotteryBase;
import github.copystrike.lotty.command.LotteryCommand;
import github.copystrike.lotty.command.annotations.Command;
import github.copystrike.lotty.player.LotteryUser;

/**
 * LotteryCMD - The lottery main command, from here everything gets executed.
 *
 * @author Copystrike
 * @since 28/02/2021 @ 22:47
 */

@Command("lottery")
public class LotteryDefaultCommand implements LotteryCommand {

    public LotteryDefaultCommand(LotteryBase lotteryBase) {
        super();
    }

    @Override
    public void execute(LotteryCommand lotteryCommand, LotteryUser lotteryUser) {

    }
}
