package sephikill.exstinctio_weapons;

import org.bukkit.plugin.java.JavaPlugin;
import sephikill.exstinctio_weapons.Armageddon.Final_Commandment;
import sephikill.exstinctio_weapons.Armageddon.Final_Revelation;
import sephikill.exstinctio_weapons.Armageddon.Jihad;
import sephikill.exstinctio_weapons.Armageddon.The_End;
import sephikill.exstinctio_weapons.Blitz_Sword.Blitz_Ability;
import sephikill.exstinctio_weapons.Blitz_Sword.Blitz_Teleport;
import sephikill.exstinctio_weapons.Blitz_Sword.Blitz_Command;
import sephikill.exstinctio_weapons.Blitz_Sword.Blitz_Sword;
import sephikill.exstinctio_weapons.DragonFlame.DragonAbility;
import sephikill.exstinctio_weapons.DragonFlame.DragonCommand;
import sephikill.exstinctio_weapons.DragonFlame.DragonFlame;
import sephikill.exstinctio_weapons.SkyBlaster.BlasterCommand;
import sephikill.exstinctio_weapons.SkyBlaster.SkyBlaster;
import sephikill.exstinctio_weapons.SkyBlaster.SkyBlasterAbility;


public final class Exstinctio_weapons extends JavaPlugin {


    private static Exstinctio_weapons plugin;

    @Override
    public void onEnable() {
        //plugin logic stuff
        plugin = this;
        // Plugin startup logic for Blitz Sword
        Blitz_Sword.createBlitz_Sword();
        getCommand("Sword_Revelation").setExecutor(new Blitz_Command());
        getServer().getPluginManager().registerEvents(new Blitz_Teleport(), this);
        getServer().getPluginManager().registerEvents(new Blitz_Ability(), this);


        //plugin startup for Armageddon
        Final_Revelation.LastTimes();
        getCommand("Final_Revelation").setExecutor(new Final_Commandment());
        getServer().getPluginManager().registerEvents(new The_End(),this);
        getServer().getPluginManager().registerEvents(new Jihad(),this);

        //plugin startup for DragonFlame
        DragonFlame.createDragonFlame();
        getCommand("Dragon_Flame").setExecutor(new DragonCommand());
        getServer().getPluginManager().registerEvents(new DragonAbility(),this);

        //plugin startup for SkyBlaster
        SkyBlaster.create_Skyblaster();
        getCommand("SkyBlaster").setExecutor((new BlasterCommand()));
        getServer().getPluginManager().registerEvents(new SkyBlasterAbility(),this);


    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Exstinctio_weapons getPlugin() {
        return plugin;
    }

}
