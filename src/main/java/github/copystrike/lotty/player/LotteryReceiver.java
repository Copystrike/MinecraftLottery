package github.copystrike.lotty.player;

/**
 * LotteryReceiver - This is focused on everything that can receive something.
 *
 * @author Copystrike
 * @since 01/03/2021 @ 04:15
 */
public interface LotteryReceiver {

    void sendFormattedMessage(String message);

    void sendMessage(String message);

}
