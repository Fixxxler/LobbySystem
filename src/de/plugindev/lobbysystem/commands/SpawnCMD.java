package de.plugindev.lobbysystem.commands;

import de.plugindev.lobbysystem.LobbySystem;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(SetCMD.cfg.contains("LobbySystem.spawn")) {
                Location loc = p.getLocation();
                loc.setX(SetCMD.cfg.getDouble("LobbySystem.spawn.X"));
                loc.setY(SetCMD.cfg.getDouble("LobbySystem.spawn.Y"));
                loc.setZ(SetCMD.cfg.getDouble("LobbySystem.spawn.Z"));
                loc.setYaw((float) SetCMD.cfg.getDouble("LobbySystem.spawn.Yaw"));
                loc.setPitch((float) SetCMD.cfg.getDouble("LobbySystem.spawn.Pitch"));
                p.teleport(loc);
            } else {
                p.sendMessage(LobbySystem.prefix + "§cDer Spawn wurde noch nicht gesetzt. :(");
            }
        } else {
            commandSender.sendMessage("§cDu musst ein Spieler sein.");
        }
        return true;
    }
}
