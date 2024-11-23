package dev.ascpixi.dpf.fabric;

import net.fabricmc.api.ModInitializer;

import dev.ascpixi.dpf.DisconnectPacketFix;

public final class DisconnectPacketFixFabric implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        DisconnectPacketFix.init();
    }
}
