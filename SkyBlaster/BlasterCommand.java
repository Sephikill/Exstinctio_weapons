package sephikill.exstinctio_weapons.SkyBlaster;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sephikill.exstinctio_weapons.Blitz_Sword.Blitz_Sword;

public class BlasterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Lol only players only idiot");
            return true;
        }

        Player player = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("SkyBlaster")) {
            player.getInventory().addItem(SkyBlaster.Blaster);
        }


        return false;
    }
}
