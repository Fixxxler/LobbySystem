package de.plugindev.lobbysystem.listener;

import de.plugindev.lobbysystem.LobbySystem;
import de.plugindev.lobbysystem.commands.CommandspyCMD;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

public class PlayerCommandPreProcessListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if(!(e.isCancelled())) {
            String msg = e.getMessage().split(" ")[0];
            HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
            if(topic == null) {
                p.sendMessage("§7[§4!§7] §cDer Befehl existiert nicht.");
                e.setCancelled(true);
            }
        }
        for(Player all : Bukkit.getOnlinePlayers()) {
            if(CommandspyCMD.spy.contains(all)) {
                p.sendMessage("§4§lCommandSpy §7| §5" + p.getName() + " §cbenutzte §6" + e.getMessage());
            }
        }
    }

}
