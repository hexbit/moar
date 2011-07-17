/*
 * Moar
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.hexbit.moar;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
 
/**
  * Moar Plugin
  * @author hexbit
  * @author ayan4m1
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
			sender.sendMessage("This command is only available to players!");
			return false;
		}

		if (commandLabel.equalsIgnoreCase("moar")) {
			if (args.length == 0) {
				return false;
			}
			else if (args.length == 1) {
				try {
					int amount = Integer.parseInt(args[0]);
					moar(player, amount);
				}
				catch (NumberFormatException e) {
					player.sendMessage("Usage: /moar <amount>");
				}
			}
			else if (args.length == 2) {
				//TODO: Make sure lookup() parses IDs or parse args[0] and use BlockType.fromID()
				try {
					int amount = Integer.parseInt(args[1]);
					moar(player, args[0], amount);
				}
				catch (NumberFormatException e) {
					player.sendMessage("Usage: /moar <id> <amount>");
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

	/**
	 * Sets the player's currently held item amount to its maximum value
	 * @param player
	 */
	private void moar(Player player) {
		if (player.getItemInHand().getType() != Material.AIR) {
			player.getItemInHand().setAmount(player.getItemInHand().getMaxStackSize());
		}
	}

	/**
	 * Sets the player's current help item amount to the specified value
	 * @param player
	 * @param amount
	 */
	private void moar(Player player, int amount) {
		if (player.getItemInHand().getType() != Material.AIR) {
			ItemStack itemInHand = player.getItemInHand();
			
			//If amount is too large, set to maxStackSize instead
			int amtToGive = Math.min(amount, itemInHand.getMaxStackSize());
			itemInHand.setAmount(amtToGive);

			//Continue until full amount has been disbursed
			amount -= amtToGive;
			while (amtToGive < amount)
			{
				amtToGive -= amount;
				player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(itemInHand.getTypeId(), Math.min(amtToGive, itemInHand.getMaxStackSize())));
			}
		}
	}

	/**
	 * Gives the player the specified amount of the specified item
	 * @param player The player to give items to
	 * @param itemName The partial or complete name of the item
	 * @param amount The number of items to give
	 */
	private void moar(Player player, String itemName, int amount) {
		//TODO: Do not ignore the amount parameter
		ItemStack newItem = null;
		BlockType block = BlockType.lookup(itemName);
		if (block == null)
		{
			ItemType item = ItemType.lookup(itemName);
			if (item == null)
			{
				return;
			}
			else
			{
				newItem = new ItemStack(item.getID());
				newItem.setAmount(newItem.getType().getMaxStackSize());
			}
		}
		else
		{
			newItem = new ItemStack(block.getID());
			newItem.setAmount(newItem.getType().getMaxStackSize());
		}

		//FIXME: Shouldn't use nulls in Java... but it works
		if (newItem != null)
		{
			player.getInventory().addItem(newItem);
		}
	}
}
