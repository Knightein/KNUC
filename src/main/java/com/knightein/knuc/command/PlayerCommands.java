package com.knightein.knuc.command;

import cloud.commandframework.annotations.*;
import com.knightein.knuc.KNUC;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerCommands {
    /**
     * @param sender The sender of the command
     * @param input  The player to view the ender chest of
     */
    @CommandDescription("Open the player's ender chest")
    @CommandMethod("ec [player]")
    @CommandPermission("knightein.ec")
    private void openEnderChest(Player sender,
                                @Argument("player") Player input) {
        Bukkit.getScheduler().runTask(KNUC.getInstance(), () -> {
            Player player = input;
            if (player == null) player = sender;
            sender.openInventory(player.getEnderChest());
        });
    }

    /**
     * @param sender The sender of the command
     * @param input The player to set the health of
     * @param health The amount of health to set
     */
    @CommandDescription("Set the player's health")
    @CommandMethod("sethealth [player] [health]")
    @CommandPermission("knightein.ec")
    private void setHealth(Player sender,
                           @Argument("player") Player input,
                           @Argument("health") int health) {
        Bukkit.getScheduler().runTask(KNUC.getInstance(), () -> {
            Player player = input;
            if (player == null) player = sender;
            player.setHealth(health);
            sender.sendMessage(MiniMessage.miniMessage().deserialize(
                    "<bold><light_purple>KNUC: <white>Set " + player.getName() + "'s health to " + health + "."));
        });
    }

    /**
     * @param sender The sender of the command
     * @param input The player to set the hunger of
     * @param hunger The amount of hunger to set
     */
    @CommandDescription("Set the player's hunger")
    @CommandMethod("sethunger [player] [hunger]")
    @CommandPermission("knightein.ec")
    private void setHunger(Player sender,
                           @Argument("player") Player input,
                           @Argument("hunger") int hunger) {
        Bukkit.getScheduler().runTask(KNUC.getInstance(), () -> {
            Player player = input;
            if (player == null) player = sender;
            player.setFoodLevel(hunger);
            sender.sendMessage(MiniMessage.miniMessage().deserialize(
                    "<bold><light_purple>KNUC: <white>Set " + player.getName() + "'s hunger to " + hunger + "."));
        });
    }

    /**
     * @param sender The sender of the command
     * @param input The player to set the hearts of
     * @param hearts The amount of hearts to set
     */
    @CommandDescription("Set the player's hearts")
    @CommandMethod("sethearts [player] [hearts]")
    @CommandPermission("knightein.ec")
    private void setHearts(Player sender,
                           @Argument("player") Player input,
                           @Argument("hearts") int hearts) {
        Bukkit.getScheduler().runTask(KNUC.getInstance(), () -> {
            Player player = input;
            if (player == null) player = sender;
            player.setHealthScale(hearts);
            sender.sendMessage(MiniMessage.miniMessage().deserialize(
                    "<bold><light_purple>KNUC: <white>Set " + player.getName() + "'s hearts to " + hearts + "."));
        });
    }
}
