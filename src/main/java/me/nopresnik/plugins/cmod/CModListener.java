package me.nopresnik.plugins.cmod;

import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class CModListener implements Listener {

    public final CMod plugin;

    CModListener(CMod instance) {
        plugin = instance;
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {

        Player player = event.getPlayer();
        String m = event.getMessage();
        String p = player.getName();

        Random object = new Random();
        int color;
        for (int counter = 1; counter <= 1; counter++) {
            color = 1 + object.nextInt(6);

            if (color == 1) {
                event.setFormat("<" + ChatColor.RED + p + ChatColor.RESET + "> " + m);
            }
            if (color == 2) {
                event.setFormat("<" + ChatColor.BLUE + p + ChatColor.RESET + "> " + m);
            }
            if (color == 3) {
                event.setFormat("<" + ChatColor.DARK_GREEN + p + ChatColor.RESET + "> " + m);
            }
            if (color == 4) {
                event.setFormat("<" + ChatColor.YELLOW + p + ChatColor.RESET + "> " + m);
            }
            if (color == 5) {
                event.setFormat("<" + ChatColor.AQUA + p + ChatColor.RESET + "> " + m);
            }
            if (color == 6) {
                event.setFormat("<" + ChatColor.GRAY + p + ChatColor.RESET + "> " + m);
            }
        }
    }

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent event) {
        event.setCancelled(true);
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

    @EventHandler
    public void onWitherSpawn(CreatureSpawnEvent event) {
        if ((event.getEntityType() == EntityType.WITHER) && (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.BUILD_WITHER)) {
            event.setCancelled(true);
        }
    }
}
