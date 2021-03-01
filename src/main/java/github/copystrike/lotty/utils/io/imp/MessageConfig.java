package github.copystrike.lotty.utils.io.imp;

import github.copystrike.lotty.LotteryBase;
import github.copystrike.lotty.utils.io.YamlFile;

/**
 * MessageConfig - Message.yml config file.
 *
 * @author Copystrike
 * @since 01/03/2021 @ 01:34
 */
public class MessageConfig extends YamlFile {

    public MessageConfig(LotteryBase plugin) {
        super(plugin, "message");
    }

    public String getPrefix() {
        return getMessage("prefix");
    }

    public String getMessage(String message) {
        return getConfiguration().getString("message." + message);
    }
}
