package me.nopresnik.plugins.cmod;

import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    public final CMod plugin;

    PlayerChat(CMod instance) {
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
}
