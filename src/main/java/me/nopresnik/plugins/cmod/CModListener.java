package me.nopresnik.plugins.cmod;

import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class CModListener implements Listener {

    public final CMod plugin;

    CModListener(CMod instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {

        Player player = event.getPlayer();
        String message = event.getMessage();

        if (plugin.mutedUsers.contains(player.getName().toLowerCase())) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "You're not permitted to talk while muted.");
            plugin.log.info("Blocked Message: " + "<" + event.getPlayer().getName() + "> " + event.getMessage());
        }

        int upperCount = 0;
        for (int i = 0; i < message.length(); i++) {
            if (Character.isUpperCase(message.charAt(i))) {
                upperCount++;
            }
        }

        if ((upperCount > message.length() / 2) && message.length() > 8) {
            player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Please do not type in all caps.");
            event.setCancelled(true);
        }

        event.setFormat("<" + player.getDisplayName() + ChatColor.WHITE + "> " + message);
    }

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.RED + "[PlayerJoin] " + ChatColor.GRAY + player.getName());

        Random object = new Random();
        int color;
        for (int counter = 1; counter <= 1; counter++) {
            color = 1 + object.nextInt(6);

            if (color == 1) {
                player.setDisplayName(ChatColor.RED + player.getName());
                player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.RED + "red" + ChatColor.GRAY + "!");
            }
            if (color == 2) {
                player.setDisplayName(ChatColor.BLUE + player.getName());
                player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.BLUE + "blue" + ChatColor.GRAY + "!");
            }
            if (color == 3) {
                player.setDisplayName(ChatColor.DARK_GREEN + player.getName());
                player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.DARK_GREEN + "green" + ChatColor.GRAY + "!");
            }
            if (color == 4) {
                player.setDisplayName(ChatColor.YELLOW + player.getName());
                player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.YELLOW + "yellow" + ChatColor.GRAY + "!");
            }
            if (color == 5) {
                player.setDisplayName(ChatColor.AQUA + player.getName());
                player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.AQUA + "aqua" + ChatColor.GRAY + "!");
            }
            if (color == 6) {
                player.setDisplayName(ChatColor.GRAY + player.getName());
                player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now gray!");
            }
        }
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

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (plugin.frozenUsers.contains(player.getName().toLowerCase())) {
            event.setCancelled(true);
        }
    }
    /*@EventHandler
     public void playerInteract(PlayerInteractEvent event) {
     if (event.getPlayer().hasPermission("CMod.trusted")) {
     Block b = event.getClickedBlock();
     if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
     b.setType(Material.AIR);
     b.getRelative(BlockFace.NORTH).setType(Material.AIR);
     b.getRelative(BlockFace.NORTH_EAST).setType(Material.AIR);
     b.getRelative(BlockFace.NORTH_WEST).setType(Material.AIR);
     b.getRelative(BlockFace.SOUTH).setType(Material.AIR);
     b.getRelative(BlockFace.SOUTH_EAST).setType(Material.AIR);
     b.getRelative(BlockFace.SOUTH_WEST).setType(Material.AIR);
     b.getRelative(BlockFace.EAST).setType(Material.AIR);
     b.getRelative(BlockFace.WEST).setType(Material.AIR);;
     }
     }
     }*/
}
