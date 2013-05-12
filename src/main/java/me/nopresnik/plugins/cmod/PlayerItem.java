package me.nopresnik.plugins.cmod;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerItem implements Listener {

    public final CMod plugin;

    PlayerItem(CMod instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);
        player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GREEN + "You are not permitted to drop items.");
    }
    
    @EventHandler
    public void onItemSpawn(ItemSpawnEvent event) {
        event.setCancelled(true);
    }
}
