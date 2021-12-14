package kr.gganbucompany.shop.gui;

import kr.gganbucompany.shop.api.Shop;
import kr.gganbucompany.shop.api.player.ShopPlayer;
import kr.gganbucompany.shop.service.ShopService;
import kr.gganbucompany.shop.utils.gui.GUI;
import kr.gganbucompany.shop.utils.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;

public class ShopSettingGUI extends GUI<Shop> {

    private final Shop shop;
    private final ShopService service;

    public ShopSettingGUI(Shop shop, ShopService service) {
        super("상점 설정", 3, true, shop);
        this.shop = shop;
        this.service = service;
        init();
    }

    private void init() {
        Inventory inv = getInventory();
        setItem(inv);
        click(inv);
    }

    private void setItem(Inventory inv) {
        inv.setItem(4, new ItemBuilder(Material.NETHER_STAR)
                .displayName("§a§l[상점타입] §f" + data.getType().name())
                .addLore("")
                .addLore("")
                .build());
        inv.setItem(11, new ItemBuilder(Material.STRING)
                .displayName("§a§l[상점길이] §f" + data.getRaw())
                .addLore("")
                .addLore("  §fLEFT : §a+1 §7| §fRIGHT : §c-1")
                .addLore("  §fMIDDLE : 길이를 설정 합니다.   ")
                .addLore("")
                .build());
        inv.setItem(13, new ItemBuilder(Material.CHEST)
                .displayName("§a§l[상점] §f전시 아이템 설정")
                .build());
        inv.setItem(15, new ItemBuilder(Material.ENDER_CHEST)
                .displayName("§a§l[상점] §f아이템 설정")
                .build());
    }

    private void click(Inventory inv) {
        click(11, event -> {
            int raw = shop.getRaw();
            if (event.getClick() == ClickType.LEFT) {
                shop.setRaw(raw + 1);
            } else if (event.getClick() == ClickType.RIGHT) {
                shop.setRaw(raw - 1);
            } else if (event.getClick() == ClickType.SHIFT_LEFT) {
                if (raw < 3) {
                    shop.setRaw(3);
                } else if (raw < 6) {
                    shop.setRaw(6);
                }
            } else if (event.getClick() == ClickType.SHIFT_RIGHT) {
                if (raw > 1) {
                    shop.setRaw(1);
                }
            } else if (event.getClick() == ClickType.MIDDLE) {

            }
            //refresh();
        });
        click(13, event -> {
            new ShopItemGUI(shop, service).open(getPlayer());
        });
        click(15, event -> {
            new ShopItemGUI(shop, service).open(getPlayer());
        });
    }

}
