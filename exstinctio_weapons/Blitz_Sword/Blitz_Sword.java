package sephikill.exstinctio_weapons.Blitz_Sword;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import sephikill.exstinctio_weapons.Exstinctio_weapons;


import java.util.ArrayList;
import java.util.List;


public class Blitz_Sword extends JavaPlugin {

    public static ItemStack Blitz_Sword;

    public static void sword_revolution() {
        createBlitz_Sword();
    }

    public static void createBlitz_Sword(){
        ItemStack Sword_Item = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta Sword_Meta = Sword_Item.getItemMeta();

        PersistentDataContainer data = Sword_Meta.getPersistentDataContainer();
        data.set(new NamespacedKey(Exstinctio_weapons.getPlugin(),"Blitz"), PersistentDataType.STRING,"Blitz");

        Sword_Meta.setDisplayName("Blitz_Sword");

        List<String> BlitzSword_lore = new ArrayList<>();
        BlitzSword_lore.add(ChatColor.GRAY + "The most legendary sword, its called Blitz_Sword");
        BlitzSword_lore.add(ChatColor.GRAY + "This sword does a heart of more damage");
        BlitzSword_lore.add(ChatColor.GRAY + "for every consecutive u do on a mob");
        BlitzSword_lore.add(ChatColor.GRAY + "without being hit. PS:");
        BlitzSword_lore.add(ChatColor.GRAY + "Not hitting a mob for 3 secs after hit remove effects");
        BlitzSword_lore.add(ChatColor.GRAY + "Ps left click to to 8 block in the direction ur facing");
        Sword_Meta.setLore(BlitzSword_lore);

        Sword_Meta.setUnbreakable(true);
        Sword_Meta.addEnchant(Enchantment.FIRE_ASPECT,2,true);
        Sword_Meta.addEnchant(Enchantment.DAMAGE_ALL,5,true);
        Sword_Meta.addEnchant(Enchantment.LOOT_BONUS_MOBS,3, true);




        Sword_Item.setItemMeta(Sword_Meta);

        Blitz_Sword = Sword_Item;
    }
}
/*
    to do
    fix bug when u attack u can tp anymore
    fix it so when u 2 or more times itreplace the atk value not attack it
 */