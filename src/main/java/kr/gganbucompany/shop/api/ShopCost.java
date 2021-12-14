package kr.gganbucompany.shop.api;

import kr.gganbucompany.shop.api.player.ShopPlayer;

public interface ShopCost<T> {

    String getViewName();

    boolean hasCost(ShopPlayer shopPlayer);

    boolean hasCostMore(ShopPlayer shopPlayer, ShopMore more);

    boolean addCost(ShopPlayer shopPlayer);

    boolean removeCost(ShopPlayer shopPlayer);
}
