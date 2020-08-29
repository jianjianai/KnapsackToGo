package cn.jji8.KnapsackToGo.diaoduqi;

import cn.jji8.KnapsackToGo.diaoduqi.io.io;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class iodiaodu {//我专门负责调度io
    static ArrayList<io> diaodubiao = new ArrayList<io>();
    /**
     * 添加读取保存器
     * */
    public static void addio(io a){
        diaodubiao.add(a);
    }
    /**
     * 正常读取，玩家在没用非正常退出的情况下正常读取数据
     * */
    public static void jiazai(Player a){
        for(int i=0;i<diaodubiao.size();i++){
            diaodubiao.get(i).duqu(a);
        }
    }
    /**
     * 正常写入，玩家退出时写入数据
     * */
    public static void baocun(Player a){
        for(int i=0;i<diaodubiao.size();i++){
            diaodubiao.get(i).xieru(a);
        }
    }
    /**
     * 自动保存
     * */
    public static void zidongbaocun(Player a){
        for(int i=0;i<diaodubiao.size();i++){
            diaodubiao.get(i).zidongbaocun(a);
        }
    }
    /**
     * 非正常读取，玩家数据没有正常保存而是因为服务器崩溃退出游戏，使用自动保存的数据加载
     * */
    public static void feizhengchangduqu(Player a){
        for(int i=0;i<diaodubiao.size();i++){
            diaodubiao.get(i).feizhengchangduqu(a);
        }
    }
}
