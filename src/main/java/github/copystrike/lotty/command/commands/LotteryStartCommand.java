package github.copystrike.lotty.command.commands;

import github.copystrike.lotty.command.LotteryCommand;
import github.copystrike.lotty.command.annotations.SubCommand;
import github.copystrike.lotty.player.LotteryStats;
import github.copystrike.lotty.player.LotteryUser;

/**
 * LotteryStartCommand - This command will start the lottery.
 *
 * @author Copystrike
 * @since 01/03/2021 @ 01:39
 */

@SubCommand("start")
public class LotteryStartCommand extends LotteryCommand {

    @Override
    protected void execute(LotteryCommand lotteryCommand, LotteryUser lotteryUser) {

    }
}
