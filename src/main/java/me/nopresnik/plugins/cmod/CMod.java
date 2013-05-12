package me.nopresnik.plugins.cmod;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CMod extends JavaPlugin implements Listener {

    public PlayerPart pp = new PlayerPart(this);
    public PlayerItem pi = new PlayerItem(this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(pp, this);
        getServer().getPluginManager().registerEvents(pi, this);
    }
}
