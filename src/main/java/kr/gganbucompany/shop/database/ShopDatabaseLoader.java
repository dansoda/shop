package kr.gganbucompany.shop.database;

import kr.gganbucompany.shop.database.yaml.ShopDatabaseYaml;
import kr.gganbucompany.shop.impl.ShopContainer;

public class ShopDatabaseLoader {

    private final ShopDatabase database = new ShopDatabaseYaml();
    private final ShopContainer container;

    public ShopDatabaseLoader(ShopContainer container) {
        this.container = container;
    }
}
