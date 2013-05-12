package me.nopresnik.plugins.cmod;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerPart implements Listener {

    public final CMod plugin;

    PlayerPart(CMod instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.RED + "[PlayerJoin] " + ChatColor.GRAY + player.getName());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.RED + "[PlayerQuit] " + ChatColor.GRAY + player.getName());
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        Player player = event.getPlayer();
        event.setLeaveMessage(ChatColor.RED + "[PlayerQuit] " + ChatColor.GRAY + player.getName());
    }
}
