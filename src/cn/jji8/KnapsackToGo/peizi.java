package cn.jji8.KnapsackToGo;

import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class peizi {//我是专门负责读取配置的啦
    public String 工作路径,加载标题1,加载标题2;
    public boolean 同步背包,背包加载前旁观者模式,进入服务器后清空背包,后台显示更多信息,同步血量饱食度,同步药水效果,同步经验,自动保存,末影箱;
    public int 判读锁间隔,自动保存时间;
    public GameMode 服务器游戏模式;
    peizi() throws IOException {
        main.main.saveResource("peizi.yml",false);
        YamlConfiguration a = YamlConfiguration.loadConfiguration(new File(main.main.getDataFolder(), "peizi.yml"));
        工作路径 = a.getString("工作路径");
        File File = new File(工作路径,"同步.配置.yml");
        YamlConfiguration b = YamlConfiguration.loadConfiguration(File);

        if(b.contains("末影箱")){
            末影箱 = b.getBoolean("末影箱");
        }else {
            b.set("末影箱",true);
            末影箱 = true;
            b.save(File);
        }
        if(b.contains("自动保存")){
            自动保存 = b.getBoolean("自动保存");
        }else {
            b.set("自动保存",true);
            自动保存 = true;
            b.save(File);
        }
        if(b.contains("自动保存时间")){
            自动保存时间 = b.getInt("自动保存时间");
        }else {
            b.set("自动保存时间",60);
            自动保存时间 = 60;
            b.save(File);
        }
        if(b.contains("同步经验")){
            同步经验 = b.getBoolean("同步经验");
        }else {
            b.set("同步经验",true);
            同步经验 = true;
            b.save(File);
        }
        if(b.contains("同步背包")){
            同步背包 = b.getBoolean("同步背包");
        }else {
            b.set("同步背包",true);
            同步背包 = true;
            b.save(File);
        }
        if(b.contains("同步药水效果")){
            同步药水效果 = b.getBoolean("同步药水效果");
        }else {
            b.set("同步药水效果",true);
            同步药水效果 = true;
            b.save(File);
        }
        if(b.contains("同步血量饱食度")){
            同步血量饱食度 = b.getBoolean("同步血量饱食度");
        }else {
            b.set("同步血量饱食度",true);
            同步血量饱食度 = true;
            b.save(File);
        }
        if(b.contains("判读锁间隔")){
            判读锁间隔 = b.getInt("判读锁间隔");
        }else {
            b.set("判读锁间隔",500);
            判读锁间隔 = 500;
            b.save(File);
        }
        if(b.contains("加载标题1")){
            加载标题1 = b.getString("加载标题1");
        }else {
            b.set("加载标题1","正在进入，请稍等...");
            加载标题1 = "正在进入，请稍等...";
            b.save(File);
        }
        if(b.contains("加载标题2")){
            加载标题2 = b.getString("加载标题2");
        }else {
            b.set("加载标题2","正在载入你的数据，如果长时间无法载入，请联系管理员！");
            加载标题2 ="正在载入你的数据，如果长时间无法载入，请联系管理员！";
            b.save(File);
        }
        if(b.contains("服务器游戏模式")){
            String 服务器游戏模式1 = b.getString("服务器游戏模式");
            服务器游戏模式 = GameMode.valueOf(服务器游戏模式1);
        }else {
            b.set("服务器游戏模式","SURVIVAL");
            服务器游戏模式 = GameMode.SURVIVAL;
            b.save(File);
        }
        if(b.contains("背包加载前旁观者模式")){
            背包加载前旁观者模式 = b.getBoolean("背包加载前旁观者模式");
        }else {
            b.set("背包加载前旁观者模式",false);
            背包加载前旁观者模式 = false;
            b.save(File);
        }
        if(b.contains("进入服务器后清空背包")){
            进入服务器后清空背包 = b.getBoolean("进入服务器后清空背包");
        }else {
            b.set("进入服务器后清空背包",true);
            进入服务器后清空背包 = true;
            b.save(File);
        }
        if(b.contains("后台显示更多信息")){
            后台显示更多信息 = b.getBoolean("后台显示更多信息");
        }else {
            b.set("后台显示更多信息",true);
            后台显示更多信息 = true;
            b.save(File);
        }

    }
}
