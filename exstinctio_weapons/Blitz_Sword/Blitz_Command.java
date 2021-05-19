package sephikill.exstinctio_weapons.Blitz_Sword;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Blitz_Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Lol only players only idiot");
            return true;
        }

        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("Sword_Revelation")) {
            player.getInventory().addItem(Blitz_Sword.Blitz_Sword);
        }


        return false;
    }
}
