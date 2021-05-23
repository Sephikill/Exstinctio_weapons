package sephikill.exstinctio_weapons.Blitz_Sword;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import sephikill.exstinctio_weapons.Exstinctio_weapons;


import java.util.UUID;


public class Blitz_Ability implements Listener {
    // Blitz multiplier
    public int multiplier = 1;
    public int attackDamage = 11;
    public double attackSpeed = 1.60;

    @EventHandler
    public void Blitz(EntityDamageByEntityEvent e) {
        // modifier
        AttributeModifier AD = new AttributeModifier(UUID.randomUUID(),"generic.attackDamage",attackDamage ,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier AS = new AttributeModifier(UUID.randomUUID(),"generic.attackSpeed",attackSpeed ,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

        // Get the person
        Player whoHit = (Player) e.getDamager();


        // get item
        ItemStack held_item = whoHit.getInventory().getItemInMainHand();
        ItemMeta held_Item_meta = held_item.getItemMeta();
        PersistentDataContainer held_item_data = held_Item_meta.getPersistentDataContainer();

        /* new stats
        held_Item_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, AS);
        held_Item_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, AD);
        */

        if(held_item_data.has(new NamespacedKey(Exstinctio_weapons.getPlugin(), "Blitz"), PersistentDataType.STRING)){
            //remove current stats
            held_Item_meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,AD);
            held_Item_meta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, AS);
            held_item.setItemMeta(held_Item_meta);


            // make damage deadly
            multiplier++;


            // make item stronger
            switch(multiplier) {
                case 1:
                    //remove all current attribute
                    held_Item_meta.removeAttributeModifier(EquipmentSlot.HAND);
                    whoHit.playSound(whoHit.getLocation(), Sound.ITEM_TOTEM_USE ,50,5);
                    // make new attribute
                    held_Item_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,AD);
                    held_item.setItemMeta(held_Item_meta);
                    attackDamage++;

                    break;
                case 2:
                    //remove all current attribute
                    held_Item_meta.removeAttributeModifier(EquipmentSlot.HAND);
                    // make new attribute
                    held_Item_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,AD);
                    held_item.setItemMeta(held_Item_meta);

                    break;

                case 3:
                    //remove all current attribute
                    held_Item_meta.removeAttributeModifier(EquipmentSlot.HAND);
                    // make new attribute
                    held_Item_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,AD);
                    held_item.setItemMeta(held_Item_meta);
                    attackSpeed += 0.25;
                    attackDamage++;

                    break;

                case 4:
                    //remove all current attribute
                    held_Item_meta.removeAttributeModifier(EquipmentSlot.HAND);
                    // make new attribute
                    held_Item_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,AD);
                    held_Item_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, AS);
                    held_item.setItemMeta(held_Item_meta);
                    attackSpeed += 0.75;
                    attackDamage++;

                    break;

                case 5:
                    //remove all current attribute
                    held_Item_meta.removeAttributeModifier(EquipmentSlot.HAND);
                    // make new attribute
                    held_Item_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,AS);
                    held_Item_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,AD);
                    held_item.setItemMeta(held_Item_meta);
                    attackSpeed += 1.00;
                    attackDamage++;

                    break;

                case 6:
                    // remove current attribute
                    held_Item_meta.removeAttributeModifier(EquipmentSlot.HAND);
                    held_item.setItemMeta(held_Item_meta);
                    // make new attribute
                    multiplier = 1;
                    attackDamage = 11;
                    attackSpeed = 1.6;
                    held_Item_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,AS);
                    held_Item_meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,AD);
                    held_item.setItemMeta(held_Item_meta);
                    whoHit.sendMessage(ChatColor.RED +"THE EFFECT WEARS OFF");
                    break;

            }
        }
    }
}
