package me.sevj6.tablistplugin;

import me.sevj6.tablistplugin.command.ReloadConfig;
import me.sevj6.tablistplugin.tablist.Tablist;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class TablistPlugin extends JavaPlugin {

    public static final long START_TIME = System.currentTimeMillis();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Tablist tablist = new Tablist(this);
        tablist.init();
        Objects.requireNonNull(getCommand("tabrl")).setExecutor(new ReloadConfig(this));
    }

    @Override
    public void onDisable() {

    }
}
