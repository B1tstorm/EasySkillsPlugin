package de.onezerocoding.easyskills;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;


public final class EasySkills extends JavaPlugin {

    public FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "EasySkills runs");
        printLegend();
        setConfig();
        registerEvents();
        registerCommands();
    }

    private void printLegend() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.UNDERLINE + "Legend:");
        Bukkit.getConsoleSender().sendMessage("- " + ChatColor.DARK_GREEN + "Dark green: onEnable()");
        Bukkit.getConsoleSender().sendMessage("- " + ChatColor.DARK_RED + "Dark red: onDisable()");
        Bukkit.getConsoleSender().sendMessage("- " + ChatColor.DARK_PURPLE + "Dark purple: Dev notes");
        Bukkit.getConsoleSender().sendMessage("- " + ChatColor.YELLOW + "Yellow: Warning. Check it!");
        Bukkit.getConsoleSender().sendMessage("- " + ChatColor.RED + "RED: Error. Exception!");
        Bukkit.getConsoleSender().sendMessage("- " + ChatColor.LIGHT_PURPLE + "Light purple: Loaded from config");
    }

    private void setConfig() {
        config.addDefault("owner", "Smaragd");
        config.options().copyDefaults(true);
        this.saveConfig();
        Bukkit.getConsoleSender().sendMessage( "Owner of this server is " + ChatColor.LIGHT_PURPLE.toString() + config.get("owner"));
    }

    private void registerEvents() {
        //getServer().getPluginManager().registerEvents(new EventMyListener(), this);
        getServer().getPluginManager().registerEvents(new BlockDestroyedEvent(), this);
    }

    private void registerCommands() {
        //this.getCommand("myCommand").setExecutor(new CmdMyCommand());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "EasySkills stopped");
        this.saveDefaultConfig();
    }
}
