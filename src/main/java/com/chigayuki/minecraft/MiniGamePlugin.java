package com.chigayuki.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public final class MiniGamePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("miniGamePluginが起動したよ");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("ignite")) {
            if (args.length != 1) {
                return false;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can set other on fire.");
                sender.sendMessage("This is an arbitrary requirement for demonstration purposes only.");
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(args[0] + " is not currently online.");
                return true;
            }
            target.setFireTicks(1000);
            return true;
        } else if (command.getName().equalsIgnoreCase("rod")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("");
            }
        }
        return false;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("miniGamePluginが落ちたよ");
    }
}
