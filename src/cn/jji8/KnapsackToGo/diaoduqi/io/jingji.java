package cn.jji8.KnapsackToGo.diaoduqi.io;

import cn.jji8.KnapsackToGo.main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.io.File;
import java.io.IOException;

/**
 * 用于同步玩家经济
 * */
public class jingji implements io{
    Economy econ = null;
    public jingji(){
        if (main.main.getServer().getPluginManager().getPlugin("Vault") == null) {
            System.out.println("没有找到Vault依赖");
            return;
        }
        RegisteredServiceProvider<Economy> rsp = main.main.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            System.out.println("请安装ess");
            return;
        }
        econ = rsp.getProvider();
    }

    @Override
    public void duqu(Player wanjia) {
        long startTime = System.currentTimeMillis();
        if(econ==null){
            main.main.getLogger().warning("经济插件前置错误，取消读取");
            return;
        }
        File File = new File(main.peizi.工作路径 + "/经济/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        if(!wanjiawenjian.contains("钱")){
            main.main.getLogger().info("此玩家没有经济数据，暂不加载！");
            return;
        }
        double 服务器钱 = econ.getBalance(wanjia);
        double 玩家钱 = wanjiawenjian.getDouble("钱");
        double 上次退出时钱;
        double 变化钱 = 0;
        if(wanjiawenjian.contains(main.peizi.唯一标识符)){
            上次退出时钱 = wanjiawenjian.getDouble(main.peizi.唯一标识符);
            变化钱 = 服务器钱 - 上次退出时钱;
        }
        for(int i = 0;i<10;i++){
            if(econ.withdrawPlayer(wanjia,econ.getBalance(wanjia)).transactionSuccess()){//扣除玩家全部的钱，成功跳出循环
                break;
            }
            main.main.getLogger().info("操作玩家钱失败，尝试重新操作");
        }
        for(int i = 0;i<10;i++){
            if(econ.depositPlayer(wanjia,玩家钱+变化钱).transactionSuccess()){//将读取的钱给玩家，成功跳出循环
                break;
            }
            main.main.getLogger().info("操作玩家钱失败，尝试重新操作");
        }
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息) Bukkit.getLogger().info("[跨服背包同步]:经济加载用时间： "+(endTime-startTime)+"ns");
    }

    @Override
    public void xieru(Player wanjia) {
        long startTime = System.currentTimeMillis();
        if(econ==null){
            main.main.getLogger().warning("经济插件前置错误，取消写入");
            return;
        }
        File File = new File(main.peizi.工作路径 + "/经济/" + wanjia.getName()+".yml");
        YamlConfiguration wanjiawenjian = YamlConfiguration.loadConfiguration(File);
        wanjiawenjian.set("钱",econ.getBalance(wanjia));
        wanjiawenjian.set(main.peizi.唯一标识符,econ.getBalance(wanjia));
        try {
            wanjiawenjian.save(File);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("[跨服背包同步]:经济保存失败,玩家背包未保存，请检查写入权限，或磁盘空间");
        }
        long endTime = System.currentTimeMillis();
        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:经济保存用时： "+(endTime-startTime)+"ns");
    }
}
