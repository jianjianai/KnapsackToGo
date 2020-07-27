package cn.jji8.KnapsackToGo.diaoduqi.io;

import cn.jji8.KnapsackToGo.main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.io.File;
import java.io.IOException;

/*
* 我负责药水效果
* */
public class yaosui implements io{
    @Override
    public void duqu(Player wanjia) {
        File File = new File(main.peizi.工作路径 + "/药水效果/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        
    }

    @Override
    public void xieru(Player wanjia) {
        File File = new File(main.peizi.工作路径 + "/药水效果/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        PotionEffect[] biao = (PotionEffect[]) wanjia.getActivePotionEffects().toArray();
        for(int i = 0;i<biao.length;i++){
            wanjiawenjian.set(i+"",biao[1].serialize());
        }
        try {
            wanjiawenjian.save(File);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("[跨服背包同步]:药水效果保存失败,玩家血量饱食度未保存，请检查写入权限，或磁盘空间");
        }
    }
}
