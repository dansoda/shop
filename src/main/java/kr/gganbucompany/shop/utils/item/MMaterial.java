package kr.gganbucompany.shop.utils.item;

import org.bukkit.Material;

public enum MMaterial {
    WHITE_WOOL(Material.WOOL,0),
    ORANGE_WOOL(Material.WOOL,1),
    MAGENTA_WOOL(Material.WOOL,2),
    LIGHT_BLUE_WOOL(Material.WOOL,3),
    YELLOW_WOOL(Material.WOOL,4),
    LIME_WOOL(Material.WOOL,5),
    PINK_WOOL(Material.WOOL,6),
    GRAY_WOOL(Material.WOOL,7),
    LIGHT_GRAY_WOOL(Material.WOOL,8),
    CYAN_WOOL(Material.WOOL,9),
    PURPLE_WOOL(Material.WOOL,10),
    BLUE_WOOL(Material.WOOL,11),
    BROWN_WOOL(Material.WOOL,12),
    GREEN_WOOL(Material.WOOL,13),
    RED_WOOL(Material.WOOL,14),
    BLACK_WOOL(Material.WOOL,15),

    WHITE_STAINED_GLASS(Material.STAINED_GLASS,0),

    WHITE_GLASS_PANE(Material.STAINED_GLASS_PANE,0),
    ORANGE_GLASS_PANE(Material.STAINED_GLASS_PANE,1),
    MAGENTA_GLASS_PANE(Material.STAINED_GLASS_PANE,2),
    LIGHT_BLUE_GLASS_PANE(Material.STAINED_GLASS_PANE,3),
    YELLOW_GLASS_PANE(Material.STAINED_GLASS_PANE,4),
    LIME_GLASS_PANE(Material.STAINED_GLASS_PANE,5),
    PINK_GLASS_PANE(Material.STAINED_GLASS_PANE,6),
    GRAY_GLASS_PANE(Material.STAINED_GLASS_PANE,7),
    LIGHT_GRAY_GLASS_PANE(Material.STAINED_GLASS_PANE,8),
    CYAN_GLASS_PANE(Material.STAINED_GLASS_PANE,9),
    PURPLE_GLASS_PANE(Material.STAINED_GLASS_PANE,10),
    BLUE_GLASS_PANE(Material.STAINED_GLASS_PANE,11),
    BROWN_GLASS_PANE(Material.STAINED_GLASS_PANE,12),
    GREEN_GLASS_PANE(Material.STAINED_GLASS_PANE,13),
    RED_GLASS_PANE(Material.STAINED_GLASS_PANE,14),
    BLACK_GLASS_PANE(Material.STAINED_GLASS_PANE,15);


    private final Material material;
    private final byte data;

    MMaterial(Material material, int data) {
        this.material = material;
        this.data = (byte) data;
    }

    public ItemBuilder getItemBuilder() {
        ItemBuilder itemBuilder = new ItemBuilder(material,data);
        return itemBuilder;
    }
}
