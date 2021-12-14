package kr.gganbucompany.shop.api;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * 상점 구성 요소 입니다.
 */
public interface IShopComponent {

    /**
     * 상점 GUI 번호 입니다.
     * @return
     */
    int getSlot();

    @NotNull IShopItem getShopItem();

    void setShopItem(IShopItem shopItem);

    Set<ShopCost> getShopCosts();

    ShopMore getMore();

    boolean getMoreBuy();

    void setMoreBuy(boolean bool);

    boolean getMoreSell();

    void getMoreSell(boolean bool);

    ShopProvider getProvider();

}
