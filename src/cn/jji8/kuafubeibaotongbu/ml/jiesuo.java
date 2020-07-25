package cn.jji8.kuafubeibaotongbu.ml;

import cn.jji8.kuafubeibaotongbu.kongzhiqi.suoio;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class jiesuo implements CommandExecutor {//我是解锁命令执行器啦
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length==0){
            return false;
        }
        Thread T = new Thread(() -> suoio.jieshuo(strings[0]));
        T.start();
        return true;
    }
}
