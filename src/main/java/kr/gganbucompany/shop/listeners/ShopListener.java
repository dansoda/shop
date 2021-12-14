package kr.gganbucompany.shop.listeners;

import kr.gganbucompany.shop.service.ShopPlayerService;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@RequiredArgsConstructor
public class ShopListener implements Listener {

    private final ShopPlayerService playerService;

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        playerService.unRegister(event.getPlayer());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        playerService.register(event.getPlayer());
    }

    @EventHandler
    public void onInteractToNPC(PlayerInteractAtEntityEvent event) {

    }

}
