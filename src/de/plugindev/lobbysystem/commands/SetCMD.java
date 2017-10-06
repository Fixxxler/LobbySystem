package de.plugindev.lobbysystem.commands;

import de.plugindev.lobbysystem.LobbySystem;
import de.plugindev.lobbysystem.utils.PermissionManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetCMD implements CommandExecutor {

    public static File file = new File("plugins//LobbySystem//Locations//locations.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(p.hasPermission(PermissionManager.cfg.getString("Permission.Command.Set"))) {
                if(strings.length == 1) {
                    String modus = strings[0].toLowerCase();
                    Location loc = p.getLocation();
                    cfg.set("LobbySystem." + modus + ".X", loc.getX());
                    cfg.set("LobbySystem." + modus + ".Y", loc.getY());
                    cfg.set("LobbySystem." + modus + ".Z", loc.getZ());
                    cfg.set("LobbySystem." + modus + ".Yaw", loc.getYaw());
                    cfg.set("LobbySystem." + modus + ".Pitch", loc.getPitch());
                    try {
                        cfg.save(file);
                        p.sendMessage(LobbySystem.prefix + "§aDu hast erfolgreich den Spawn §6" + modus.toUpperCase() + " §agesetzt.");
                    } catch (IOException ex) {
                        ex.getMessage();
                        p.sendMessage(LobbySystem.prefix + "§cEs ist ein Fehler aufgetreten. §7#§a7491");
                    }
                } else {
                    p.sendMessage(LobbySystem.prefix + "§cFalscher Syntax: /set <Spielmodus>");
                }
            } else {
                p.sendMessage("§7[§4!§7] §cDer Befehl existiert nicht.");
            }
        } else {
            commandSender.sendMessage("§cDu musst ein Spieler sein.");
        }
        return true;
    }
}
