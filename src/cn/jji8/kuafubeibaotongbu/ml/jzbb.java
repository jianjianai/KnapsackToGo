package cn.jji8.kuafubeibaotongbu.ml;

import cn.jji8.kuafubeibaotongbu.io.io;
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
        Thread T = new Thread(){
            @Override
            public void run() {
                io.jiazaibeibao((Player) commandSender);
            }
        };
        T.start();
        return true;
    }
}
