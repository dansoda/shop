package kr.gganbucompany.shop.service;

import kr.gganbucompany.shop.api.Shop;
import kr.gganbucompany.shop.api.player.ShopPlayer;
import kr.gganbucompany.shop.gui.ShopSettingGUI;
import kr.gganbucompany.shop.impl.ShopContainer;
import kr.gganbucompany.shop.impl.ShopFactory;
import kr.gganbucompany.shop.impl.shops.GeneralShop;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class ShopService {

    private final ShopContainer container;
    @Getter
    private final ShopHandler handler;
    @Getter
    private final ShopFactory factory;

    public ShopService(ShopContainer container, ShopHandler handler, ShopFactory factory) {
        this.container = container;
        this.handler = handler;
        this.factory = factory;
    }

    public Collection<Shop> getShops() {
        return container.getShops().values();
    }

    public @Nullable Shop getShop(String name) {
        return container.getShops().get(name);
    }

    public void openShop(ShopPlayer player, String name) {
        Shop shop = getShop(name);
        shop.open(player);
    }

    /**
     * 기본 상점을 생성 합니다.
     * @param name 상점 이름
     * @return 상점을 성공적으로 생성시 Shop 객체 반환
     */
    public @Nullable Shop createShop(String name) {
        Shop shop = new GeneralShop(name);
        if (getShop(name) == null) {
            container.getShops().put(name, shop);
            return shop;
        }
        return null;
    }

    public void settingShop(@NotNull ShopPlayer shopPlayer, @NotNull Shop shop) {
        new ShopSettingGUI(shop, this).open(shopPlayer.getPlayer());
    }

}
