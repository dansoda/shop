package kr.gganbucompany.shop.impl;

import kr.gganbucompany.shop.api.IShopItem;
import org.bukkit.inventory.ItemStack;

public class ShopItem implements IShopItem {

    private final ItemStack viewItem;

    public ShopItem(ItemStack viewItem) {
        this.viewItem = viewItem;
    }

    @Override
    public ItemStack getViewItem() {
        return viewItem;
    }

}
