package com.xiaozhengkeji.askbug;

import com.alibaba.fastjson.JSONArray;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import com.wasteofplastic.askyblock.ASkyBlockAPI;
import com.wasteofplastic.askyblock.Island;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ASKBug extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        MsgUtils.logServer("已经加载");
    }

    @Override
    public void onDisable() {
        MsgUtils.logServer("已经卸载");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInteract(PlayerInteractEvent event) {
        ASkyBlockAPI api = ASkyBlockAPI.getInstance();
        if (!event.isCancelled()) {
            if (event.getPlayer().isOp()) {
                return;
            }
            if (!event.getPlayer().getWorld().equals(api.getIslandWorld())) {
                return;
            }
            Island island = api.getIslandAt(event.getPlayer().getLocation());
            if (island == null) {
                return;
            }
            Block block = event.getClickedBlock();
            if (block.getType() == Material.WALL_SIGN) {
                return;
            }
            if (!island.getMembers().contains(event.getPlayer().getUniqueId())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBreak(BlockBreakEvent event) {
        ASkyBlockAPI api = ASkyBlockAPI.getInstance();
        if (!event.isCancelled()) {
            if (event.getPlayer().isOp()) {
                return;
            }
            if (!event.getPlayer().getWorld().equals(api.getIslandWorld())) {
                return;
            }
            Island island = api.getIslandAt(event.getPlayer().getLocation());
            if (island == null) {
                return;
            }
            if (!island.getMembers().contains(event.getPlayer().getUniqueId())) {
                event.setCancelled(true);
            }
        }
    }
}
