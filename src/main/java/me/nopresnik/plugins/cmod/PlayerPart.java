package me.nopresnik.plugins.cmod;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerPart implements Listener {

    public final CMod plugin;

    PlayerPart(CMod instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.RED + "[PlayerJoin] " + ChatColor.DARK_GRAY + player.getName());
    }
}
