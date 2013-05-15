package me.nopresnik.plugins.cmod;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CMod extends JavaPlugin implements Listener {

    public CModListener listener = new CModListener(this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(listener, this);
    }
}
