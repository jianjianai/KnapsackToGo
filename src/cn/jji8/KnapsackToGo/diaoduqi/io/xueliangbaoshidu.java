package cn.jji8.KnapsackToGo.diaoduqi.io;

import cn.jji8.KnapsackToGo.main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class xueliangbaoshidu implements io{//我负责血量饱食度
    @Override
    public void duqu(Player wanjia){//加载玩家血量饱食度
        long startTime = System.currentTimeMillis();
        File File = new File(main.peizi.工作路径 + "/血量饱食度/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        wanjia.setFoodLevel(wanjiawenjian.getInt("饥饿度"));
        wanjia.setSaturation((float)wanjiawenjian.getDouble("饱食度"));
        wanjia.setHealth(wanjiawenjian.getDouble("血量"));
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:血量饱食度加载用时间： "+(endTime-startTime)+"ns");
    }
    @Override
    public void xieru(Player wanjia){//保存玩家血量饱食度
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
}
