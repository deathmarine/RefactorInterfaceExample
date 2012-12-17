package com.modcrafting.example;

import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class VPreClass implements MasterInterface {
	Example plugin;
	public VPreClass(Example example) {
		this.plugin=example;
	}

	@Override
	public void craftMethods() {
		plugin.getLogger().info("Player Ping List");
		plugin.getLogger().info("----------------");
		for(Player player:plugin.getServer().getOnlinePlayers()){
			CraftPlayer cp = (CraftPlayer) player;
			int ping = cp.getHandle().ping;
			plugin.getLogger().info(player.getName()+": "+String.valueOf(ping));
		}
	}

	@Override
	public void anotherMethod() {
		plugin.getLogger().info("See above for example method.");
		return;
	}

}
