package net.realmofuz.xyraithlib;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class Utils {
    public static Component deserialize(String string) {
        return MiniMessage.miniMessage().deserialize(string);
    }

}
