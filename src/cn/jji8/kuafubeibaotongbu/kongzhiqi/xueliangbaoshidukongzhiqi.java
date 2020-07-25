package cn.jji8.kuafubeibaotongbu.kongzhiqi;

import cn.jji8.kuafubeibaotongbu.io.io;
import cn.jji8.kuafubeibaotongbu.shijian.beibaobaocun;
import cn.jji8.kuafubeibaotongbu.shijian.beibaojiazai;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class xueliangbaoshidukongzhiqi implements Listener {//我是血量饱食度同步控制器
    @EventHandler(priority= EventPriority.MONITOR)
    public void beibaojiazai(beibaojiazai a){//背包加载时
        Thread T = new Thread(()-> io.jiazaixueliangbaoshidu(a.getPlayer()));
        T.start();
    }
    @EventHandler(priority= EventPriority.MONITOR)
    public void beibaobaocun(beibaobaocun a){//背包保存时
        Thread T = new Thread(()->io.baocunxueliangbaoshidu(a.getPlayer()));
        T.start();
    }
}
