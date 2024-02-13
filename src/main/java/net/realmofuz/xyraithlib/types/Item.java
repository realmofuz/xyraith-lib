package net.realmofuz.xyraithlib.types;

import com.mojang.datafixers.types.templates.Tag;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.minecraft.nbt.CompoundTag;
import net.realmofuz.xyraithlib.Utils;
import net.realmofuz.xyraithlib.XyraithLib;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftItem;
import org.bukkit.craftbukkit.v1_20_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Item {
    Material material;
    Component name = null;
    List<Component> lore = new ArrayList<>();
    PersistentDataContainer persistentDataContainer;
    byte count;

    public ItemStack toBukkitItemStack() {
        var i = new ItemStack(material);
        var meta = i.getItemMeta();
        assert meta != null;
        meta.lore(lore);
        if (name != null) {
            meta.displayName(name);
        }
        persistentDataContainer.copyTo(meta.getPersistentDataContainer(), true);
        i.setItemMeta(meta);
        i.setAmount(count);
        System.out.println(i.serialize());
        return i;
    }

    public Item(Material material) {
        this.count = 1;
        this.material = material;
    }

    public Item(Material material, byte count) {
        this.count = count;
        this.material = material;
    }

    public Item(ItemStack itemStack) {
        this.name = itemStack.displayName();
        this.count = Integer.valueOf(itemStack.getAmount()).byteValue();
        this.lore = itemStack.lore();
        this.material = itemStack.getType();
        this.persistentDataContainer = itemStack.getItemMeta().getPersistentDataContainer();
    }

    public Item name(String name) {
        this.name = Utils.deserialize("<!italic>" + name);
        return this;
    }

    public Item addLoreLine(String line) {
        this.lore.add(Utils.deserialize("<!italic>" + line));
        return this;
    }

    public Item setLoreLine(String line, int index) {
        this.lore.add(Utils.deserialize("<!italic>" + line));
        return this;
    }

    public String getLoreLine(int index) {
        return MiniMessage.miniMessage().serialize(lore.get(index));
    }

    public<P, C> Item tag(String key, PersistentDataType<P, C> type, C value) {
        this.persistentDataContainer.set(new NamespacedKey(XyraithLib.instance, key), type, value);
        return this;
    }

    public<P, C> C getTag(String key, PersistentDataType<P, C> type) {
        return this.persistentDataContainer.get(new NamespacedKey(XyraithLib.instance, key), type);
    }

    public Item clearLore() {
        this.lore = new ArrayList<>();
        return this;
    }
}
