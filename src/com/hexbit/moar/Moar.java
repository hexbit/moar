package com.hexbit.moar;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.material.MaterialData;
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
					moar(player, args[0], amount);
				}
				catch (NumberFormatException e) {
					player.sendMessage("Usage: /moar <block name> <#>");
				}
			}
			
			return true;
		}
		
		else if (commandLabel.equalsIgnoreCase("m")) {
			moar(player);
			return true;
		}
		
		return false;
	}
	//Polymorphism FTW
	private void moar(Player player) {
		if (player.getInventory().getItemInHand().getTypeId() != 0) {
			ItemStack itemInHand = player.getInventory().getItemInHand();
			itemInHand.setAmount(itemInHand.getMaxStackSize());
		}
	}
	
	//TODO: Check for max stack size
	private void moar(Player player, int amount) {
		if (player.getInventory().getItemInHand().getTypeId() != 0) {
			ItemStack itemInHand = player.getInventory().getItemInHand(); 
			
			if ((amount + itemInHand.getAmount()) > itemInHand.getMaxStackSize()) {
				itemInHand.setAmount(itemInHand.getMaxStackSize());
				ItemStack stack = itemInHand;
				stack.setAmount(amount);
				player.getWorld().dropItemNaturally(player.getLocation(), stack);
			}
			else {
				itemInHand.setAmount(itemInHand.getAmount() + amount);
			}
		}
	}
	//Don't use this right now, item look up needs to be implemented first
	private void moar(Player player, String itemName, int amount) {
		//TODO: Look into if this is the best way to be doing this
		MaterialData material = new MaterialData(1);
		ItemStack stack = material.toItemStack();
		//stack.setTypeId(typeId); 
		//stack.setAmount(amount);
		player.getWorld().dropItemNaturally(player.getLocation(), stack);
	}
}
