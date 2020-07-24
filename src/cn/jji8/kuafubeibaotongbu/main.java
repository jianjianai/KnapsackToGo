package cn.jji8.kuafubeibaotongbu;


import cn.jji8.kuafubeibaotongbu.kongzhiqi.tongbubeibaokongzhiqi;
import cn.jji8.kuafubeibaotongbu.ml.bcbb;
import cn.jji8.kuafubeibaotongbu.ml.jiesuo;
import cn.jji8.kuafubeibaotongbu.ml.jzbb;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.ArrayList;


public class main extends JavaPlugin{
   public static main main;
   public static peizi peizi;
   public static ArrayList wanjiabiao = new ArrayList();

    public void onEnable(){
        main = this;

        System.out.println("[跨服背包同步]:作者:简简爱");
        System.out.println("[跨服背包同步]:开始初始化");


        //加载配置
        try {
            peizi = new peizi();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[跨服背包同步]:配置无法加载，工作路径是否存在！");
        }
        System.out.println("[跨服背包同步]:工作路径是："+peizi.工作路径);
        //注册命令
        Bukkit.getPluginCommand("保存背包").setExecutor(new bcbb());
        Bukkit.getPluginCommand("加载背包").setExecutor(new jzbb());
        Bukkit.getPluginCommand("解锁").setExecutor(new jiesuo());
        //注册控制器

        if(peizi.同步背包){
            tongbubeibaokongzhiqi tongbubeibaokongzhiqi = new tongbubeibaokongzhiqi();
            Bukkit.getPluginManager().registerEvents(tongbubeibaokongzhiqi,this);
        }



        System.out.println("[跨服背包同步]:初始化完成");
    }
}

