package github.copystrike.lotty.utils.io.imp;

import github.copystrike.lotty.LotteryBase;
import github.copystrike.lotty.utils.io.YamlFile;

/**
 * MessageConfig -
 *
 * @author Copystrike
 * @since 01/03/2021 @ 01:34
 */
public class MessageConfig extends YamlFile {

    public MessageConfig(LotteryBase plugin) {
        super(plugin, "message");
    }

    public void getMessage() {

    }
}
