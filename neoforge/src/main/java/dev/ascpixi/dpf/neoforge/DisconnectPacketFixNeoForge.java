package dev.ascpixi.dpf.neoforge;

import net.neoforged.fml.common.Mod;

import dev.ascpixi.dpf.DisconnectPacketFix;

@Mod("disconnect_packet_fix")
public final class DisconnectPacketFixNeoForge
{
    public DisconnectPacketFixNeoForge()
    {
        // Run our common setup.
        DisconnectPacketFix.init();
    }
}
