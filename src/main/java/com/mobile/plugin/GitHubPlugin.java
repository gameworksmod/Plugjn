package me.fomomrjb.ezanticheat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EZAntiCheat extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        this.getCommand("ezanticheat").setExecutor(this);
        getLogger().info("EZAntiCheat has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("EZAntiCheat has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /ezanticheat <creative|survival|enable|disable>");
            return true;
        }

        String subCommand = args[0].toLowerCase();

        // Admin commands: /ezanticheat enable /ezanticheat disable
        if (subCommand.equals("enable") || subCommand.equals("disable")) {
            if (sender.isOp()) {
                sender.sendMessage(ChatColor.YELLOW + "AntiCheat state toggled (Nothing actually changed).");
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            }
            return true;
        }

        // Target commands: /ezanticheat creative /ezanticheat survival
        if (subCommand.equals("creative") || subCommand.equals("survival")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.getName().equals("fomomrjb")) {
                    player.sendMessage(ChatColor.GREEN + "Executed command: " + subCommand + " (Nothing actually changed).");
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                }
            } else {
                sender.sendMessage("Only players can run this command.");
            }
            return true;
        }

        sender.sendMessage(ChatColor.RED + "Unknown argument. Usage: /ezanticheat <creative|survival|enable|disable>");
        return true;
    }
}
