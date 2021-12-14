package kr.gganbucompany.shop.database.yaml;

import kr.gganbucompany.shop.api.Shop;
import kr.gganbucompany.shop.database.ShopDatabase;

import java.util.Set;

public final class ShopDatabaseYaml implements ShopDatabase {

    @Override
    public void save(Shop shop) {

    }

    @Override
    public Shop load(String name) {
        return null;
    }

    @Override
    public void saveShops() {

    }

    @Override
    public Set<Shop> loadShops() {
        return null;
    }
}
