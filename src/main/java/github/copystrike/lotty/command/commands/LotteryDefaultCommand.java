package github.copystrike.lotty.command.commands;

import github.copystrike.lotty.command.LotteryCommand;
import github.copystrike.lotty.command.annotations.Command;
import github.copystrike.lotty.player.LotteryUser;

/**
 * LotteryCMD - The lottery main command, from here everything gets executed.
 *
 * @author Copystrike
 * @since 28/02/2021 @ 22:47
 */

@Command("lotty")
public class LotteryDefaultCommand extends LotteryCommand {

    @Override
    public void execute(LotteryUser lotteryUser, String[] args) {
        lotteryUser.sendMessage("Hey main");
        lotteryUser.sendFormattedMessage(String.valueOf(getSubcommands()));
    }
}
