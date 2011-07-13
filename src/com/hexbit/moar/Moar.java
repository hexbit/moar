package com.hexbit.moar;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
 
/**
  * Moar Plugin
  * @author hexbit
  * @version 0.1
  */
public class Moar extends JavaPlugin {
	private static final Logger log = Logger.getLogger("Minecraft");
	
	@Override
	public void onDisable() {
		PluginDescriptionFile plugDesc = this.getDescription();
		log.info(plugDesc.getName() + "Version: " + plugDesc.getVersion() + " Disabled");
	}

	@Override
	public void onEnable() {
		PluginDescriptionFile plugDesc = this.getDescription();
		log.info(plugDesc.getName() + " " + plugDesc.getVersion() + " Loaded");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player player;
		
		if (sender instanceof Player) {
			player = (Player) sender;
		}
		
		else {
			sender.sendMessage("This is only available to players");
			return false;
		}
		
		
		if (commandLabel.equalsIgnoreCase("moar")) {
			System.out.println(commandLabel + " args: " + args.toString());
			
			if (args.length == 0) {
				return false;
			}
			
			else if (args.length == 1) {
				try {
					int amount = Integer.parseInt(args[0]);
					moar(player, amount);
				}
				catch (NumberFormatException e) {
					player.sendMessage("Usage: /moar <#>");
				}
			}
			else if (args.length == 2) {
				try {
					int amount = Integer.parseInt(args[1]);
					giveMoar(player, args[0], amount);
				}
				catch (NumberFormatException e) {
					player.sendMessage("Usage: /moar <block name> <#>");
				}
			}
			
			return true;
		}
		
		else if (commandLabel.equalsIgnoreCase("m")) {
			ItemStack itemInHand = player.getInventory().getItemInHand();
			itemInHand.setAmount(64);
		}
		
		return false;
	}
	
	private void giveMoar(Player player, String itemName, int ammount) {
		//TODO: Give player the amount
	}
	
	private void moar(Player player, int amount) {
		//TODO: Give Player moar of what is in their hand
	}
}
