package com.yqs112358;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.yqs112358.SuicideCommand.register;

public class SimpleSuicideMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("SimpleSuicide");

	@Override
	public void onInitialize() {

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> register(dispatcher));
		LOGGER.info("SimpleSuicide loaded.");
	}
}