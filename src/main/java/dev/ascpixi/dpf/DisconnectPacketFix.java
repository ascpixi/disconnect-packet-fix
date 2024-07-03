package dev.ascpixi.dpf;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisconnectPacketFix implements ModInitializer
{
    public static final Logger LOGGER = LoggerFactory.getLogger("disconnect-packet-fix");

	@Override
	public void onInitialize()
	{
		LOGGER.info("Disconnect Packet Fix has started.");
	}
}