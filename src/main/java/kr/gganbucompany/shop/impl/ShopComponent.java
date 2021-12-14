package kr.gganbucompany.shop.impl;

import kr.gganbucompany.shop.api.*;

import java.util.Set;

public class ShopComponent implements IShopComponent {

    private final int slot;
    private IShopItem shopItem;

    public ShopComponent(int slot, IShopItem shopItem) {
        this.slot = slot;
        this.shopItem = shopItem;
    }

    @Override
    public int getSlot() {
        return slot;
    }

    @Override
    public IShopItem getShopItem() {
        return shopItem;
    }

    @Override
    public void setShopItem(IShopItem shopItem) {
        this.shopItem = shopItem;
    }

    @Override
    public Set<ShopCost> getShopCosts() {
        return null;
    }

    @Override
    public ShopMore getMore() {
        return null;
    }

    @Override
    public boolean getMoreBuy() {
        return false;
    }

    @Override
    public void setMoreBuy(boolean bool) {

    }

    @Override
    public boolean getMoreSell() {
        return false;
    }

    @Override
    public void getMoreSell(boolean bool) {

    }

    @Override
    public ShopProvider getProvider() {
        return null;
    }
}
