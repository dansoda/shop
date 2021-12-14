package kr.gganbucompany.shop.utils;

import org.bukkit.ChatColor;

public class StringUtils {

    public static String translateColors(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
