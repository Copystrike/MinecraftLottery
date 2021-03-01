package github.copystrike.lotty.command.commands;

import github.copystrike.lotty.command.LotteryCommand;
import github.copystrike.lotty.command.annotations.Subcommand;
import github.copystrike.lotty.player.LotteryUser;

/**
 * LotterySetStats - Shows the stats of the player
 *
 * @author Copystrike
 * @since 01/03/2021 @ 01:56
 */
@Subcommand("stats")
public class LotterySetStats extends LotteryCommand {

    @Override
    protected void execute(LotteryUser lotteryUser, String[] args) {

    }
}
