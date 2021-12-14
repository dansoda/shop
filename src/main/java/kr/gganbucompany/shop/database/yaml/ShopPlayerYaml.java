package kr.gganbucompany.shop.database.yaml;

import kr.gganbucompany.shop.api.player.ShopPlayer;
import kr.gganbucompany.shop.utils.config.DataConfiguration;
import org.bukkit.plugin.Plugin;

public class ShopPlayerYaml extends DataConfiguration<ShopPlayer> {
    protected ShopPlayerYaml(Plugin plugin, String pathname) {
        super(plugin, pathname);
    }

    @Override
    public ShopPlayer getData() {
        return null;
    }

    @Override
    public void setData(ShopPlayer data) {

    }
}
