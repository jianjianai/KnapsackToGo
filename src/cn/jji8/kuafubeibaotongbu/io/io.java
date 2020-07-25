package cn.jji8.kuafubeibaotongbu.io;

import cn.jji8.kuafubeibaotongbu.main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.io.File;
import java.io.IOException;

public class io {//我专门负责读写操作
    public static void baocunxueliangbaoshidu(Player wanjia){//保存玩家血量饱食度
        long startTime = System.currentTimeMillis();
        File File = new File(main.peizi.工作路径 + "/血量饱食度/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        wanjiawenjian.set("饥饿度",wanjia.getFoodLevel());
        wanjiawenjian.set("饱食度",wanjia.getSaturation());
        wanjiawenjian.set("血量",wanjia.getHealth());
        try {
            wanjiawenjian.save(File);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("[跨服背包同步]:血量饱食度保存失败,玩家血量饱食度未保存，请检查写入权限，或磁盘空间");
        }
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:血量饱食度保存用时间： "+(endTime-startTime)+"ns");
    }
    public static void jiazaixueliangbaoshidu(Player wanjia){//加载玩家血量饱食度
        long startTime = System.currentTimeMillis();
        File File = new File(main.peizi.工作路径 + "/血量饱食度/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        wanjia.setFoodLevel(wanjiawenjian.getInt("饥饿度"));
        wanjia.setSaturation((float)wanjiawenjian.getDouble("饱食度"));
        wanjia.setHealth(wanjiawenjian.getDouble("血量"));
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:血量饱食度加载用时间： "+(endTime-startTime)+"ns");
    }
    public static void jiazaibeibao(Player wanjia){//用于加载玩家背包
        long startTime = System.currentTimeMillis();
        File File = new File(main.peizi.工作路径 + "/背包/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        PlayerInventory PlayerInventory = wanjia.getInventory();
        PlayerInventory.setBoots(wanjiawenjian.getItemStack("装备.鞋子"));
        PlayerInventory.setChestplate(wanjiawenjian.getItemStack("装备.胸甲"));
        PlayerInventory.setHelmet(wanjiawenjian.getItemStack("装备.头盔"));
        PlayerInventory.setLeggings(wanjiawenjian.getItemStack("装备.护腿"));
        PlayerInventory.setItemInOffHand(wanjiawenjian.getItemStack("副手"));
        for(int i=0;i<36;i++){
            PlayerInventory.setItem(i,wanjiawenjian.getItemStack("物品."+i));
        }
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:背包加载用时间： "+(endTime-startTime)+"ns");
    }
    public static void baocunbeobao(Player wanjia){//用于保存玩家背包
        long startTime = System.currentTimeMillis();
        File File = new File(main.peizi.工作路径 + "/背包/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        PlayerInventory PlayerInventory = wanjia.getInventory();
        wanjiawenjian.set("装备.鞋子",PlayerInventory.getBoots());//鞋子
        wanjiawenjian.set("装备.胸甲",PlayerInventory.getChestplate());//胸甲
        wanjiawenjian.set("装备.头盔",PlayerInventory.getHelmet());//头盔
        wanjiawenjian.set("装备.护腿",PlayerInventory.getLeggings());//护腿
        wanjiawenjian.set("副手",PlayerInventory.getItemInOffHand());
        for(int i=0;i<36;i++){
            wanjiawenjian.set("物品."+i,PlayerInventory.getItem(i));
        }
        try {
            wanjiawenjian.save(File);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("[跨服背包同步]:背包保存失败,玩家背包未保存，请检查写入权限，或磁盘空间");
        }
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:背包保存用时： "+(endTime-startTime)+"ns");
    }
    public static void jiashuo(String wanjia){
        File File = new File(main.peizi.工作路径 + "/锁/" + wanjia+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        wanjiawenjian.set("锁",true);
        try {
            wanjiawenjian.save(File);
        } catch (IOException e) {
            Bukkit.getLogger().warning("[跨服背包同步]:加锁失败，可能导致刷物品，请检查写入权限，或磁盘空间");
        }
    }
    public static void jieshuo(String wanjia){
        File File = new File(main.peizi.工作路径 + "/锁/" + wanjia+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        wanjiawenjian.set("锁",false);
        try {
            wanjiawenjian.save(File);
        } catch (IOException e) {
            Bukkit.getLogger().warning("[跨服背包同步]:解锁失败，可能导致玩家物品正常进入服务器，请检查写入权限，或磁盘空间");
        }
    }
    public static boolean ifshuo(String wanjia){
        File File = new File(main.peizi.工作路径 + "/锁/" + wanjia+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        return wanjiawenjian.getBoolean("锁");
    }
}
