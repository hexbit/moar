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
	IRON_SHOVEL(256, "Iron Shovel", "ironshovel", "ishovel"),
	IRON_PICKAXE(257, "Iron Pickaxe", "ironpickaxe", "ipickaxe", "ironpick", "ipick"),
	IRON_AXE(258, "Iron Axe", "ironaxe", "iaxe"),
	FLINT_AND_STEEL(259, "Flint and Steel", "flint", "lighter", "flightandsteel", "flintsteel"),
	APPLE(260, "Apple", "apple"),
	BOW(261, "Bow", "bow", "arrowlauncher"),
	ARROW(262, "Arrow", "arrow", "bowammo"),
	COAL(263, "Coal", "coal"),
	WOODEN_PICKAXE(270, "Wooden Pickaxe", "woodenpickaxe", "woodpickaxe", "woodpick"),
	STONE_PICKAXE(274, "Stone Pickaxe", "stonepickaxe", "spickaxe", "stonepick", "spick"),
	DIAMOND_PICKAXE(278, "Diamond Pickaxe", "diamondpickaxe", "dpickaxe", "diamondpick", "dpick"),
	GOLD_PICKAXE(285, "Gold Pickaxe", "goldpickaxe", "gpickaxe", "goldpick", "gpick");

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
