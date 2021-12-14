package kr.gganbucompany.shop.database.yaml;

import kr.gganbucompany.shop.api.Shop;
import kr.gganbucompany.shop.utils.config.DataConfiguration;
import org.bukkit.plugin.Plugin;

public class ShopYaml extends DataConfiguration<Shop> {
    protected ShopYaml(Plugin plugin, String pathname) {
        super(plugin, pathname);
    }

    @Override
    public Shop getData() {
        return null;
    }

    @Override
    public void setData(Shop data) {

    }
}
