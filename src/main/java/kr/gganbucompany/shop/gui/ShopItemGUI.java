package kr.gganbucompany.shop.gui;

import kr.gganbucompany.shop.ShopLoader;
import kr.gganbucompany.shop.ShopPlugin;
import kr.gganbucompany.shop.api.IShopComponent;
import kr.gganbucompany.shop.api.Shop;
import kr.gganbucompany.shop.impl.ShopComponent;
import kr.gganbucompany.shop.impl.ShopFactory;
import kr.gganbucompany.shop.impl.ShopItem;
import kr.gganbucompany.shop.service.ShopService;
import kr.gganbucompany.shop.utils.gui.GUI;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopItemGUI extends GUI<Shop> {

    private final Shop shop;
    private final ShopService service;
    private final ShopFactory factory;

    public ShopItemGUI(Shop shop, ShopService service) {
        super(shop.getName(), shop.getRaw(), false, shop);
        this.service = service;
        this.factory = service.getFactory();
        this.shop = shop;
        init();
    }

    private void init() {
        shop.getComponentSlots().forEach(slot -> {
            IShopComponent component = shop.getComponent(slot);
            if (component != null) {
                getInventory().setItem(slot, component.getShopItem().getViewItem());
            }
        });
    }

    @Override
    protected void onPlayerClose(InventoryCloseEvent e) {
        Inventory inv = e.getInventory();
        for (int i = 0; i < inv.getSize(); i++) {
            IShopComponent component = shop.getComponent(i);
            ItemStack item = inv.getItem(i);
            if (item != null) {
                if (component == null) {
                    shop.setComponent(i, new ShopComponent(i, new ShopItem(item)));
                } else {
                    component.setShopItem(new ShopItem(item));
                }
            }
        }
    }
}
