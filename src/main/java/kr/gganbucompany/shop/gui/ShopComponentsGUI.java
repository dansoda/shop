package kr.gganbucompany.shop.gui;

import kr.gganbucompany.shop.api.Shop;
import kr.gganbucompany.shop.service.ShopService;
import kr.gganbucompany.shop.utils.gui.GUI;


public class ShopComponentsGUI extends GUI<Shop> {

    private final ShopService service;

    public ShopComponentsGUI(Shop shop, ShopService service) {
        super(shop.getName(), shop.getRaw(), true, shop);
        this.service = service;
    }
}
