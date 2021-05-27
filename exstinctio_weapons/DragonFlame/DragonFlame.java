package sephikill.exstinctio_weapons.DragonFlame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import sephikill.exstinctio_weapons.Exstinctio_weapons;

import java.util.ArrayList;
import java.util.List;

public class DragonFlame extends JavaPlugin {
    public static ItemStack DragonFlame;

    // public static void FlameThrower() { createDragonFlame();}

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

        //Shaped Recipe
        NamespacedKey dragonkey1 = new NamespacedKey(Exstinctio_weapons.getPlugin(),"dragonkey1");
        ShapedRecipe DragonRecipe_SR = new ShapedRecipe(dragonkey1, DragonItem);
        DragonRecipe_SR.shape(
                " E ",// Dragon egg
                " H ",// Dragon head
                " R " // End Rod
                );
        DragonRecipe_SR.setIngredient('E',Material.DRAGON_EGG);
        DragonRecipe_SR.setIngredient('H',Material.DRAGON_HEAD);
        DragonRecipe_SR.setIngredient('R',Material.END_ROD);

        Bukkit.addRecipe(DragonRecipe_SR);

    }

}
