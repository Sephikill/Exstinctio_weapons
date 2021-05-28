package sephikill.exstinctio_weapons.Armageddon;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import sephikill.exstinctio_weapons.Exstinctio_weapons;

import java.util.ArrayList;
import java.util.List;

public class Final_Revelation extends JavaPlugin {

    public static ItemStack Final_Revelation;

    // public static void Final_Revolution(){ LastTimes(); }

    public static void LastTimes(){
        ItemStack Last_Item = new ItemStack(Material.BLAZE_POWDER, 1);
        ItemMeta Last_Meta = Last_Item.getItemMeta();

        PersistentDataContainer data = Last_Meta.getPersistentDataContainer();
        data.set(new NamespacedKey(Exstinctio_weapons.getPlugin(),"Revelation"), PersistentDataType.STRING,"Revelation");

        Last_Meta.setDisplayName("Final_Revelation");

        List<String> Last_Lore = new ArrayList<>();
        Last_Lore.add("The final times are coming");
        Last_Lore.add("Right Click to cause a massive of air strikes");
        Last_Meta.setLore(Last_Lore);

        Last_Meta.setUnbreakable(true);

        Last_Item.setItemMeta(Last_Meta);

        Final_Revelation = Last_Item;

        //Shaped Recipe
        NamespacedKey Final_RevelationSR = new NamespacedKey(Exstinctio_weapons.getPlugin(),"Final_RevelationSR");
        ShapedRecipe Last_Item_SR = new ShapedRecipe(Final_RevelationSR,Last_Item);
        Last_Item_SR.shape(
                "NEN",//Nether Star, end rod, Nether Star
                "EBE",//End rod, Beacon,End Rod
                "NEN" //Nether Star, end rod, Nether Star
        );
        Last_Item_SR.setIngredient('N',Material.NETHER_STAR);
        Last_Item_SR.setIngredient('E',Material.END_ROD);
        Last_Item_SR.setIngredient('B',Material.BEACON);

        Bukkit.getServer().addRecipe(Last_Item_SR);


        }

}
