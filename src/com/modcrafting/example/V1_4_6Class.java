package com.modcrafting.example;

public class V1_4_6Class implements MasterInterface {
	Example plugin;
	public V1_4_6Class(Example example) {
		this.plugin=example;
	}
	
	@Override
	public void craftMethods() {
		plugin.getLogger().info("Unable to preform methods version not available.");
		return;
	}

	@Override
	public void anotherMethod() {
		plugin.getLogger().info("Unable to preform methods version not available.");
		return;
	}

}
