package kr.gganbucompany.shop.commands;

import kr.gganbucompany.shop.api.Shop;
import kr.gganbucompany.shop.api.player.ShopPlayer;
import kr.gganbucompany.shop.service.ShopPlayerService;
import kr.gganbucompany.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class ShopAdminCommand implements CommandExecutor {

    private final ShopService shopService;
    private final ShopPlayerService shopPlayerService;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("/상점관리 목록");
            sender.sendMessage("/상점관리 생성 [이름]");
            sender.sendMessage("/상점관리 설정 [이름]");
            sender.sendMessage("/상점관리 열기 [이름]");
            sender.sendMessage("/상점관리 제거 [이름]");
        } else {
            Player player = (Player) sender;
            ShopPlayer shopPlayer = shopPlayerService.getShopPlayer(player);
            if (args[0].equals("목록")) {
                sender.sendMessage("상점 목록");
                shopService.getShops().forEach(shop -> {
                    sender.sendMessage(shop.getName());
                });
            } else if (args[0].equals("생성")) {
                if (args.length == 1) {
                    sender.sendMessage("이름을 적어주세요.");
                    return false;
                }
                String name = args[1];
                Shop shop = shopService.createShop(name);
                if (shop == null) {
                    sender.sendMessage("이미 생성 되어 있습니다.");
                } else {
                    sender.sendMessage("상점을 생성 하였습니다. " + name);
                }
            } else if (args[0].equals("설정")) {
                if (args.length == 1) {
                    sender.sendMessage("이름을 적어주세요.");
                    return false;
                }
                String name = args[1];
                Shop shop = shopService.getShop(name);
                if (shop == null) {
                    sender.sendMessage("생성 되어있지 않습니다.");
                    return false;
                }
                shopService.settingShop(shopPlayer, shop);
            } else if (args[0].equals("열기")) {
                if (args.length == 1) {
                    sender.sendMessage("이름을 적어주세요.");
                    return false;
                }
                String name = args[1];
                shopService.openShop(shopPlayer, name);
            }
        }
        return false;
    }
}
