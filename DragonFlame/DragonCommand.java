package sephikill.exstinctio_weapons.DragonFlame;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DragonCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Lol only players only idiot");
            return true;
        }

        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("Dragon_Flame")) {
            player.getInventory().addItem(DragonFlame.DragonFlame);
        }

        return false;
    }
}
