package cn.jji8.kuafubeibaotongbu.test;

import cn.jji8.kuafubeibaotongbu.bblock;
import cn.jji8.kuafubeibaotongbu.main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class io {
    public static synchronized Thread testheal(Player player){
        // 新建锁对象
        Lock lock = new bblock();
        // 创建进程
        Thread thread = new Thread(()->{
            // 获取运行开始的时间
            long startTime = System.currentTimeMillis();
            // 加锁
            lock.lock();
            Bukkit.getLogger().info("线程已经占用，开始进行读写操作——测试类");
            try {
                File filetest = new File(main.peizi.工作路径 + "/test/" + player.getName()+".yml");
                File fileParent = filetest.getParentFile();
                if (!fileParent.exists()){
                    filetest.mkdirs();
                    filetest.createNewFile();
                }
                // 将文件转为类配置文件
                YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(filetest);
                int i = yamlConfiguration.getInt("test");
                i++;
                yamlConfiguration.set("test",i);
                yamlConfiguration.save(filetest);
                // 等待操作，用于模拟并发
                Bukkit.getLogger().info("进入等待，持续15秒——测试类");
                TimeUnit.SECONDS.sleep(15);
                Bukkit.getLogger().info("等待结束——测试类");
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
            Bukkit.getLogger().info("读写操作完成，结束线程占用——测试类");
            // 解锁
            lock.unlock();
            // 获取运行结束的时间
            long endTime = System.currentTimeMillis();
            Bukkit.getLogger().info("[跨服背包同步]:测试类执行所用时间： "+(endTime-startTime)+"ns");
        },"测试类");
        // 等待被唤醒
        thread.start();
        return thread;
    }
}
