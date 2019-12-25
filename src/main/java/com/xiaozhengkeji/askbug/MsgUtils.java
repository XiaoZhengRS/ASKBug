package com.xiaozhengkeji.askbug;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MsgUtils {
    /**
     * 发送给服务端的日记方法
     *
     * @param str 消息内容
     */
    public static void logServer(String str) {
        Bukkit.getLogger().info("§d[§5ASKBUG§d]§7>>>§b" + str);
    }

    /**
     * 发送给玩家的日记方法
     *
     * @param p   玩家
     * @param str 消息内容
     */
    public static void logPlayer(Player p, String str) {
        p.sendMessage("§d[§5ASKBUG§d]§7>>>§b" + str);
    }
}
