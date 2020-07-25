package cn.jji8.kuafubeibaotongbu.shijian;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class beibaojiazai extends Event implements Cancellable {//背包加载事件
    private static final HandlerList handlers = new HandlerList();
    boolean isCancelled = false;
    Player Player;
    public beibaojiazai(Player a){
        Player = a;
    }
    public Player getPlayer(){
        return Player;
    }
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }
}




