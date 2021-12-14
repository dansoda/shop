package kr.gganbucompany.shop.api.player;

import kr.gganbucompany.shop.api.Shop;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface ShopPlayer {

    UUID getUniqueId();

    Player getPlayer();

    Shop getViewShop();

    void setViewShop(Shop shop);

}
