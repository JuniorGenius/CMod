package me.nopresnik.plugins.cmod;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CMod extends JavaPlugin implements Listener {

    public PlayerJoin pj = new PlayerJoin(this);

    public void onEnable() {
        getServer().getPluginManager().registerEvents(pj, this);
    }
}
