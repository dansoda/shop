package kr.gganbucompany.shop.config;

import kr.gganbucompany.shop.utils.config.PluginConfiguration;
import org.bukkit.plugin.Plugin;

public class ShopConfig extends PluginConfiguration {
    protected ShopConfig(Plugin plugin) {
        super(plugin, "config.yml");
    }
}
