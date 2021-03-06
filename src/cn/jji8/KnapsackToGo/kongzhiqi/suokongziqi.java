package cn.jji8.KnapsackToGo.kongzhiqi;

import cn.jji8.KnapsackToGo.diaoduqi.iodiaodu;
import cn.jji8.KnapsackToGo.main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.*;
import org.bukkit.scheduler.BukkitRunnable;

public class suokongziqi implements Listener {
    @EventHandler
    public void wanjianjingru(PlayerJoinEvent a){//玩家进入时等待其他服务器解锁，然后加锁，加载背包
        main.wanjiabiao.add(a.getPlayer().getName());
        if(main.peizi.进入服务器后清空背包){
            a.getPlayer().getInventory().clear();
        }
        if(main.peizi.背包加载前旁观者模式){
            a.getPlayer().setGameMode(GameMode.SPECTATOR);
        }
        if(main.peizi.后台显示更多信息) Bukkit.getLogger().info("[跨服背包同步]:玩家"+a.getPlayer().getName()+"进入");
        Thread Thread = new Thread(){
            @Override
            public void run() {
                while(suoio.ifshuo(a.getPlayer().getName())){
                    try {
                        sleep(main.peizi.判读锁间隔);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Bukkit.getLogger().warning("[跨服背包同步]:判读锁间隔因为不可抗拒的原因被提前了。");
                    }
                }
                suoio.jiashuo(a.getPlayer().getName());
                iodiaodu.jiazai(a.getPlayer());//加载
                main.wanjiabiao.remove(a.getPlayer().getName());
                if(main.peizi.背包加载前旁观者模式){
                    BukkitRunnable BukkitRunnable = new BukkitRunnable(){
                        @Override
                        public void run() {
                            a.getPlayer().setGameMode(main.peizi.服务器游戏模式);
                        }
                    };
                    BukkitRunnable.runTask(main.main);
                }
            }
        };
        Thread.start();
    }
    @EventHandler
    public void wanjialikai(PlayerQuitEvent a){
        if(main.peizi.后台显示更多信息)Bukkit.getLogger().info("[跨服背包同步]:玩家"+a.getPlayer().getName()+"离开");
        if(main.wanjiabiao.contains(a.getPlayer().getName())){
            suoio.jieshuo(a.getPlayer().getName());
            return;
        }
        Thread T = new Thread(){
            @Override
            public void run() {
                iodiaodu.baocun(a.getPlayer());//保存
                suoio.jieshuo(a.getPlayer().getName());
            }
        };
        T.start();
    }




    @EventHandler
    public void WanJiaYiDong(PlayerMoveEvent a){//玩家移动时
        if(main.wanjiabiao.contains(a.getPlayer().getName())){
            a.setCancelled(true);
            a.getPlayer().sendTitle(main.peizi.加载标题1.replaceAll("%玩家%",a.getPlayer().getName()),main.peizi.加载标题2.replaceAll("%玩家%",a.getPlayer().getName()),10,40,10);
        }
    }
    @EventHandler
    public void WanJiaDiuWuPing(PlayerDropItemEvent a){//玩家丢物品
        if(main.wanjiabiao.contains(a.getPlayer().getName())){
            a.setCancelled(true);
            a.getPlayer().sendTitle(main.peizi.加载标题1.replaceAll("%玩家%",a.getPlayer().getName()),main.peizi.加载标题2.replaceAll("%玩家%",a.getPlayer().getName()),10,40,10);
        }
    }
    @EventHandler
    public void WanJiaPoHuaiFangKuai(BlockBreakEvent a){//玩家破坏方块
        if(main.wanjiabiao.contains(a.getPlayer().getName())){
            a.setCancelled(true);
            a.getPlayer().sendTitle(main.peizi.加载标题1.replaceAll("%玩家%",a.getPlayer().getName()),main.peizi.加载标题2.replaceAll("%玩家%",a.getPlayer().getName()),10,40,10);
        }
    }
    @EventHandler
    public void WanJiaFangZhiFangKuai(BlockPlaceEvent a){//玩家放置方块
        if(main.wanjiabiao.contains(a.getPlayer().getName())){
            a.setCancelled(true);
            a.getPlayer().sendTitle(main.peizi.加载标题1.replaceAll("%玩家%",a.getPlayer().getName()),main.peizi.加载标题2.replaceAll("%玩家%",a.getPlayer().getName()),10,40,10);
        }
    }
    @EventHandler
    public void WanJIaQieHuanFuSou(PlayerSwapHandItemsEvent a){//玩家切换副手
        if(main.wanjiabiao.contains(a.getPlayer().getName())){
            a.setCancelled(true);
            a.getPlayer().sendTitle(main.peizi.加载标题1.replaceAll("%玩家%",a.getPlayer().getName()),main.peizi.加载标题2.replaceAll("%玩家%",a.getPlayer().getName()),10,40,10);
        }
    }
    @EventHandler
    public void  WanJiaJiaoHu(PlayerInteractEvent a){//玩家与空气方块交互时
        if(main.wanjiabiao.contains(a.getPlayer().getName())){
            a.setCancelled(true);
            a.getPlayer().sendTitle(main.peizi.加载标题1.replaceAll("%玩家%",a.getPlayer().getName()),main.peizi.加载标题2.replaceAll("%玩家%",a.getPlayer().getName()),10,40,10);
        }
    }
    @EventHandler
    public void WanJIaDianJiShiTi(PlayerInteractEntityEvent a){//玩家点击实体时
        if(main.wanjiabiao.contains(a.getPlayer().getName())){
            a.setCancelled(true);
            a.getPlayer().sendTitle(main.peizi.加载标题1.replaceAll("%玩家%",a.getPlayer().getName()),main.peizi.加载标题2.replaceAll("%玩家%",a.getPlayer().getName()),10,40,10);
        }
    }
}
