package cn.jji8.kuafubeibaotongbu;


import cn.jji8.kuafubeibaotongbu.kongzhiqi.tongbubeibaokongzhiqi;
import cn.jji8.kuafubeibaotongbu.kongzhiqi.xueliangbaoshidukongzhiqi;
import cn.jji8.kuafubeibaotongbu.ml.bcbb;
import cn.jji8.kuafubeibaotongbu.ml.jiesuo;
import cn.jji8.kuafubeibaotongbu.ml.jzbb;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;


public class main extends JavaPlugin {
    public static main main;
    public static peizi peizi;
    public static ArrayList wanjiabiao = new ArrayList();
    private final Lock lock = new bblock();

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

        //注册控制器
        //同步背包控制器
        if(peizi.同步背包){
            Bukkit.getLogger().info("[跨服背包同步]:同步背包开启");
            tongbubeibaokongzhiqi tongbubeibaokongzhiqi = new tongbubeibaokongzhiqi();
            Bukkit.getPluginManager().registerEvents(tongbubeibaokongzhiqi,this);
        }
        if(!peizi.同步背包){ Bukkit.getLogger().info("[跨服背包同步]:同步背包未开启，血量饱食度同步将无效"); }

        //同步血量饱食度控制器
        if(peizi.同步血量饱食度){
            Bukkit.getLogger().info("[跨服背包同步]:同步血量饱食度开启");
            xueliangbaoshidukongzhiqi xueliangbaoshidukongzhiqi = new xueliangbaoshidukongzhiqi();
            Bukkit.getPluginManager().registerEvents(xueliangbaoshidukongzhiqi,this);
        }
        Bukkit.getLogger().info("[跨服背包同步]:初始化完成");
    }
}

