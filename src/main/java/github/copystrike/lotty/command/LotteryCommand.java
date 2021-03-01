package github.copystrike.lotty.command;

import github.copystrike.lotty.player.LotteryUser;

/**
 * Command - Lottery command interface, this is the interface you will need to add commands.
 *
 * @author Copystrike
 * @since 28/02/2021 @ 22:49
 */
public interface LotteryCommand {

    void execute(LotteryCommand lotteryCommand, LotteryUser lotteryUser);

    default void registerSubcommand(LotteryCommand lotteryCommand) {

    }
}
