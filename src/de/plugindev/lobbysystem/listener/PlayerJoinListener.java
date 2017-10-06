package de.plugindev.lobbysystem.listener;

import de.plugindev.lobbysystem.LobbySystem;
import de.plugindev.lobbysystem.commands.SetCMD;
import de.plugindev.lobbysystem.utils.PermissionManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

public class PlayerJoinListener implements Listener {

    int players = 0;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        File file = new File("plugins//LobbySystem//PlayerData//PlayerData_Players//PlayerData_Name//" + p.getName() + ".yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        File file1 = new File("plugins//LobbySystem//PlayerData//PlayerData_Players//PlayerData_UUID//" + p.getUniqueId().toString() + ".yml");
        FileConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);

        File file2 = new File("plugins//LobbySystem//PlayerData//PlayerData_Players//players.yml");
        FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);

        e.setJoinMessage(null);

        if(!SetCMD.cfg.contains("LobbySystem.spawn")) {
            if(p.hasPermission(PermissionManager.cfg.getString("Permission.Admin"))) {
                p.sendMessage(LobbySystem.prefix + "§cDas Plugin ist noch nicht vollständig eingerichtet.\nDu musst noch den Spawn setzen.");
            }
        } else {
            Location loc = p.getLocation();
            loc.setX(SetCMD.cfg.getDouble("LobbySystem.spawn.X"));
            loc.setY(SetCMD.cfg.getDouble("LobbySystem.spawn.Y"));
            loc.setZ(SetCMD.cfg.getDouble("LobbySystem.spawn.Z"));
            loc.setYaw((float) SetCMD.cfg.getDouble("LobbySystem.spawn.Yaw"));
            loc.setPitch((float) SetCMD.cfg.getDouble("LobbySystem.spawn.Pitch"));
            p.teleport(loc);
        }

        if(!file.exists() && !file1.exists()) {
            players++;
            cfg2.set("players", players);
            Bukkit.broadcastMessage("§7[]§8----------------§a+§8----------------§7[]");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("§aHerzlich Willkommen auf §5MiniCube.ml");
            Bukkit.broadcastMessage("§6" + p.getName() + " §7ist neu. §7#§a" + cfg2.getInt("players"));
            Bukkit.broadcastMessage("§2Viel Spaß auf dem Server !");
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage("§7[]§8----------------§a+§8----------------§7[]");
            try {
                cfg2.save(file2);
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        cfg.set("PlayerName", p.getName());
        try {
            cfg.save(file);
        } catch (IOException ex) {
            ex.getMessage();
        }
        cfg1.set("UUID", p.getUniqueId().toString());
        try {
            cfg1.save(file1);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

}
