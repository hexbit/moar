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

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public enum ItemType {
	IRON_SHOVEL(256, "Iron Shovel", "iron shovel", "ironshovel","ishovel"),
	IRON_PICKAXE(257, "Iron Pickaxe", "iron pickaxe", "ironpickaxe", "ipickaxe", "ironpick", "ipick"),
	IRON_AXE(258, "Iron Axe", "iron axe", "ironaxe", "iaxe"),
	FLINT_AND_STEEL(259, "Flint And Steel", "flint and steel", "flint", "lighter", "flightandsteel", "flintsteel"),
	APPLE(260, "Apple", "apple", "apple"),
	BOW(261, "Bow", "bow", "arrowlauncher"),
	ARROW(262, "Arrow", "arrow", "bowammo"),
	COAL(263, "Coal", "coal", "coal"),
	DIAMOND(264, "Diamond", "diamond", "diamond"),
	IRON_INGOT(265, "Iron Ingot", "iron ingot", "ironingot"),
	GOLD_INGOT(266, "Gold Ingot", "gold ingot", "goldingot"),
	IRON_SWORD(267, "Iron Sword", "iron sword", "ironsword"),
	WOODEN_SWORD(268, "Wooden Sword", "wooden sword", "woodensword"),
	WOODEN_SHOVEL(269, "Wooden Shovel", "wooden shovel", "woodenshovel"),
	WOODEN_PICKAXE(270, "Wooden Pickaxe", "wooden pickaxe", "woodenpickaxe", "woodpickaxe", "woodpick"),
	WOODEN_AXE(271, "Wooden Axe", "wooden axe", "woodenaxe"),
	STONE_SWORD(272, "Stone Sword", "stone sword", "stonesword"),
	STONE_SHOVEL(273, "Stone Shovel", "stone shovel", "stoneshovel"),
	STONE_PICKAXE(274, "Stone Pickaxe", "stone pickaxe", "stonepickaxe", "spickaxe", "stonepick", "spick"),
	STONE_AXE(275, "Stone Axe", "stone axe", "stoneaxe"),
	DIAMOND_SWORD(276, "Diamond Sword", "diamond sword", "diamondsword"),
	DIAMOND_SHOVEL(277, "Diamond Shovel", "diamond shovel", "diamondshovel"),
	DIAMOND_PICKAXE(278, "Diamond Pickaxe", "diamond pickaxe", "diamondpickaxe", "dpickaxe", "diamondpick", "dpick"),
	DIAMOND_AXE(279, "Diamond Axe", "diamond axe", "diamondaxe"),
	STICK(280, "Stick", "stick", "stick"),
	BOWL(281, "Bowl", "bowl", "bowl"),
	MUSHROOM_SOUP(282, "Mushroom Soup", "mushroom soup", "mushroomsoup"),
	GOLD_SWORD(283, "Gold Sword", "gold sword", "goldsword"),
	GOLD_SHOVEL(284, "Gold Shovel", "gold shovel", "goldshovel"),
	GOLD_PICKAXE(285, "Gold Pickaxe", "gold pickaxe", "goldpickaxe", "gpickaxe", "goldpick", "gpick"),
	GOLD_AXE(286, "Gold Axe", "gold axe", "goldaxe"),
	STRING(287, "String", "string", "string"),
	FEATHER(288, "Feather", "feather", "feather"),
	GUNPOWDER(289, "Gunpowder", "gunpowder", "gunpowder"),
	WOODEN_HOE(290, "Wooden Hoe", "wooden hoe", "woodenhoe"),
	STONE_HOE(291, "Stone Hoe", "stone hoe", "stonehoe"),
	IRON_HOE(292, "Iron Hoe", "iron hoe", "ironhoe"),
	DIAMOND_HOE(293, "Diamond Hoe", "diamond hoe", "diamondhoe"),
	GOLD_HOE(294, "Gold Hoe", "gold hoe", "goldhoe"),
	SEEDS(295, "Seeds", "seeds", "seeds"),
	WHEAT(296, "Wheat", "wheat", "wheat"),
	BREAD(297, "Bread", "bread", "bread"),
	LEATHER_HELMET(298, "Leather Helmet", "leather helmet", "leatherhelmet"),
	LEATHER_CHESTPLATE(299, "Leather Chestplate", "leather chestplate", "leatherchestplate"),
	LEATHER_LEGGINGS(300, "Leather Leggings", "leather leggings", "leatherleggings"),
	LEATHER_BOOTS(301, "Leather Boots", "leather boots", "leatherboots"),
	CHAINMAIL_HELMET(302, "Chainmail Helmet", "chainmail helmet", "chainmailhelmet"),
	CHAINMAIL_CHESTPLATE(303, "Chainmail Chestplate", "chainmail chestplate", "chainmailchestplate"),
	CHAINMAIL_LEGGINGS(304, "Chainmail Leggings", "chainmail leggings", "chainmailleggings"),
	CHAINMAIL_BOOTS(305, "Chainmail Boots", "chainmail boots", "chainmailboots"),
	IRON_HELMET(306, "Iron Helmet", "iron helmet", "ironhelmet"),
	IRON_CHESTPLATE(307, "Iron Chestplate", "iron chestplate", "ironchestplate"),
	IRON_LEGGINGS(308, "Iron Leggings", "iron leggings", "ironleggings"),
	IRON_BOOTS(309, "Iron Boots", "iron boots", "ironboots"),
	DIAMOND_HELMET(310, "Diamond Helmet", "diamond helmet", "diamondhelmet"),
	DIAMOND_CHESTPLATE(311, "Diamond Chestplate", "diamond chestplate", "diamondchestplate"),
	DIAMOND_LEGGINGS(312, "Diamond Leggings", "diamond leggings", "diamondleggings"),
	DIAMOND_BOOTS(313, "Diamond Boots", "diamond boots", "diamondboots"),
	GOLD_HELMET(314, "Gold Helmet", "gold helmet", "goldhelmet"),
	GOLD_CHESTPLATE(315, "Gold Chestplate", "gold chestplate", "goldchestplate"),
	GOLD_LEGGINGS(316, "Gold Leggings", "gold leggings", "goldleggings"),
	GOLD_BOOTS(317, "Gold Boots", "gold boots", "goldboots"),
	FLINT(318, "Flint", "flint", "flint"),
	RAW_PORKCHOP(319, "Raw Porkchop", "raw porkchop", "rawporkchop"),
	COOKED_PORKCHOP(320, "Cooked Porkchop", "cooked porkchop", "cookedporkchop"),
	PAINTINGS(321, "Paintings", "paintings", "paintings"),
	GOLDEN_APPLE(322, "Golden Apple", "golden apple", "goldenapple"),
	SIGN(323, "Sign", "sign", "sign"),
	WOODEN_DOOR(324, "Wooden Door", "wooden door", "woodendoor"),
	BUCKET(325, "Bucket", "bucket", "bucket"),
	WATER_BUCKET(326, "Water Bucket", "water bucket", "waterbucket"),
	LAVA_BUCKET(327, "Lava Bucket", "lava bucket", "lavabucket"),
	MINECART(328, "Minecart", "minecart", "minecart"),
	SADDLE(329, "Saddle", "saddle", "saddle"),
	IRON_DOOR(330, "Iron Door", "iron door", "irondoor"),
	REDSTONE(331, "Redstone", "redstone", "redstone"),
	SNOWBALL(332, "Snowball", "snowball", "snowball"),
	BOAT(333, "Boat", "boat", "boat"),
	LEATHER(334, "Leather", "leather", "leather"),
	MILK(335, "Milk", "milk", "milk"),
	CLAY_BRICK(336, "Clay Brick", "clay brick", "claybrick"),
	CLAY_BALLS(337, "Clay Balls", "clay balls", "clayballs"),
	SUGAR_CANE(338, "Sugar Cane", "sugar cane", "sugarcane"),
	PAPER(339, "Paper", "paper", "paper"),
	BOOK(340, "Book", "book", "book"),
	SLIMEBALL(341, "Slimeball", "slimeball", "slimeball"),
	STORAGE_MINECART(342, "Storage Minecart", "storage minecart", "storageminecart"),
	POWERED_MINECART(343, "Powered Minecart", "powered minecart", "poweredminecart"),
	EGG(344, "Egg", "egg", "egg"),
	COMPASS(345, "Compass", "compass", "compass"),
	FISHING_ROD(346, "Fishing Rod", "fishing rod", "fishingrod"),
	CLOCK(347, "Clock", "clock", "clock"),
	GLOWSTONE_DUST(348, "Glowstone Dust", "glowstone dust", "glowstonedust"),
	RAW_FISH(349, "Raw Fish", "raw fish", "rawfish"),
	COOKED_FISH(350, "Cooked Fish", "cooked fish", "cookedfish"),
	DYE_D(351, "Dye D", "dye d", "dyed"),
	BONE(352, "Bone", "bone", "bone"),
	SUGAR(353, "Sugar", "sugar", "sugar"),
	CAKE(354, "Cake", "cake", "cake"),
	BED(355, "Bed", "bed", "bed"),
	REDSTONE_REPEATER(356, "Redstone Repeater", "redstone repeater", "redstonerepeater");

	/**
     * Construct the type.
     *
     * @param id
     * @param name
     */
    ItemType(int id, String name, String lookupKey) {
        this.id = id;
        this.name = name;
        this.lookupKeys = new String[]{lookupKey};
    }

    /**
     * Construct the type.
     *
     * @param id
     * @param name
     */
    ItemType(int id, String name, String ... lookupKeys) {
        this.id = id;
        this.name = name;
        this.lookupKeys = lookupKeys;
    }

    /**
     * Return type from ID. May return null.
     *
     * @param id
     * @return
     */
    public static ItemType fromID(int id) {
        return ids.get(id);
    }

    /**
     * Return type from name. May return null.
     *
     * @param name
     * @return
     */
    public static ItemType lookup(String name) {
        return lookup(name, true);
    }

    /**
     * Return type from name. May return null.
     *
     * @param name
     * @param fuzzy
     * @return
     */
    public static ItemType lookup(String name, boolean fuzzy) {
        String testName = name.replace(" ", "").toLowerCase();

        ItemType type = lookup.get(testName);

        if (type != null) {
            return type;
        }

        if (!fuzzy) {
            return null;
        }

        int minDist = -1;

        for (Entry<String, ItemType> entry : lookup.entrySet()) {
            if (entry.getKey().charAt(0) != testName.charAt(0)) {
                continue;
            }

            int dist = StringUtil.getLevenshteinDistance(entry.getKey(), testName);

            if ((dist < minDist || minDist == -1) && dist < 2) {
                minDist = dist;
                type = entry.getValue();
            }
        }

        return type;
    }

    /**
     * Get block numeric ID.
     *
     * @return
     */
    public int getID() {
        return id;
    }

    /**
     * Get user-friendly block name.
     *
     * @return
     */
    public String getName() {
        return name;
    }

	/**
     * Stores a map of the IDs for fast access.
     */
    private static final Map<Integer,ItemType> ids = new HashMap<Integer,ItemType>();
    /**
     * Stores a map of the names for fast access.
     */
    private static final Map<String,ItemType> lookup = new HashMap<String,ItemType>();

    private final int id;
    private final String name;
    private final String[] lookupKeys;

    static {
        for(ItemType type : EnumSet.allOf(ItemType.class)) {
            ids.put(type.id, type);
            for (String key : type.lookupKeys) {
                lookup.put(key, type);
            }
        }
    }
}
