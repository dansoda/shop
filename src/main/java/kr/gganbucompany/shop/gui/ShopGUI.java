package kr.gganbucompany.shop.gui;

import kr.gganbucompany.shop.api.IShopComponent;
import kr.gganbucompany.shop.api.IShopItem;
import kr.gganbucompany.shop.api.Shop;
import kr.gganbucompany.shop.service.ShopHandler;
import kr.gganbucompany.shop.service.ShopPlayerService;
import kr.gganbucompany.shop.utils.gui.GUI;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopGUI extends GUI<Shop> {

    private final Shop shop;
    private final ShopPlayerService playerService;
    private final ShopHandler handler;

    public ShopGUI(Shop shop, ShopPlayerService playerService, ShopHandler handler) {
        super(shop.getName(), shop.getRaw(), shop);
        this.shop = shop;
        this.playerService = playerService;
        this.handler = handler;
        init();
    }

    private void init() {
        Inventory inv = getInventory();
        shop.getComponentSlots().forEach(
                slot -> {

                    IShopComponent component = shop.getComponent(slot);
                    IShopItem shopItem = component.getShopItem();
                    ItemStack viewItem = shopItem.getViewItem().clone();
                    component.getShopCosts().forEach(cost-> {
                        cost.getViewName();
                    });
                    //TODO 로어
                    
                    inv.setItem(slot, viewItem);

                    click(slot, event -> {
                        ClickType click = event.getClick();
                        if (click == ClickType.LEFT) {
                            handler.buy(playerService.getShopPlayer(getPlayer()), component);
                        } else if (click == ClickType.SHIFT_LEFT) {
                            handler.buyMore(playerService.getShopPlayer(getPlayer()), component);
                        }
                    });
                }
        );
    }
}
