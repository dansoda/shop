package kr.gganbucompany.shop.utils.gui;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class GUIManager {
    private final Plugin plugin;
    private final PluginManager manager;

    public GUIManager(Plugin plugin) {
        this.plugin = plugin;
        this.manager = plugin.getServer().getPluginManager();
    }

    public void register() {
        manager.registerEvents(new GUIListener(), plugin);
    }
}
