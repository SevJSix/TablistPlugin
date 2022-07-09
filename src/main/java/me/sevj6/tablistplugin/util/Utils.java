package me.sevj6.tablistplugin.util;

import org.bukkit.Bukkit;

public class Utils {

    private static String formatTps(double tps) {
        return (tps > 18.0D ? "§a" : (tps > 16.0D ? "§e" : "§c")) + (tps > 20.0D ? "" : "") + String.format("%.2f", Math.min((double) Math.round(tps * 100.0D) / 100.0D, 20.0D));
    }

    public static String getTPS() {
        return formatTps(Bukkit.getTPS()[0]);
    }

    public static String getFormattedInterval(long ms) {
        long seconds = ms / 1000L % 60L;
        long minutes = ms / 60000L % 60L;
        long hours = ms / 3600000L % 24L;
        long days = ms / 86400000L;
        return String.format("%dd %02dh %02dm %02ds", days, hours, minutes, seconds);
    }
}
