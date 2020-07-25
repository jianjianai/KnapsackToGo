package cn.jji8.KnapsackToGo.diaoduqi.io;

import cn.jji8.KnapsackToGo.main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.io.File;
import java.io.IOException;

public class beibao implements io{//我负责玩家背包
    @Override
    public void duqu(Player wanjia) {//加载玩家背包
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
        if(main.peizi.后台显示更多信息) Bukkit.getLogger().info("[跨服背包同步]:背包加载用时间： "+(endTime-startTime)+"ns");
    }
    @Override
    public void xieru(Player wanjia){//用于保存玩家背包
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
}
