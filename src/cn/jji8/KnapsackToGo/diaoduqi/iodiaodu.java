package cn.jji8.KnapsackToGo.diaoduqi;

import cn.jji8.KnapsackToGo.diaoduqi.io.io;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class iodiaodu {//我专门负责调度io
    static ArrayList<io> diaodubiao = new ArrayList<io>();
    public static void addio(io a){
        diaodubiao.add(a);
    }
    public static void jiazai(Player a){
        for(int i=0;i<diaodubiao.size();i++){
            diaodubiao.get(i).duqu(a);
        }
    }
    public static void baocun(Player a){
        for(int i=0;i<diaodubiao.size();i++){
            diaodubiao.get(i).xieru(a);
        }
    }
}
