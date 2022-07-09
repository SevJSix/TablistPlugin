package me.sevj6.tablistplugin.command;

import me.sevj6.tablistplugin.TablistPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadConfig implements CommandExecutor {

    private final TablistPlugin plugin;

    public ReloadConfig(TablistPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("tab.reload") || sender.isOp()) {
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "Successfully reloaded the config file.");
        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to run this command");
        }
        return true;
    }
}
