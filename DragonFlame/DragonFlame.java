package sephikill.exstinctio_weapons.DragonFlame;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import sephikill.exstinctio_weapons.Exstinctio_weapons;

import java.util.ArrayList;
import java.util.List;

public class DragonFlame extends JavaPlugin {
    public static ItemStack DragonFlame;

    public static void FlameThrower() { }

    public static void createDragonFlame(){
        //useful stats
        ItemStack DragonItem = new ItemStack(Material.DRAGON_BREATH);
        ItemMeta DragonMeta = DragonItem.getItemMeta();
        PersistentDataContainer DragonData = DragonMeta.getPersistentDataContainer();
        DragonData.set(new NamespacedKey(Exstinctio_weapons.getPlugin(),"Flame"), PersistentDataType.STRING,"Flame");

        //Lore
        DragonMeta.setDisplayName("Dragon Flame");

        List<String> DragonLore = new ArrayList<>();
        DragonLore.add(ChatColor.DARK_RED + "Legend says it that this weapon hold the strength stronger than the Ender dragon fireball attack");
        DragonLore.add(ChatColor.DARK_RED + "Please take care of it with extreme caution");
        DragonLore.add(ChatColor.DARK_RED + "Right click to shoot destruction");
        DragonMeta.setLore(DragonLore);

        //items enchants
        DragonMeta.setUnbreakable(true);
        DragonMeta.addEnchant(Enchantment.FIRE_ASPECT,2,true);

        DragonItem.setItemMeta(DragonMeta);

        DragonFlame = DragonItem;
        
    }

}
