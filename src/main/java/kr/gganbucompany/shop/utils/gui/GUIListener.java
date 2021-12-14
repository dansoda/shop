package kr.gganbucompany.shop.utils.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.InventoryHolder;

public class GUIListener implements Listener {

    GUIListener() {

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(!(e.getWhoClicked() instanceof Player) || e.getView().getTopInventory() == null)
            return;

        InventoryHolder inventoryHolder = e.getView().getTopInventory().getHolder();

        if (inventoryHolder instanceof GUI) {
            ((GUI) inventoryHolder).onClick(e);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        InventoryHolder inventoryHolder = e.getInventory() == null ? null : e.getInventory().getHolder();

        if(!(e.getPlayer() instanceof Player))
            return;

        if(inventoryHolder instanceof GUI) {
            ((Player) e.getPlayer()).updateInventory();
            ((GUI) inventoryHolder).onClose(e);
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        if(!(e.getWhoClicked() instanceof Player) || e.getView().getTopInventory() == null)
            return;

        InventoryHolder inventoryHolder = e.getView().getTopInventory().getHolder();

        if (inventoryHolder instanceof GUI) {
            ((GUI) inventoryHolder).onDrag(e);
        }
    }
}
