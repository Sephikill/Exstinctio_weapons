package sephikill.exstinctio_weapons.SkyBlaster;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import sephikill.exstinctio_weapons.Exstinctio_weapons;

import java.util.ArrayList;
import java.util.List;

public class SkyBlaster extends JavaPlugin {

    public static ItemStack Blaster;

    public static void AntiAir_Mobilization(){create_Skyblaster();}

    public static void create_Skyblaster(){
        ItemStack Item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = Item.getItemMeta();

        PersistentDataContainer data = meta.getPersistentDataContainer();
        data.set(new NamespacedKey(Exstinctio_weapons.getPlugin(),"Sky"), PersistentDataType.STRING,"Sky");

        meta.setDisplayName("Sky Blaster");

        List<String> Lore = new ArrayList<>();
        Lore.add(ChatColor.DARK_RED + "A weapon that was accidentally brought from the future");
        Lore.add(ChatColor.DARK_RED + "The Sky Blaster is the best weapon for anti air uses");
        Lore.add(ChatColor.DARK_RED + "1st form shoots blaze small fireballs really fast, 2nd form shoots arrows");
        Lore.add(ChatColor.DARK_RED + "3 form shoots fireworks at medium speed and 4th form shoot fireballs slowly");
        meta.setLore(Lore);


        meta.setUnbreakable(true);

        Item.setItemMeta(meta);

        Blaster = Item;

    }
}
