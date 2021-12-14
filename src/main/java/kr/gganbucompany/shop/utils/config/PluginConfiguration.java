package kr.gganbucompany.shop.utils.config;

import lombok.Getter;
import lombok.experimental.Delegate;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public abstract class PluginConfiguration implements ConfigurationSection {
    @Delegate(types = ConfigurationSection.class)
    @Getter
    private final YamlConfiguration config = new YamlConfiguration();
    private final Plugin plugin;
    @Getter
    private final String name;
    @Getter
    private final String pathname;

    protected PluginConfiguration(Plugin plugin, String pathname) {
        this.plugin = plugin;
        this.pathname = pathname;
        this.name = FilenameUtils.getBaseName(pathname);
    }

    protected File createFile() {
        File file = new File(plugin.getDataFolder() + File.separator + pathname);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if(!file.exists()) {
            String resourcePath = pathname.replace('\\', '/');
            InputStream in = plugin.getResource(resourcePath);
            if (in != null) {
                plugin.saveResource(pathname, false);
            }
        }
        return file;
    }

    public final void loadConfig() {
        File file = createFile();
        try {
            config.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        onLoad();
    }

    public void onLoad() { }

    public final void saveConfig() {
        File file = createFile();
        onSave();
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onSave() { }

    public void saveAsync() {

    }
}
