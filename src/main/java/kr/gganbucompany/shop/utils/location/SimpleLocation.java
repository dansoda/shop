package kr.gganbucompany.shop.utils.location;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class SimpleLocation {
    private String worldName;

    @Getter
    private final Location location;

    public SimpleLocation(Location location) {
        this.location = location;
        worldName = location.getWorld().getName();
    }

    public SimpleLocation(String worldName, int x, int y, int z) {
        location = new Location(Bukkit.getWorld(worldName), x, y, z);
        this.worldName = worldName;
    }

    @Override
    public String toString() {
        return this.worldName + "," + location.getBlockX() + "," + location.getBlockY() + "," + location.getBlockZ();
    }

}