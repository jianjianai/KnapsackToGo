package cn.jji8.kuafubeibaotongbu.test;

import cn.jji8.kuafubeibaotongbu.bblock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.concurrent.locks.Lock;

public class heal implements Listener {
    private static boolean Lock = false;
    @EventHandler
    public synchronized void onPlayerLogin(PlayerLoginEvent event){
        Thread thread = io.testheal(event.getPlayer());
        // 新建锁对象
        Lock lock = new bblock();
        synchronized (lock){

        }
        thread.notify();
    }
    public void Lock(){
        Lock = true;
    }
    public void unLock(){
        Lock = false;
    }
    public boolean isLock(){
        return Lock;
    }
}
