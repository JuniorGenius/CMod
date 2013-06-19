package me.nopresnik.plugins.cmod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    public List<String> frozenUsers = new ArrayList<String>();
    public CModListener listener = new CModListener(this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(listener, this);

        mutedUsers.addAll(getConfig().getStringList("muted.users"));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("colour")) {
            Random object = new Random();
            int color;
            for (int counter = 1; counter <= 1; counter++) {
                color = 1 + object.nextInt(6);

                if (color == 1) {
                    player.setDisplayName(ChatColor.RED + player.getName());
                    player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.RED + "red" + ChatColor.GRAY + "!");
                }
                if (color == 2) {
                    player.setDisplayName(ChatColor.BLUE + player.getName());
                    player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.BLUE + "blue" + ChatColor.GRAY + "!");
                }
                if (color == 3) {
                    player.setDisplayName(ChatColor.DARK_GREEN + player.getName());
                    player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.DARK_GREEN + "green" + ChatColor.GRAY + "!");
                }
                if (color == 4) {
                    player.setDisplayName(ChatColor.YELLOW + player.getName());
                    player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.YELLOW + "yellow" + ChatColor.GRAY + "!");
                }
                if (color == 5) {
                    player.setDisplayName(ChatColor.AQUA + player.getName());
                    player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.AQUA + "aqua" + ChatColor.GRAY + "!");
                }
                if (color == 6) {
                    player.setDisplayName(ChatColor.GRAY + player.getName());
                    player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now gray!");
                }
            }
            return true;
        if (cmd.getName().equalsIgnoreCase("colour")) {
            if (args.length == 1) {
                if (target != null) {
    				String color = null;
					color = color.toLowerCase();
					if (color == red) {
						player.setDisplayName(ChatColor.RED + player.getName());
						player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.RED + "red" + ChatColor.GRAY + "!");
					}
					else if (color == blue) {
						player.setDisplayName(ChatColor.BLUE + player.getName());
						player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.BLUE + "blue" + ChatColor.GRAY + "!");
					}
					else if (color == green) {
						player.setDisplayName(ChatColor.DARK_GREEN + player.getName());
						player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.DARK_GREEN + "green" + ChatColor.GRAY + "!");
					}
					else if (color == yellow) {
						player.setDisplayName(ChatColor.YELLOW + player.getName());
						player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.YELLOW + "yellow" + ChatColor.GRAY + "!");
					}
					else if (color == aqua) {
						player.setDisplayName(ChatColor.AQUA + player.getName());
						player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now " + ChatColor.AQUA + "aqua" + ChatColor.GRAY + "!");
					}
					else if (color == gray) {
						player.setDisplayName(ChatColor.GRAY + player.getName());
						player.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "Your chat name is now gray!");
					}
					else {
					    player.sendMessage(ChatColor.RED + "Usage:");
					    player.sendMessage(ChatColor.RED + "/color <color>");
					    player.sendMessage(ChatColor.RED + "Available colors: red, blue, green, yellow, aqua, gray.");
					}
                }
            }
            else if (args.length > 1 || args.length < 1) {
                player.sendMessage(ChatColor.RED + "Usage:");
				player.sendMessage(ChatColor.RED + "/color <color>");
				player.sendMessage(ChatColor.RED + "Available colors: red, blue, darkgreen, yellow, aqua, gray.");
            }
            return true;
        }

        if (sender.hasPermission("CMod.mod") || sender.isOp()) {
            Player target = getServer().getPlayer(args[0]);
            String targetName = target.getName().toLowerCase();
            if (cmd.getName().equalsIgnoreCase("freeze")) {
                if (args.length == 1) {
                    if (target != null) {
                        freezePlayer(targetName);
                        target.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "You have been frozen by " + ChatColor.YELLOW + sender.getName());
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "You must include a player's name");
                    return true;
                }
            }
            if (cmd.getName().equalsIgnoreCase("unfreeze")) {
                if (args.length == 1) {
                    if (target != null) {
                        unFreezePlayer(targetName);
                        target.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "You have been unfrozen by " + ChatColor.YELLOW + sender.getName());
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "[C] " + ChatColor.GRAY + "You must include a player's name");
                    return true;
                }
            }
            if (cmd.getName().equalsIgnoreCase("mute")) {
                if (args.length == 1) {

                    if (target != null) {
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
                    if (target != null) {
                        if (mutedUsers.contains(args[0])) {
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

        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You do not have permission.");
            return true;
        }
        return false;
    }

    private void mutePlayer(String player) {
        mutedUsers.add(player.toLowerCase());
        getConfig().set("muted.users", mutedUsers.toArray());
        saveConfig();
    }

    private void freezePlayer(String player) {
        frozenUsers.add(player.toLowerCase());
    }

    private void unFreezePlayer(String player) {
        frozenUsers.remove(player.toLowerCase());
    }

    private void removeMuteUser(String player) {
        if (mutedUsers.contains(player.toLowerCase())) {
            mutedUsers.remove(player.toLowerCase());
            getConfig().set("muted.users", mutedUsers.toArray());
        }
        saveConfig();
    }
}
