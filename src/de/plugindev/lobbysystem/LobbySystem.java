package de.plugindev.lobbysystem;

import de.plugindev.lobbysystem.commands.CommandspyCMD;
import de.plugindev.lobbysystem.commands.SetCMD;
import de.plugindev.lobbysystem.commands.SpawnCMD;
import de.plugindev.lobbysystem.listener.*;
import de.plugindev.lobbysystem.utils.PermissionManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbySystem extends JavaPlugin {

    public static String prefix = "§6LobbySystem §7| §r";

    @Override
    public void onEnable() {
        startupMessage();

        initListener();
        initCommands();

        PermissionManager.setupPermissions();
    }

    @Override
    public void onDisable() {

    }

    private void initListener() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EntityDamageListener(), this);
        pm.registerEvents(new FoodLevelChangeListener(), this);
        pm.registerEvents(new PlayerCommandPreProcessListener(), this);
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerQuitListener(), this);
    }

    private void initCommands() {
        getCommand("commandspy").setExecutor(new CommandspyCMD());
        getCommand("set").setExecutor(new SetCMD());
        getCommand("spawn").setExecutor(new SpawnCMD());
    }

    private void startupMessage() {
        Bukkit.getConsoleSender().sendMessage(" §7---------------------------------------------------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage("§7|                                                                                                   §7|");
        Bukkit.getConsoleSender().sendMessage("§7|                                        §aVersion:      " + getDescription().getVersion() + "                                          §7|");
        Bukkit.getConsoleSender().sendMessage("§7|                                         §aAuthor:   " + getDescription().getAuthors() + "                                     §7|");
        Bukkit.getConsoleSender().sendMessage("§7|                                                                                                   §7|");
        Bukkit.getConsoleSender().sendMessage("§7|                                                                                                   §7|");
        Bukkit.getConsoleSender().sendMessage("§7|  §6 -----               -------------      --------------      --------------     |      /          §7|");
        Bukkit.getConsoleSender().sendMessage("§7|  §6|     |             |             |    |              |    |              |    |     /           §7|");
        Bukkit.getConsoleSender().sendMessage("§7|  §6|     |             |             |    |              |    |              |    |    /            §7|");
        Bukkit.getConsoleSender().sendMessage("§7|  §6|     |             |             |    |              |    |              |    |   /             §7|");
        Bukkit.getConsoleSender().sendMessage("§7|  §6|     |             |             |    |              |    |              |    |  /              §7|");
        Bukkit.getConsoleSender().sendMessage("§7|  §6|     |             |             |    |--------------/    |--------------/    | /               §7|");
        Bukkit.getConsoleSender().sendMessage("§7|  §6|     |             |             |    |             /     |             /     |/                §7|");
        Bukkit.getConsoleSender().sendMessage("§7|  §6|     §6 --------     |             |    |            /      |            /      |                 §7|");
        Bukkit.getConsoleSender().sendMessage("§7|  §6|              §6|    |             |    |           /       |           /       |                 §7|");
        Bukkit.getConsoleSender().sendMessage("§7|  §6|              §6|    |             |    |          /        |          /        |                 §7|");
        Bukkit.getConsoleSender().sendMessage("§7|  §6 --------------      -------------      ---------/          ---------/         |                 §7|");
        Bukkit.getConsoleSender().sendMessage("§7|                                                                                 §bmade by PluginDEV §7|");
        Bukkit.getConsoleSender().sendMessage(" §7---------------------------------------------------------------------------------------------------");
    }

}
