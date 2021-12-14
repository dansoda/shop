package kr.gganbucompany.shop.impl;

import kr.gganbucompany.shop.api.Shop;
import kr.gganbucompany.shop.api.player.ShopPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShopContainer {

    private final Map<String, Shop> shops = new HashMap<>();
    private final Map<UUID, ShopPlayer> players = new HashMap<>();

    public Map<UUID, ShopPlayer> getPlayers() {
        return players;
    }

    public Map<String, Shop> getShops() {
        return shops;
    }
}
