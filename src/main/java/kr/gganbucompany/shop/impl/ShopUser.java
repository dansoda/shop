package kr.gganbucompany.shop.impl;

import kr.gganbucompany.shop.api.Shop;
import kr.gganbucompany.shop.api.player.ShopPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ShopUser implements ShopPlayer {

    private final Player player;
    private Shop viewShop;

    public ShopUser(Player player) {
        this.player = player;
    }

    @Override
    public UUID getUniqueId() {
        return player.getUniqueId();
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public Shop getViewShop() {
        return viewShop;
    }

    @Override
    public void setViewShop(Shop viewShop) {
        this.viewShop = viewShop;
    }
}
