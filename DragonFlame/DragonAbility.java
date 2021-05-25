package sephikill.exstinctio_weapons.DragonFlame;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitTask;
import sephikill.exstinctio_weapons.Exstinctio_weapons;

import java.util.Set;

public class DragonAbility implements Listener {
    //right click ability
    @EventHandler
    public void FlameThrower(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer held_item_data = meta.getPersistentDataContainer();


        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (held_item_data.has(new NamespacedKey(Exstinctio_weapons.getPlugin(), "Flame"), PersistentDataType.STRING)) {
                    //Fireball
                    Fireball f = player.launchProjectile(Fireball.class);
                    f.setVelocity(player.getLocation().getDirection().multiply(2));
                    //Dragon_FireBall
                    DragonFireball d = player.launchProjectile(DragonFireball.class);
                    d.setVelocity(player.getLocation().getDirection().multiply(2));
                    //Small FireBall or blaze fireball
                    SmallFireball s = player.launchProjectile(SmallFireball.class);
                    s.setVelocity(player.getLocation().getDirection().multiply(2));
                }
            }
        }
    }
}