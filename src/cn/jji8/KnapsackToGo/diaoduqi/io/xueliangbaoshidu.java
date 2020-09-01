package cn.jji8.KnapsackToGo.diaoduqi.io;

import cn.jji8.KnapsackToGo.main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
/*
* 我负责血量饱食度
* */
public class xueliangbaoshidu implements io{
    //加载玩家血量饱食度
    @Override
    public void duqu(Player wanjia){
        long startTime = System.currentTimeMillis();
        File File = new File(main.peizi.工作路径 + "/血量饱食度/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        if(wanjiawenjian.contains("饥饿度")){
            wanjia.setFoodLevel(wanjiawenjian.getInt("饥饿度"));
        }
        if(wanjiawenjian.contains("饱食度")){
            wanjia.setSaturation((float)wanjiawenjian.getDouble("饱食度"));
        }
        if(wanjiawenjian.contains("血量")){
            wanjia.setHealth(wanjiawenjian.getDouble("血量")<=0?1:wanjiawenjian.getDouble("血量"));
        }
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:血量饱食度加载用时间： "+(endTime-startTime)+"ns");
    }
    //保存玩家血量饱食度
    @Override
    public void xieru(Player wanjia){
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
