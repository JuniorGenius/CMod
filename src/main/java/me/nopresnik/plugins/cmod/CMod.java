package me.nopresnik.plugins.cmod;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CMod extends JavaPlugin implements Listener {

    public PlayerPart pp = new PlayerPart(this);
    public PlayerItem pi = new PlayerItem(this);
    public PlayerChat pc = new PlayerChat(this);
    public WitherBuild wb = new WitherBuild(this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(pp, this);
        getServer().getPluginManager().registerEvents(pi, this);
        getServer().getPluginManager().registerEvents(pc, this);
        getServer().getPluginManager().registerEvents(wb, this);
    }
}
