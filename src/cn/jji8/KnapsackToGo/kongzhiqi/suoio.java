package cn.jji8.KnapsackToGo.kongzhiqi;

import cn.jji8.KnapsackToGo.main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
/*
* 我专门负责读写操作
* */
public class suoio {
    /**
     * 用于给玩家加锁，加锁后其他服务器不会读取
     * @param
     * */
    public static boolean jiashuo(String wanjia){
        File File = new File(main.peizi.工作路径 + "/锁/" + wanjia+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        boolean 正常 = wanjiawenjian.getBoolean("正常");
        wanjiawenjian.set("正常",false);
        wanjiawenjian.set("锁",true);
        try {
            wanjiawenjian.save(File);
        } catch (IOException e) {
            Bukkit.getLogger().warning("[跨服背包同步]:加锁失败，可能导致刷物品，请检查写入权限，或磁盘空间");
        }
        return 正常;
    }
    /**
     * 用于解锁
     * */
    public static void jieshuo(String wanjia){
        File File = new File(main.peizi.工作路径 + "/锁/" + wanjia+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        wanjiawenjian.set("正常",true);
        wanjiawenjian.set("锁",false);
        try {
            wanjiawenjian.save(File);
        } catch (IOException e) {
            Bukkit.getLogger().warning("[跨服背包同步]:解锁失败，可能导致玩家无法正常进入服务器，请检查写入权限，或磁盘空间");
        }
    }
    /**
     * 返回是否加锁
     * 被锁返回 true
     * */
    public static boolean ifshuo(String wanjia){
        File File = new File(main.peizi.工作路径 + "/锁/" + wanjia+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        return wanjiawenjian.getBoolean("锁");
    }
}
