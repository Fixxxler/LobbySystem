package de.plugindev.lobbysystem.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class PermissionManager {

    public static File file = new File("plugins//LobbySystem//permissions.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void setupPermissions() {
        cfg.addDefault("Permission.Admin", "server.admin");
        cfg.addDefault("Permission.Command.Set", "command.set");
        cfg.addDefault("Permission.Command.Commandspy", "command.commandspy");
    }

}
