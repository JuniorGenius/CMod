package me.nopresnik.plugins.cmod;

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
        String m = event.getMessage();
        Player p = event.getPlayer();
        //Just for now
        event.setFormat("<" + p.getName() + "> " + m);
    }
}
