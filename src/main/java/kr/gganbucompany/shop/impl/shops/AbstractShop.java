package kr.gganbucompany.shop.impl.shops;

import kr.gganbucompany.shop.api.Shop;
import kr.gganbucompany.shop.api.IShopComponent;
import kr.gganbucompany.shop.api.player.ShopPlayer;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public abstract class AbstractShop implements Shop {

    private final String name;
    private int raw;
    private int size;

    private final Set<ShopPlayer> viewers = new HashSet<>();
    private final Map<Integer, IShopComponent> components = new HashMap<>();

    protected AbstractShop(String name) {
        this.name = name;
        this.raw = 3;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRaw() {
        return raw;
    }

    @Override
    public void setRaw(int raw) {
        if (raw < 1) {
            return;
        }
        this.raw = raw;
        this.size = raw * 9;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Set<Integer> getComponentSlots() {
        return components.keySet();
    }

    @Override
    public @Nullable IShopComponent getComponent(Integer slot) {
        return components.get(slot);
    }

    @Override
    public void setComponent(Integer slot, IShopComponent shopComponent) {
        components.put(slot, shopComponent);
    }

    @Override
    public Set<ShopPlayer> getViewers() {
        return viewers;
    }
}
