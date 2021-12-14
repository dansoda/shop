package kr.gganbucompany.shop.service;

import kr.gganbucompany.shop.api.player.ShopPlayer;
import kr.gganbucompany.shop.impl.ShopContainer;
import kr.gganbucompany.shop.impl.ShopUser;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ShopPlayerService {

    private final ShopContainer container;

    public ShopPlayerService(ShopContainer container) {
        this.container = container;
    }

    public @NotNull ShopPlayer register(Player player) {
        return container.getPlayers().computeIfAbsent(player.getUniqueId(), v-> new ShopUser(player));
    }

    public @Nullable ShopPlayer unRegister(Player player) {
        return container.getPlayers().remove(player.getUniqueId());
    }

    public @NotNull ShopPlayer getShopPlayer(Player player) {
        return container.getPlayers().get(player.getUniqueId());
    }


}
