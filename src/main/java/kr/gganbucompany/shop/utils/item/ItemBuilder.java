package kr.gganbucompany.shop.utils.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemBuilder {

    private final Material material;
    private MMaterial mmaterial;
    private int amount = 1;
    private byte data = 0;
    private short durability;

    private String displayName;
    private List<String> lore = new ArrayList<>();
    private List<ItemFlag> flags = new ArrayList<>();
    private Map<Enchantment, Integer> enchantments = new HashMap<>();
    private boolean unbreakable = false;
    private boolean glow;

    public ItemBuilder(@NotNull Material material) {
        this.material = material;
    }

    public ItemBuilder(@NotNull Material material, short durability) {
        this.material = material;
        this.durability = durability;
    }

    public ItemBuilder(@NotNull Material material, byte data) {
        this.material = material;
        this.data = data;
    }

    public ItemBuilder(ItemStack item) {
        this.material = item.getType();
        this.amount = item.getAmount();
        this.data = item.getData().getData();
        this.durability = item.getDurability();
        this.displayName = item.getItemMeta().getDisplayName();
        this.lore = new ArrayList<>(item.getItemMeta().hasLore() ? item.getItemMeta().getLore() : new ArrayList<>());
        this.flags = new ArrayList<>(!item.getItemMeta().getItemFlags().isEmpty() ? item.getItemMeta().getItemFlags() : new ArrayList<>());
        this.enchantments = new HashMap<>(item.getItemMeta().hasEnchants() ? item.getItemMeta().getEnchants() : new HashMap<>());
    }

    public ItemStack build() {
        ItemStack item = new ItemStack(material, amount, data);
        ItemMeta meta = item.getItemMeta();
        if (displayName != null) {
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',displayName));
        }
        if (!lore.isEmpty()) {
            meta.setLore(lore.stream().map(s -> ChatColor.translateAlternateColorCodes('&',s)).collect(Collectors.toList()));
        }
        if (glow) {
            enchantments.put(Enchantment.LUCK,1);
            flags.add(ItemFlag.HIDE_ENCHANTS);
        }
        meta.setUnbreakable(unbreakable);
        for (ItemFlag flag : flags) {
            meta.addItemFlags(flag);
        }
        enchantments.forEach((enchantment, integer) -> {
            meta.addEnchant(enchantment,integer,true);
        });
        item.setItemMeta(meta);
        return item;
    }

    /**
     * set itemStack amount.
     *
     * @param amount must be greater than 0
     */
    public ItemBuilder amount(final int amount) {
        this.amount = amount;
        return this;
    }

    public ItemBuilder durability(byte data) {
        this.data = data;
        return this;
    }

    public ItemBuilder durability(short durability) {
        this.durability = durability;
        return this;
    }

    public ItemBuilder displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public ItemBuilder addLore(String lore) {
        this.lore.add(lore);
        return this;
    }

    public ItemBuilder unbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
        return this;
    }

    public ItemBuilder unbreakableHide() {
        this.flags.add(ItemFlag.HIDE_UNBREAKABLE);
        this.flags.add(ItemFlag.HIDE_ATTRIBUTES);
        this.unbreakable = true;
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        this.enchantments.put(enchantment, level);
        return this;
    }

    public ItemBuilder addFlag(ItemFlag flag) {
        this.flags.add(flag);
        return this;
    }

}
