package me.sevj6.tablistplugin.tablist;

import org.bukkit.entity.Player;

import java.util.List;

public interface ITablist {

    void init();

    void sendHeaderAndFooterList();

    String parseText(String text, Player player);

    List<Player> getOnlinePlayers();

    int getPlayerPing(Player player);

}
