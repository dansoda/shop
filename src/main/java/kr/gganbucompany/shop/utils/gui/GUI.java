package kr.gganbucompany.shop.utils.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public abstract class GUI<V> implements InventoryHolder {

    private static final Map<Player, GUI> viewers = new HashMap<>();

    private final Map<Integer, Consumer<InventoryClickEvent>> click = new HashMap<>();

    private String title = "";
    private InventoryType inventoryType = InventoryType.CHEST;
    private int row = 6;
    private boolean cancelled = false;

    protected @NotNull Inventory inv;
    private @Nullable Player player;

    protected @Nullable V data;

    protected GUI(String title, int row) {
        this(title, row, null);
    }

    protected GUI(String title, int row, V data) {
        this.title = title;
        this.row = row;
        this.data = data;
        buildInventory();
    }

    protected GUI(String title, int row, boolean cancelled, V data) {
        this(title, row, data);
        this.cancelled = cancelled;
    }

    protected GUI(String title, int row, boolean cancelled) {
        this(title, row, null);
        this.cancelled = cancelled;
    }

    protected GUI(String title, InventoryType inventoryType, boolean cancelled) {
        this.title = title;
        this.inventoryType = inventoryType;
        this.cancelled = cancelled;
    }

    public final void onClick(InventoryClickEvent e) {
        e.setCancelled(cancelled);
        onPlayerClick(e);
        action(e.getRawSlot(), e);
    }

    private void action(Integer slot, InventoryClickEvent e) {
        Consumer<InventoryClickEvent> consumer = click.get(slot);
        if (consumer != null) {
            consumer.accept(e);
        }
    }

    protected final void click(Integer slot, Consumer<InventoryClickEvent> click) {
        this.click.put(slot,click);
    }

    public final void onClose(InventoryCloseEvent e) {
        onPlayerClose(e);
        viewers.remove(player);
    }

    public final void onDrag(InventoryDragEvent e) { onPlayerDrag(e); }

    protected void onPlayerClick(InventoryClickEvent e) {}

    protected void onPlayerClose(InventoryCloseEvent e)  {}

    protected void onPlayerDrag(InventoryDragEvent e)  {}

    @Override
    public Inventory getInventory() {
        return inv;
    }

    private Inventory buildInventory() {
        if (inventoryType != InventoryType.CHEST) {
            inv = Bukkit.createInventory(this, inventoryType, title);
        } else {
            inv = Bukkit.createInventory(this, 9 * row, title);
        }
        return inv;
    }

    public void open(@NotNull Player player) {
        if (inv != null) {
            player.openInventory(inv);
            this.player = player;
            this.viewers.put(player,this);
        }
    }

    public void close(@NotNull Player player) {
        if (this.player != null)
            player.closeInventory();
    }

    public static void closeAllGUI() {
        viewers.forEach((player, gui) -> {
            player.closeInventory();
        });
    }

    public Player getPlayer() {
        if (player == null) {
            throw new IllegalStateException("player is null");
        }
        return player;
    }

}
