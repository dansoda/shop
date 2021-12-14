package kr.gganbucompany.shop.utils.config;

import org.bukkit.plugin.Plugin;

public abstract class DataConfiguration<V> extends PluginConfiguration{
    protected DataConfiguration(Plugin plugin, String pathname) {
        super(plugin, pathname);
    }

    public abstract V getData();

    public abstract void setData(V data);
}
