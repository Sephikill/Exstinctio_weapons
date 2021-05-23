package sephikill.exstinctio_weapons.Armageddon;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
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


public class The_End implements Listener {

    @EventHandler
        public void abyss(PlayerInteractEvent event){
        // get useful item info in main hand
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer held_item_data = meta.getPersistentDataContainer();

        // player cords on hit and 4 vars to place tnt
        Location PositiveX = player.getLocation();
        Location NegativeX = player.getLocation();
        Location PositiveZ = player.getLocation();
        Location NegativeZ = player.getLocation();


        if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR ){
            if(event.getItem() != null){
                if(held_item_data.has(new NamespacedKey(Exstinctio_weapons.getPlugin(), "Revelation"), PersistentDataType.STRING)){
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL,10,10);
                    //Place 1 tnt left of player
                    player.getPlayer().getWorld().spawnEntity(PositiveX.add(1.0,0.0,0.0),EntityType.PRIMED_TNT);
                    //Place 1 tnt right of player
                    player.getPlayer().getWorld().spawnEntity(NegativeX.subtract(1.0,0.0,0.0),EntityType.PRIMED_TNT);
                    //Place 1 tnt forward of player
                    player.getPlayer().getWorld().spawnEntity(PositiveZ.add(0.0,0.0,1.0),EntityType.PRIMED_TNT);
                    //Place 1 tnt backward of player
                    player.getPlayer().getWorld().spawnEntity(NegativeZ.subtract(0.0,0.0,1.0),EntityType.PRIMED_TNT);
                }
            }
        }
    }
}

