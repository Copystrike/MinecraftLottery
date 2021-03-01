package github.copystrike.lotty.command.commands;

import github.copystrike.lotty.command.LotteryCommand;
import github.copystrike.lotty.command.annotations.Endless;
import github.copystrike.lotty.command.annotations.Subcommand;
import github.copystrike.lotty.player.LotteryUser;

/**
 * LotteryStartCommand - This is a subcommand to {@link LotteryDefaultCommand},
 * The command will be able to start a lottery.
 *
 * @author Copystrike
 * @since 01/03/2021 @ 01:39
 */

@Subcommand("start")
@Endless
public class LotteryStartCommand extends LotteryCommand {

    @Override
    protected void execute(LotteryUser lotteryUser, String[] args) {
        lotteryUser.sendFormattedMessage("Hey start");
    }
}
