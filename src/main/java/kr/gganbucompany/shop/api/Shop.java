package kr.gganbucompany.shop.api;

import kr.gganbucompany.shop.api.player.ShopPlayer;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public interface Shop {

    String getName();

    ShopType getType();

    int getRaw();

    void setRaw(int raw);

    int getSize();

    Set<Integer> getComponentSlots();

    @Nullable IShopComponent getComponent(Integer slot);

    void setComponent(Integer slot, IShopComponent shopComponent);

    Set<ShopPlayer> getViewers();

    void open(ShopPlayer shopPlayer);

}
