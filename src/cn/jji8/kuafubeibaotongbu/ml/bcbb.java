package cn.jji8.kuafubeibaotongbu.ml;

import cn.jji8.kuafubeibaotongbu.diaoduqi.iodiaodu;
import cn.jji8.kuafubeibaotongbu.kongzhiqi.suoio;
import cn.jji8.kuafubeibaotongbu.kongzhiqi.suokongziqi;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class bcbb implements CommandExecutor {//我是保存背包命令执行器啦啦啦

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("此命令只有玩家可以使用");
            return true;
        }
        Thread T = new Thread(() -> iodiaodu.baocun((Player) commandSender));
        T.start();
        return true;
    }
}
