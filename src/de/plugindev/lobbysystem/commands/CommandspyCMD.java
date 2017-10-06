package de.plugindev.lobbysystem.commands;

import de.plugindev.lobbysystem.LobbySystem;
import de.plugindev.lobbysystem.utils.PermissionManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandspyCMD implements CommandExecutor {

    public static ArrayList<Player> spy = new ArrayList<Player>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(p.hasPermission(PermissionManager.cfg.getString("Permission.Command.Commandspy"))) {
                if(spy.contains(p)) {
                    spy.remove(p);
                    p.sendMessage(LobbySystem.prefix + "§aCommandspy wurde §cdeaktiviert.");
                } else {
                    spy.add(p);
                    p.sendMessage(LobbySystem.prefix + "§aCommandspy wurde aktiviert.");
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
