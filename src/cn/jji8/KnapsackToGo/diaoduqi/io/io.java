package cn.jji8.KnapsackToGo.diaoduqi.io;


import org.bukkit.entity.Player;

public interface io {//我是一个接口
    /**
     * 正常读取，玩家在没用非正常退出的情况下正常读取数据
     * */
    public void duqu(Player wanjia);//读取
    /**
     * 正常写入，玩家退出时写入数据
     * */
    public void xieru(Player wanjia);//写入
    /**
     * 自动保存
     * 自动保存时调用的保存方法
     * */
    public void zidongbaocun(Player wanjia);
    /**
     * 非正常读取，玩家数据没有正常保存而是因为服务器崩溃退出游戏，使用自动保存的数据加载
     * */
    public void feizhengchangduqu(Player wanjia);
}
