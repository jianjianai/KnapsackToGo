package cn.jji8.kuafubeibaotongbu.ml;

import cn.jji8.kuafubeibaotongbu.io.io;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class jiesuo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length==0){
            return false;
        }
        Thread T = new Thread(){
            @Override
            public void run() {
                io.jieshuo(strings[0]);
            }
        };
        T.start();
        return true;
    }
}
