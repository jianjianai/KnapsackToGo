package cn.jji8.KnapsackToGo.diaoduqi.io;


import cn.jji8.KnapsackToGo.main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

/*
* 我负责经验
* */
public class jingyan implements io {

    @Override
    public void duqu(Player wanjia){
        long startTime = System.currentTimeMillis();
        File File = new File(main.peizi.工作路径 + "/经验/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        wanjia.setLevel(wanjiawenjian.getInt("等级"));
        wanjia.setExp(new BigDecimal(wanjiawenjian.getString("升级进度")).floatValue());
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息) Bukkit.getLogger().info("[跨服背包同步]:经验加载用时间： "+(endTime-startTime)+"ns");
    }

    @Override
    public void xieru(Player wanjia){
        long startTime = System.currentTimeMillis();
        File File = new File(main.peizi.工作路径 + "/经验/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        wanjiawenjian.set("等级",wanjia.getLevel());
        wanjiawenjian.set("升级进度",wanjia.getExp());
        try {
            wanjiawenjian.save(File);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("[跨服背包同步]:经验保存失败,玩家血量饱食度未保存，请检查写入权限，或磁盘空间");
        }
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息) Bukkit.getLogger().info("[跨服背包同步]:经验保存用时间： "+(endTime-startTime)+"ns");
    }
}
