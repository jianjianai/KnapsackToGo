package cn.jji8.KnapsackToGo.diaoduqi.io;

import cn.jji8.KnapsackToGo.main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

import java.io.File;
import java.io.IOException;

/*
* 我负责玩家末影箱
* */
public class moyingxiang implements io {
    @Override
    public void duqu(Player wanjia) {
        long startTime = System.currentTimeMillis();
        File File = new File(main.peizi.工作路径 + "/末影箱/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        Inventory Inventory = wanjia.getEnderChest();
        for(int i=0;i<27;i++){
            Inventory.setItem(i,wanjiawenjian.getItemStack("物品."+i));
        }
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息) Bukkit.getLogger().info("[跨服背包同步]:末影箱加载用时间： "+(endTime-startTime)+"ns");
    }

    @Override
    public void xieru(Player wanjia) {
        long startTime = System.currentTimeMillis();
        File File = new File(main.peizi.工作路径 + "/末影箱/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        Inventory Inventory = wanjia.getEnderChest();
        for(int i=0;i<27;i++){
            wanjiawenjian.set("物品."+i,Inventory.getItem(i));
        }
        try {
            wanjiawenjian.save(File);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("[跨服背包同步]:末影箱保存失败,玩家背包未保存，请检查写入权限，或磁盘空间");
        }
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:末影箱保存用时： "+(endTime-startTime)+"ns");
    }
    /**
     * 自动保存
     * 自动保存时调用的保存方法
     *
     * @param wanjia
     */
    @Override
    public void zidongbaocun(Player wanjia) {
        xieru(wanjia);
    }

    /**
     * 非正常读取，玩家数据没有正常保存而是因为服务器崩溃退出游戏，使用自动保存的数据加载
     *
     * @param wanjia
     */
    @Override
    public void feizhengchangduqu(Player wanjia) {
        duqu(wanjia);
    }
}
