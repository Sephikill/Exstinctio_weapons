package sephikill.exstinctio_weapons.Armageddon;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import sephikill.exstinctio_weapons.Exstinctio_weapons;


public class Jihad implements Listener {
    @EventHandler
        public void Jihad_BLast(EntityDamageByEntityEvent e) {
        // why? give who hit regen and absorption & got hit weakness,blindness and slowness
        // get hit and got hit
        Player whoHit = (Player) e.getDamager();
        LivingEntity gotHit = (LivingEntity) e.getEntity();

        // get item
        ItemStack held_item = whoHit.getInventory().getItemInMainHand();
        ItemMeta held_Item_meta = held_item.getItemMeta();
        PersistentDataContainer held_item_data = held_Item_meta.getPersistentDataContainer();

        if (held_item_data.has(new NamespacedKey(Exstinctio_weapons.getPlugin(), "Revelation"), PersistentDataType.STRING)) {
            //buff for who hit
            whoHit.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));
            whoHit.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 200, 1));
            //debuff one that got hit
            gotHit.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100,1));
            gotHit.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100,1));
            gotHit.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100,1));
        }
    }
}
