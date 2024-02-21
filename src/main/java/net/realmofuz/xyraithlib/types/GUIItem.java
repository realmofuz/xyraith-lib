package net.realmofuz.xyraithlib.types;

import net.realmofuz.xyraithlib.actions.GUIClickStorage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;

public class GUIItem extends Item {
    public GUIItem(Material material) {
        super(material);
    }

    public GUIItem(Material material, byte count) {
        super(material, count);
    }

    public GUIItem(ItemStack itemStack) {
        super(itemStack);
    }

    public void onClick(Runnable onClick) {
        var uuid = UUID.randomUUID();
        this.tag("reserved/onclick", PersistentDataType.STRING, uuid.toString());
        GUIClickStorage.runnableHashMap.put(uuid.toString(), onClick);
    }
}
