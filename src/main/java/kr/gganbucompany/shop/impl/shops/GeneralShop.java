package kr.gganbucompany.shop.impl.shops;

import kr.gganbucompany.shop.api.ShopType;
import kr.gganbucompany.shop.api.player.ShopPlayer;

public class GeneralShop extends AbstractShop {

    public GeneralShop(String name) {
        super(name);
    }

    @Override
    public ShopType getType() {
        return ShopType.GENERAL;
    }

    @Override
    public void open(ShopPlayer shopPlayer) {

    }
}
