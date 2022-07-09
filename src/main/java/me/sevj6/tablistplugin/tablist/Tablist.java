package me.sevj6.tablistplugin.tablist;

import me.sevj6.tablistplugin.TablistPlugin;
import me.sevj6.tablistplugin.util.Utils;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Tablist implements ITablist {

    private final List<String> headerList;
    private final List<String> footerList;
    private final TablistPlugin plugin;

    public Tablist(TablistPlugin plugin) {
        this.plugin = plugin;
        this.headerList = plugin.getConfig().getStringList("Header");
        this.footerList = plugin.getConfig().getStringList("Footer");
    }

    @Override
    public void init() {
        plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, this::sendHeaderAndFooterList, 20L, 20L);
    }

    @Override
    public void sendHeaderAndFooterList() {
        if (getOnlinePlayers().isEmpty()) return;
        getOnlinePlayers().forEach(player -> {
            Component header = Component.text(parseText(String.join("\n", headerList), player));
            Component footer = Component.text(parseText(String.join("\n", footerList), player));
            player.sendPlayerListHeaderAndFooter(header, footer);
        });
    }

    @Override
    public String parseText(String text, Player player) {
        int ping = getPlayerPing(player);
        String tps = Utils.getTPS();
        return ChatColor.translateAlternateColorCodes('&', text
                .replace("%tps%", tps)
                .replace("%players%", String.valueOf(getOnlinePlayers().size()))
                .replace("%ping%", String.valueOf(ping))
                .replace("%uptime%", Utils.getFormattedInterval(System.currentTimeMillis() - TablistPlugin.START_TIME))
        );
    }

    @Override
    public List<Player> getOnlinePlayers() {
        return new ArrayList<>(Bukkit.getOnlinePlayers());
    }

    @Override
    public int getPlayerPing(Player player) {
        return player.getPing();
    }
}
