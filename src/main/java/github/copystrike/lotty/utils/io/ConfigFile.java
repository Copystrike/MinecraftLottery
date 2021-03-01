package github.copystrike.lotty.utils.io;


import github.copystrike.lotty.LotteryBase;
import org.bukkit.plugin.Plugin;

import java.io.File;

/**
 * CoreFile - A config base file.
 *
 * @author Copystrike
 * @since 06/02/2021 @ 21:58
 */
public abstract class ConfigFile  {

    private final LotteryBase plugin;
    private final File dataFolder;
    private final String name;
    private final String extension;
    protected File file;

    /**
     * Create new file
     *
     * @param plugin plugin that the file belongs to
     * @param name name of the file
     * @param extension file extension
     */
    public ConfigFile(LotteryBase plugin, String name, String extension) {
        this.plugin = plugin;
        this.dataFolder = plugin.getDataFolder();
        this.name = name;
        this.extension = extension;

        this.file = new File(dataFolder,name + extension);
    }

    /**
     * Get the plugin this file belongs to
     *
     * @return plugin
     */
    public LotteryBase getPlugin() { return this.plugin; }

    /**
     * Get the file
     *
     * @return file
     */
    public File getFile() { return file; }

    /**
     * Get the folder which contains the file
     *
     * @return folder
     */
    public File getDataFolder() { return dataFolder; }

    /**
     * Get the name of the file
     *
     * @return name
     */
    public String getName() { return name; }

    /**
     * Get the extension of the file
     *
     * @return file extension
     */
    public String getExtension() { return extension; }

    /**
     * Get the path of the file
     *
     * @return path
     */
    public String getPath() { return file.getPath(); }

    /**
     * Reload the file
     */
    public abstract void reload();

    /**
     * Create the physical file on the filesystem
     */
    public abstract void createFile();

}