package kr.gganbucompany.shop.service;

import kr.gganbucompany.shop.api.IShopComponent;
import kr.gganbucompany.shop.api.ShopCost;
import kr.gganbucompany.shop.api.player.ShopPlayer;

public class ShopHandler {

    public void sell(ShopPlayer player, IShopComponent component) {

    }

    public void sellMore(ShopPlayer player, IShopComponent component) {

    }

    public void buy(ShopPlayer player, IShopComponent component) {
        if (check(player, component, false)) {
            costRemove(player, component);
            component.getShopCosts().forEach(cost -> cost.addCost(player));
        }
    }

    public void buyMore(ShopPlayer player, IShopComponent component) {
        //TODO MORE 개수 설정 ENUM
        if (component.getMoreBuy()) {
            if (check(player, component, true)) {
                costRemove(player, component);
            }
        }
    }

    private void costRemove(ShopPlayer player, IShopComponent component) {
        component.getShopCosts().forEach(shopCost -> shopCost.removeCost(player));
    }

    private boolean check(ShopPlayer player, IShopComponent component, boolean more) {
        for (ShopCost shopCost : component.getShopCosts()) {
            if (more) {
                if (!shopCost.hasCost(player))
                    //TODO 부족한거 반환
                    return false;
            } else {
                if (!shopCost.hasCostMore(player, component.getMore()))
                    //TODO 부족한거 반환
                    return false;
            }
        }
        return true;
    }

}
