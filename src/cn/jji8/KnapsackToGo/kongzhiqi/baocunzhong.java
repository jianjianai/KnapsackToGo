package cn.jji8.KnapsackToGo.kongzhiqi;

import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * 用于线程同步
 * */
public class baocunzhong {
    static ArrayList<Player> biao = new  ArrayList<Player>();
    /**
     * 设置一个玩家的状态正在加载
     * 如果玩家已经正在加载返回false
     * */
    public static boolean setjiazai(Player a){
        synchronized (a){
            if(biao.contains(a)){
                return  false;
            }
            biao.add(a);
            return true;
        }
    }

    /**
     * 设置玩家加载完成
     * 设置成功返回true 失败返回false
     * */
    public static boolean setjiazaiwancheng(Player a){
        synchronized (a){
            return  biao.remove(a);
        }
    }


    /**
     * 查询玩家是否正在加载，正在加载返回true
     * */
    public static boolean chaxun(Player a){
        synchronized (a){
            return  biao.contains(a);
        }
    }
}
