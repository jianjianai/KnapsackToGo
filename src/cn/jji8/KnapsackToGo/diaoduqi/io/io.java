package cn.jji8.KnapsackToGo.diaoduqi.io;


import org.bukkit.entity.Player;

public interface io {//我是一个接口
    /**
     * 异步的读取方法
     * */
    public void duqu(Player wanjia);//读取
    /**
     * 用于保存玩家数据
     * */
    public void xieru(Player wanjia);//写入
}
