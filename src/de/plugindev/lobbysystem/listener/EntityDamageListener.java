package de.plugindev.lobbysystem.listener;

import de.plugindev.lobbysystem.commands.SetCMD;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
                Location loc = p.getLocation();
                loc.setX(SetCMD.cfg.getDouble("LobbySystem.spawn.X"));
                loc.setY(SetCMD.cfg.getDouble("LobbySystem.spawn.Y"));
                loc.setZ(SetCMD.cfg.getDouble("LobbySystem.spawn.Z"));
                loc.setYaw((float) SetCMD.cfg.getDouble("LobbySystem.spawn.Yaw"));
                loc.setPitch((float) SetCMD.cfg.getDouble("LobbySystem.spawn.Pitch"));
                p.teleport(loc);
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
    }
}
