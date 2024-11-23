package dev.ascpixi.dpf.neoforge;

import net.neoforged.fml.common.Mod;

import dev.ascpixi.dpf.DisconnectPacketFix;

@Mod(DisconnectPacketFix.MOD_ID)
public final class DisconnectPacketFixNeoForge
{
    public DisconnectPacketFixNeoForge()
    {
        // Run our common setup.
        DisconnectPacketFix.init();
    }
}
