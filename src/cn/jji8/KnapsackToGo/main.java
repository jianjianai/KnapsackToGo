package cn.jji8.KnapsackToGo;


import cn.jji8.KnapsackToGo.diaoduqi.io.*;
import cn.jji8.KnapsackToGo.diaoduqi.iodiaodu;
import cn.jji8.KnapsackToGo.kongzhiqi.suoio;
import cn.jji8.KnapsackToGo.kongzhiqi.suokongziqi;
import cn.jji8.KnapsackToGo.ml.bcbb;
import cn.jji8.KnapsackToGo.ml.jiesuo;
import cn.jji8.KnapsackToGo.ml.jzbb;
import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class main extends JavaPlugin {
    public static main main;
    public static peizi peizi;
    public static ArrayList wanjiabiao = new ArrayList();
    Metrics Metrics;

    public void onEnable() {
        main = this;

        Bukkit.getLogger().info("[跨服背包同步]:作者:简简爱");
        Bukkit.getLogger().info("[跨服背包同步]:开始初始化");
        Metrics = new Metrics(this,8687);

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
        if(peizi.末影箱){
            moyingxiang moyingxiang  = new moyingxiang();
            iodiaodu.addio(moyingxiang );
            Bukkit.getLogger().info("[跨服背包同步]:同步末影箱开启");
        }
        //同步血量饱食度控制器
        if(peizi.同步血量饱食度){
            xueliangbaoshidu xueliangbaoshidu = new xueliangbaoshidu();
            iodiaodu.addio(xueliangbaoshidu);
            Bukkit.getLogger().info("[跨服背包同步]:同步血量饱食度开启");
        }
        if(peizi.同步药水效果){
            yaosui yaosui = new yaosui();
            iodiaodu.addio(yaosui);
            Bukkit.getLogger().info("[跨服背包同步]:同步药水效果开启");
        }
        if(peizi.同步经济){
            jingji jingji = new jingji();
            iodiaodu.addio(jingji);
            Bukkit.getLogger().info("[跨服背包同步]:同步经济开启");
        }
        if(peizi.同步经验){
            jingyan jingyan = new jingyan();
            iodiaodu.addio(jingyan);
            Bukkit.getLogger().info("[跨服背包同步]:同步经验开启");
        }
        if(peizi.自动保存){
            Thread T = new Thread(){
                @Override
                public void run() {
                    Bukkit.getLogger().info("[跨服背包同步]:自动保存开启，自动保存时间间隔为："+peizi.自动保存时间+"秒");
                    while (true){
                        long 自动保存时间 = System.currentTimeMillis()+(peizi.自动保存时间*1000);
                        while (true){
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if(System.currentTimeMillis()>=自动保存时间){
                                break;
                            }
                        }
                        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:开始自动保存，全程异步执行，不会影响服务器tps");
                        long startTime = System.currentTimeMillis();
                        Iterator wanjia = org.bukkit.Bukkit.getOnlinePlayers().iterator();
                        while (true){
                            try {
                                Player P = (Player) wanjia.next();
                                if(!main.wanjiabiao.contains(P.getPlayer().getName())){
                                    iodiaodu.baocun(P);
                                }
                            }catch (NoSuchElementException a){
                                break;
                            }
                        }
                        long endTime = System.currentTimeMillis();
                        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:所有玩家全部数据保存用时： "+(endTime-startTime)+"ns");
                    }
                }
            };
            T.setName("自动保存线程");
            T.start();
        }
        Bukkit.getLogger().info("[跨服背包同步]:初始化完成");
    }

    public void onDisable(){
        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:插件关闭保存玩家数据。");
        long startTime = System.currentTimeMillis();
        Iterator wanjia = org.bukkit.Bukkit.getOnlinePlayers().iterator();
        while (true){
            try {
                Player Player = (Player) wanjia.next();
                iodiaodu.baocun(Player);
                suoio.jieshuo(Player.getName());
            }catch (NoSuchElementException a){
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:所有玩家全部数据保存用时： "+(endTime-startTime)+"ns");
    }
}

