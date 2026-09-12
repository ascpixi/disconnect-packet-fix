package dev.ascpixi.dpf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;

public final class DisconnectPacketFix
{
    public static final Logger LOGGER = LoggerFactory.getLogger("disconnect-packet-fix");

    private static final ThreadLocal<ChannelHandlerContext> ENCODING_CONTEXT =
        new ThreadLocal<>();

    public static void setEncodingContext(ChannelHandlerContext context)
    {
        ENCODING_CONTEXT.set(context);
    }

    public static ChannelHandlerContext getEncodingContext()
    {
        return ENCODING_CONTEXT.get();
    }

    public static void clearEncodingContext()
    {
        ENCODING_CONTEXT.remove();
    }

    public static void init()
    {
        LOGGER.info("Disconnect Packet Fix has started.");
    }
}
