package de.onezerocoding.easyskills;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


public class BlockDestroyedEvent implements Listener {

    @EventHandler
    public void onBlockDestroyed(BlockBreakEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.YELLOW + player.getName() + " +10exp");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + player.getName() + " +10exp for " + event.getBlock().getType());
    }

}
