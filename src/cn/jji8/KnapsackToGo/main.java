package cn.jji8.KnapsackToGo;


import cn.jji8.KnapsackToGo.diaoduqi.io.beibao;
import cn.jji8.KnapsackToGo.diaoduqi.io.xueliangbaoshidu;
import cn.jji8.KnapsackToGo.diaoduqi.iodiaodu;
import cn.jji8.KnapsackToGo.kongzhiqi.suokongziqi;
import cn.jji8.KnapsackToGo.ml.bcbb;
import cn.jji8.KnapsackToGo.ml.jiesuo;
import cn.jji8.KnapsackToGo.ml.jzbb;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.ArrayList;


public class main extends JavaPlugin {
    public static main main;
    public static peizi peizi;
    public static ArrayList wanjiabiao = new ArrayList();

    public void onEnable() {
        main = this;

        Bukkit.getLogger().info("[跨服背包同步]:作者:简简爱");
        Bukkit.getLogger().info("[跨服背包同步]:开始初始化");


        //加载配置
        try {
            peizi = new peizi();
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().info("[跨服背包同步]:配置无法加载，工作路径是否存在！");
        }
        Bukkit.getLogger().info("[跨服背包同步]:工作路径是："+peizi.工作路径);
        //注册命令
        Bukkit.getPluginCommand("保存背包").setExecutor(new bcbb());
        Bukkit.getPluginCommand("加载背包").setExecutor(new jzbb());
        Bukkit.getPluginCommand("解锁").setExecutor(new jiesuo());
        //注册锁控制器
        suokongziqi suokongziqi = new suokongziqi();
        Bukkit.getPluginManager().registerEvents(suokongziqi,this);

        //注册控制器
        //同步背包控制器
        if(peizi.同步背包){
            beibao beibao = new beibao();
            iodiaodu.addio(beibao);
            Bukkit.getLogger().info("[跨服背包同步]:同步背包开启");
        }
        //同步血量饱食度控制器
        if(peizi.同步血量饱食度){
            xueliangbaoshidu xueliangbaoshidu = new xueliangbaoshidu();
            iodiaodu.addio(xueliangbaoshidu);
            Bukkit.getLogger().info("[跨服背包同步]:同步血量饱食度开启");
        }
        Bukkit.getLogger().info("[跨服背包同步]:初始化完成");
    }
}

