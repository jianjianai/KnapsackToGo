package cn.jji8.kuafubeibaotongbu.ml;

import cn.jji8.kuafubeibaotongbu.diaoduqi.iodiaodu;
import cn.jji8.kuafubeibaotongbu.kongzhiqi.suoio;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class jzbb implements CommandExecutor {//我是加载背包命令执行器啦啦啦

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("此命令只有玩家可以使用");
            return true;
        }
        Thread T = new Thread(() -> iodiaodu.jiazai((Player) commandSender));
        T.start();
        return true;
    }
}
