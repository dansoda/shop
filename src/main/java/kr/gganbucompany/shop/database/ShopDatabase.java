package kr.gganbucompany.shop.database;

import kr.gganbucompany.shop.api.Shop;

import java.util.Set;

public interface ShopDatabase {

    void save(Shop shop);

    Shop load(String name);

    void saveShops();

    Set<Shop> loadShops();

}
