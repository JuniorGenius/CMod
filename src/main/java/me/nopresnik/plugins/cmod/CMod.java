package me.nopresnik.plugins.cmod;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.bukkit.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CMod extends JavaPlugin implements Listener {

        static final Logger log = Logger.getLogger("Minecraft");
        public List<String> mutedUsers = new ArrayList<String>();
        public CModListener listener = new CModListener(this);

        @Override
        public void onEnable() {
                getServer().getPluginManager().registerEvents(listener, this);

                mutedUsers.addAll(getConfig().getStringList("muted.users"));
        }

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                if (sender.hasPermission("CMod.mod") || sender.isOp()) {
                        if (cmd.getName().equalsIgnoreCase("mute")) {
                                if (args.length == 1) {
                                        Player target = getServer().getPlayer(args[0]);
                                        if (target != null) {
                                                String targetName = target.getName().toLowerCase();
                                                if (!mutedUsers.contains(targetName) && target.isOnline()) {
                                                        mutePlayer(targetName);
                                                        sender.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "You have muted " + ChatColor.BLUE + target.getName());
                                                        target.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "You have been muted by " + ChatColor.BLUE + sender.getName());
                                                        return true;
                                                }
                                        }
                                }
                                sender.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "You must include a player. " + ChatColor.DARK_GREEN + "/mute <player>");
                                return true;
                        }

                        if (cmd.getName().equalsIgnoreCase("unmute")) {
                                if (args.length == 1) {
                                        Player target = getServer().getPlayer(args[0]);
                                        if (target != null) {
                                                if (mutedUsers.contains(args[0])) {
                                                        String targetName = target.getName().toLowerCase();
                                                        removeMuteUser(targetName);
                                                        sender.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "You have unmuted " + ChatColor.BLUE + target.getName());
                                                        target.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "You have been unmuted by " + ChatColor.BLUE + sender.getName());
                                                        return true;
                                                } else {
                                                        sender.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "The player \"" + ChatColor.YELLOW + args[0].toString() + ChatColor.GRAY + "\" is not muted");
                                                        sender.sendMessage(ChatColor.GRAY + "     Make sure you're typing the full name");
                                                        return true;
                                                }
                                        } else {
                                                sender.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "The player \"" + ChatColor.YELLOW + args[0].toString() + ChatColor.GRAY + "\" is not online.");
                                                return true;
                                        }
                                }
                                sender.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "You must include a player. " + ChatColor.DARK_GREEN + "/unmute <player>");
                                return true;
                        }

                }
                return false;
        }

        private void mutePlayer(String player) {
                mutedUsers.add(player.toLowerCase());
                getConfig().set("muted.users", mutedUsers.toArray());
                saveConfig();
        }

        private void removeMuteUser(String player) {
                if (mutedUsers.contains(player.toLowerCase())) {
                        mutedUsers.remove(player.toLowerCase());
                        getConfig().set("muted.users", mutedUsers.toArray());
                }
                saveConfig();
        }
}
