package kr.gganbucompany.shop.impl.costs;

import kr.gganbucompany.shop.api.ShopCost;
import kr.gganbucompany.shop.api.ShopMore;
import kr.gganbucompany.shop.api.player.ShopPlayer;
import org.bukkit.inventory.ItemStack;

public class MineCraftCost implements ShopCost<ItemStack> {

    private final ItemStack itemStack;

    public MineCraftCost(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    @Override
    public String getViewName() {
        return "가격";
    }

    @Override
    public boolean hasCost(ShopPlayer shopPlayer) {
        for (ItemStack item : shopPlayer.getPlayer().getInventory()) {
            if (item != null) {
                if (item.isSimilar(itemStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasCostMore(ShopPlayer shopPlayer, ShopMore more) {
        return false;
    }

    @Override
    public boolean addCost(ShopPlayer shopPlayer) {
        shopPlayer.getPlayer().getInventory().addItem(itemStack.clone());
        return true;
    }

    @Override
    public boolean removeCost(ShopPlayer shopPlayer) {
        return false;
    }
}
