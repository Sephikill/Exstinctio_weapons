package sephikill.exstinctio_weapons.Blitz_Sword;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import sephikill.exstinctio_weapons.Exstinctio_weapons;

import java.util.Set;

public class Blitz_Teleport implements Listener {
    @EventHandler
    public void onRightClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer held_item_data = meta.getPersistentDataContainer();
        String name = meta.getDisplayName();
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR ){
            if(event.getItem() != null){
                if(held_item_data.has(new NamespacedKey(Exstinctio_weapons.getPlugin(), "Blitz"), PersistentDataType.STRING)){
                    Block block = player.getTargetBlock((Set<Material>) null, 8);
                    Location location = block.getLocation();
                    float pitch = player.getEyeLocation().getPitch();
                    float yaw = player.getEyeLocation().getYaw();
                    location.add(0,1,0);
                    location.setYaw(yaw);
                    location.setPitch(pitch);
                    player.teleport(location);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT,5,5);

                }
            }
        }
    }
}
