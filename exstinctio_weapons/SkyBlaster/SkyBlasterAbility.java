package sephikill.exstinctio_weapons.SkyBlaster;



import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import sephikill.exstinctio_weapons.Exstinctio_weapons;


import java.util.*;

public class SkyBlasterAbility implements Listener {

    @EventHandler
        public void AntiAir(PlayerInteractEvent event){
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer held_item_data = meta.getPersistentDataContainer();

            int CurrentForm = 0;


            // fomrs needed vars
            Map<String, Long> AntiAirSMG_Cooldown = new HashMap<String,Long>();
            Map<String, Long> AntiAirSniper_Cooldown = new HashMap<String,Long>();
            Map<String, Long> AntiAir_Artillery_Cooldown = new HashMap<String,Long>();
            Map<String, Long> AntiAir_RocketArtillery_Cooldown = new HashMap<String,Long>();
            Map<String, Long> AntiAir_Missile_Cooldown = new HashMap<String,Long>();

            if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR ){
                if(event.getItem() != null){
                    if(held_item_data.has(new NamespacedKey(Exstinctio_weapons.getPlugin(), "Sky"), PersistentDataType.STRING)){ // SOMETHING WRONG WITh THIS
                        //buff
                        player.sendMessage("test 0");
                        if(CurrentForm ==  5){
                            CurrentForm = 0;
                        } else {
                            //right click to swap abilities
                            CurrentForm++;
                        }


                        player.sendMessage("Test 1");

                        switch (CurrentForm){
                            case 0:

                                if(AntiAirSMG_Cooldown.containsKey(player.getName())){
                                    //player in hashmap
                                    if(AntiAirSMG_Cooldown.get(player.getName()) > System.currentTimeMillis()){
                                        // check if there time left in cooldown
                                        long timeleft = (AntiAirSMG_Cooldown.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                        player.sendMessage(ChatColor.DARK_RED + "lol u got" + timeleft + "Seconds Until AntiSmg is ready");
                                        return;
                                    }
                                }
                                player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 5,5);
                                SmallFireball S = player.launchProjectile(SmallFireball.class);
                                S.setVelocity(player.getLocation().getDirection().multiply(5));
                                AntiAirSMG_Cooldown.put(player.getName() , System.currentTimeMillis() + (1 * 500));
                                player.sendMessage("Test 2");
                                break;

                            case 1:

                                if(AntiAirSMG_Cooldown.containsKey(player.getName())){
                                    //player in hashmap
                                    if(AntiAirSniper_Cooldown.get(player.getName()) > System.currentTimeMillis()){
                                        // check if there time left in cooldown
                                        long timeleft = (AntiAirSniper_Cooldown.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                        player.sendMessage(ChatColor.DARK_RED + "lol u got" + timeleft + "Seconds Until AntiSmg is ready");
                                        return;
                                    }
                                }
                                player.playSound(player.getLocation(), Sound.ENTITY_ARROW_SHOOT, 5,5);
                                Arrow A = player.launchProjectile(Arrow.class);
                                A.setVelocity(player.getLocation().getDirection().multiply(4));
                                AntiAirSniper_Cooldown.put(player.getName() ,System.currentTimeMillis() + (1 * 1000));
                                player.sendMessage("Test 2");
                                break;

                            case 2:

                                if(AntiAir_Artillery_Cooldown.containsKey(player.getName())){
                                    //player in hashmap
                                    if(AntiAir_Artillery_Cooldown.get(player.getName()) > System.currentTimeMillis()){
                                        // check if there time left in cooldown
                                        long timeleft = (AntiAirSniper_Cooldown.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                        player.sendMessage(ChatColor.DARK_RED + "lol u got" + timeleft + "Seconds Until AntiSmg is ready");
                                        return;
                                    }
                                }
                                //ROCKETS
                                player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR, 5,5);
                                Firework FW = player.launchProjectile(Firework.class);
                                List<Color> c = new ArrayList<Color>();
                                c.add(Color.RED);
                                c.add(Color.BLACK);
                                c.add(Color.ORANGE);
                                FireworkEffect e = FireworkEffect.builder().flicker(true).withColor(c).withFade(c).with(FireworkEffect.Type.BALL_LARGE).trail(true).build();
                                FireworkMeta FM = FW.getFireworkMeta();
                                FM.addEffects(e);
                                FW.setFireworkMeta(FM);
                                FW.setVelocity(player.getLocation().getDirection().multiply(2));
                                AntiAir_Artillery_Cooldown.put(player.getName(), System.currentTimeMillis() + (3 * 1000));
                                player.sendMessage("Test 2");
                                break;

                            case 3:

                                if(AntiAir_RocketArtillery_Cooldown.containsKey(player.getName())){
                                    //player in hashmap
                                    if(AntiAir_RocketArtillery_Cooldown.get(player.getName()) > System.currentTimeMillis()){
                                        // check if there time left in cooldown
                                        long timeleft = (AntiAirSniper_Cooldown.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                        player.sendMessage(ChatColor.DARK_RED + "lol u got" + timeleft + "Seconds Until AntiSmg is ready");
                                        return;
                                    }
                                }
                                player.playSound(player.getLocation(), Sound.ITEM_FIRECHARGE_USE, 5,5);
                                Fireball F = player.launchProjectile(Fireball.class);
                                F.setVelocity(player.getLocation().getDirection().multiply(5));
                                AntiAir_RocketArtillery_Cooldown.put(player.getName(), System.currentTimeMillis() + (5 * 1000));
                                player.sendMessage("Test 2");
                                break;
                            case 4:

                                if(AntiAir_Missile_Cooldown.containsKey(player.getName())){
                                    //player in hashmap
                                    if(AntiAir_Missile_Cooldown.get(player.getName()) > System.currentTimeMillis()){
                                        // check if there time left in cooldown
                                        long timeleft = (AntiAirSniper_Cooldown.get(player.getName()) - System.currentTimeMillis()) / 1000;
                                        player.sendMessage(ChatColor.DARK_RED + "lol u got" + timeleft + "Seconds Until AntiSmg is ready");
                                        return;
                                    }
                                }
                                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_SHOOT, 5,5);
                                DragonFireball D = player.launchProjectile(DragonFireball.class);
                                D.setVelocity(player.getLocation().getDirection().multiply(6));
                                AntiAir_Missile_Cooldown.put(player.getName(), System.currentTimeMillis() + (10 * 1000));
                                player.sendMessage("Test 2");
                                break;
                            default:
                                player.sendMessage("Test 3");
                        }
                    player.sendMessage("Test 4");
                }
            }
        }
    }
}

