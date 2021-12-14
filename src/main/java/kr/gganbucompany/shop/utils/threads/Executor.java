package kr.gganbucompany.shop.utils.threads;

import kr.gganbucompany.shop.ShopPlugin;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public class Executor {

    private static ShopPlugin plugin;
    private static boolean shutdown = false;

    private Executor() {
    }

    public static void init(ShopPlugin plugin) {
        Executor.plugin = plugin;
    }

    public static void ensureMain(Runnable runnable) {
        if (shutdown)
            return;

        if (!Bukkit.isPrimaryThread()) {
            sync(runnable);
        } else {
            runnable.run();
        }
    }

    public static BukkitTask sync(Runnable runnable) {
        if (shutdown)
            return null;

        return sync(runnable, 0);
    }

    public static BukkitTask sync(Runnable runnable, long delay) {
        if (shutdown)
            return null;

        return Bukkit.getScheduler().runTaskLater(plugin, runnable, delay);
    }

    public static void async(Runnable runnable) {
        if (shutdown)
            return;

        Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable);
    }

    public static void async(Runnable runnable, long delay) {
        if (shutdown)
            return;

        Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, runnable, delay);
    }

    public static void asyncTimer(Runnable runnable, long delay) {
        if (shutdown)
            return;

        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, runnable, delay, delay);
    }

    public static void timer(Runnable runnable, long delay) {
        if (shutdown)
            return;

        Bukkit.getScheduler().runTaskTimer(plugin, runnable, delay, delay);
    }


}
