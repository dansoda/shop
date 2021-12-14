package kr.gganbucompany.shop.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SimpleUtils {

    public static void send(CommandSender sender, String message) {
        sender.sendMessage(StringUtils.translateColors(message));
    }

    public static void opCommand(Player player, String command) {
        boolean bool = true;
        if (player.isOp()) {
            bool = false;
        }
        try {
            player.setOp(true);
            player.performCommand(command.replace("{player}", player.getName()));
        } finally {
            if (bool)
                player.setOp(false);
        }
    }

}
