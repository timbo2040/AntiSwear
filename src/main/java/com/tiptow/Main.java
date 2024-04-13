package com.tiptow;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveConfig();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        System.out.println(ChatColor.AQUA + "AntiSwear Enabled!");

    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        for (String word : e.getMessage().split(" ")) {
            if (getConfig().getStringList("BannedWords").contains(word)) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.DARK_RED + "This Message Has Been" + ChatColor.RED + "[Blocked]");
            }
        }
    }

}
