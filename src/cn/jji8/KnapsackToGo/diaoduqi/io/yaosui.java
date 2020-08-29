package cn.jji8.KnapsackToGo.diaoduqi.io;

import cn.jji8.KnapsackToGo.main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
* 我负责药水效果
* */
public class yaosui implements io{
    @Override
    public void duqu(Player wanjia) {
        long startTime = System.currentTimeMillis();
        File File = new File(main.peizi.工作路径 + "/药水效果/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        List List = wanjiawenjian.getMapList("药水效果");
        BukkitRunnable BukkitRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                PotionEffectType[] T = org.bukkit.potion.PotionEffectType.values();
                for(int i=0;i<T.length;i++){
                    wanjia.removePotionEffect(T[i]);
                }
                for(int i = 0;i<List.size();i++){
                    wanjia.addPotionEffect(new PotionEffect((Map<String, Object>) List.get(i)));
                }
                long endTime = System.currentTimeMillis();
                if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:药水效果加载用时间： "+(endTime-startTime)+"ns");
            }
        };
        BukkitRunnable.runTask(main.main);
    }

    @Override
    public void xieru(Player wanjia) {
        long startTime = System.currentTimeMillis();
        File File = new File(main.peizi.工作路径 + "/药水效果/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        Iterator biao = wanjia.getActivePotionEffects().iterator();
        ArrayList ArrayList = new ArrayList();
        for(int i = 0;biao.hasNext();i++){
            ArrayList.add(((PotionEffect)biao.next()).serialize());
        }
        wanjiawenjian.set("药水效果",ArrayList);
        try {
            wanjiawenjian.save(File);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("[跨服背包同步]:药水效果保存失败,玩家血量饱食度未保存，请检查写入权限，或磁盘空间");
        }
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:药水效果保存用时间： "+(endTime-startTime)+"ns");
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
