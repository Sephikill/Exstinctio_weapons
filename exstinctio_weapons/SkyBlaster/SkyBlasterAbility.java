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
    // fomrs needed vars
    Map<String, Long> AntiAirSMG_Cooldown = new HashMap<String,Long>();
    Map<String, Long> AntiAirSniper_Cooldown = new HashMap<String,Long>();
    Map<String, Long> AntiAir_Artillery_Cooldown = new HashMap<String,Long>();
    Map<String, Long> AntiAir_RocketArtillery_Cooldown = new HashMap<String,Long>();
    Map<String, Long> AntiAir_Missile_Cooldown = new HashMap<String,Long>();
    int CurrentForm = 0;

    @EventHandler
        public void AntiAir(PlayerInteractEvent event){
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer held_item_data = meta.getPersistentDataContainer();



            if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR ){
                if(event.getItem() != null){
                    if(held_item_data.has(new NamespacedKey(Exstinctio_weapons.getPlugin(), "Sky"), PersistentDataType.STRING)){

                        switch (CurrentForm){
                            case 0:

                                if(AntiAirSMG_Cooldown.containsKey(player.getName())){
                                    //player in hashmap
                                    if(AntiAirSMG_Cooldown.get(player.getName()) > System.currentTimeMillis()){
                                        // check if there time left in cooldown
                                        return;
                                    }
                                }
                                player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 5,5);
                                Arrow A = player.launchProjectile(Arrow.class);//add the velocity parameter
                                A.setVelocity(player.getLocation().getDirection().multiply(3));
                                AntiAirSMG_Cooldown.put(player.getName() , System.currentTimeMillis() + (200)); // .5 sec
                                break;

                            case 1:

                                if(AntiAirSniper_Cooldown.containsKey(player.getName())){
                                    //player in hashmap
                                    if(AntiAirSniper_Cooldown.get(player.getName()) > System.currentTimeMillis()){
                                        // check if there time left in cooldown
                                        return;
                                    }
                                }
                                player.playSound(player.getLocation(), Sound.ENTITY_ARROW_SHOOT, 5,5);
                                SmallFireball S = player.launchProjectile(SmallFireball.class);
                                S.setVelocity(player.getLocation().getDirection().multiply(1.25));
                                AntiAirSniper_Cooldown.put(player.getName() , System.currentTimeMillis() + (1000));// 1 sec
                                break;

                            case 2:

                                if(AntiAir_Artillery_Cooldown.containsKey(player.getName())){
                                    //player in hashmap
                                    if(AntiAir_Artillery_Cooldown.get(player.getName()) > System.currentTimeMillis()){
                                        // check if there time left in cooldown
                                        return;
                                    }
                                }
                                //ROCKETS
                                player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR, 5,5);
                                Firework FW = player.getWorld().spawn(player.getLocation(), Firework.class);

                                List<Color> c = new ArrayList<Color>();
                                c.add(Color.RED);
                                c.add(Color.BLACK);
                                c.add(Color.ORANGE);
                                c.add(Color.YELLOW);
                                FireworkEffect e = FireworkEffect.builder().flicker(true).withColor(c).withFade(c).with(FireworkEffect.Type.BALL_LARGE).trail(true).build();
                                FireworkMeta FM = FW.getFireworkMeta();
                                FM.addEffects(e);
                                FW.setFireworkMeta(FM);
                                FW.setVelocity(player.getLocation().getDirection().multiply(1.25));
                                AntiAir_Artillery_Cooldown.put(player.getName(), System.currentTimeMillis() + (2000)); // 2 sec
                                break;

                            case 3:

                                if(AntiAir_RocketArtillery_Cooldown.containsKey(player.getName())){
                                    //player in hashmap
                                    if(AntiAir_RocketArtillery_Cooldown.get(player.getName()) > System.currentTimeMillis()){
                                        // check if there time left in cooldown
                                        return;
                                    }
                                }
                                player.playSound(player.getLocation(), Sound.ITEM_FIRECHARGE_USE, 5,5);
                                DragonFireball D = player.launchProjectile(DragonFireball.class);
                                D.setVelocity(player.getLocation().getDirection().multiply(1.25));
                                AntiAir_RocketArtillery_Cooldown.put(player.getName(), System.currentTimeMillis() + (2500));//2.5 sec
                                break;
                            case 4:

                                if(AntiAir_Missile_Cooldown.containsKey(player.getName())){
                                    //player in hashmap
                                    if(AntiAir_Missile_Cooldown.get(player.getName()) > System.currentTimeMillis()){
                                        // check if there time left in cooldown
                                        return;
                                    }
                                }
                                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_SHOOT, 5,5);
                                Fireball F = player.launchProjectile(Fireball.class);
                                F.setVelocity(player.getLocation().getDirection().multiply(1));
                                AntiAir_Missile_Cooldown.put(player.getName(), System.currentTimeMillis() + (5000));// 5 sec
                                break;
                            default:
                                player.sendMessage("Doesnt have current form");
                        }
                }
            }
        }
            else if(event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR ){
                if(held_item_data.has(new NamespacedKey(Exstinctio_weapons.getPlugin(), "Sky"), PersistentDataType.STRING)){

                    CurrentForm++;


                    //reset
                    if(CurrentForm >= 5){
                        CurrentForm = 0;
                    }


                }
            }

    }
}

