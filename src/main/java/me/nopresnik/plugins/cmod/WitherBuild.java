package me.nopresnik.plugins.cmod;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class WitherBuild implements Listener {

    CMod plugin;

    WitherBuild(CMod instance) {
        plugin = instance;
    }

    @EventHandler
    public void onWitherSpawn(CreatureSpawnEvent event) {
        if ((event.getEntityType() == EntityType.WITHER) && (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.BUILD_WITHER)) {
            event.setCancelled(true);
        }
    }
}
