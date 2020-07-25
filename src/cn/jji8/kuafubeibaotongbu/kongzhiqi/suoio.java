package cn.jji8.kuafubeibaotongbu.kongzhiqi;

import cn.jji8.kuafubeibaotongbu.main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.io.File;
import java.io.IOException;

public class suoio {//我专门负责读写操作
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
            Bukkit.getLogger().warning("[跨服背包同步]:解锁失败，可能导致玩家无法正常进入服务器，请检查写入权限，或磁盘空间");
        }
    }
    public static boolean ifshuo(String wanjia){
        File File = new File(main.peizi.工作路径 + "/锁/" + wanjia+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        return wanjiawenjian.getBoolean("锁");
    }
}
