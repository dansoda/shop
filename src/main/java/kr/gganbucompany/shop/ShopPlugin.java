package kr.gganbucompany.shop;

import kr.gganbucompany.shop.commands.ShopAdminCommand;
import kr.gganbucompany.shop.impl.ShopContainer;
import kr.gganbucompany.shop.impl.ShopFactory;
import kr.gganbucompany.shop.listeners.ShopListener;
import kr.gganbucompany.shop.service.ShopHandler;
import kr.gganbucompany.shop.service.ShopPlayerService;
import kr.gganbucompany.shop.service.ShopService;
import kr.gganbucompany.shop.utils.gui.GUIManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ShopPlugin extends JavaPlugin {

    @Getter
    private static ShopPlugin instance;

    private ShopLoader shopLoader;

    @Override
    public void onEnable() {
        instance = this;
        new GUIManager(this).register();
        shopLoader = new ShopLoader();

        ShopContainer container = new ShopContainer();
        ShopHandler shopHandler = new ShopHandler();
        ShopFactory shopFactory = new ShopFactory();
        ShopService shopService = new ShopService(container, shopHandler, shopFactory);
        ShopPlayerService playerService = new ShopPlayerService(container);
        getCommand("상점관리").setExecutor(new ShopAdminCommand(shopService, playerService));
        getServer().getPluginManager().registerEvents(new ShopListener(playerService), this);
        Bukkit.getOnlinePlayers().forEach(player -> {
            playerService.register(player);
        });
        reload();
    }

    @Override
    public void onDisable() {

    }

    public void debug(String message) {
        this.getLogger().info(message);
    }

    public void reload() {
        shopLoader.load();
    }
}
