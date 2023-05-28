package com.knightein.knuc.lib;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

/**
 * ComponentLib is a class that contains all the components used in the plugin.
 */
public class ComponentLib {
    public static Component ONLYPLAYER =
            MiniMessage.miniMessage().deserialize(
                    "<bold><light_purple>KNUC: <white>You must be a player to use this command.");
    public static Component INVALIDPLAYER =
            MiniMessage.miniMessage().deserialize(
                    "<bold><light_purple>KNUC: <white>Invalid Player.");
}
