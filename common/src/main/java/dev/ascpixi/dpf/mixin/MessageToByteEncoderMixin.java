package dev.ascpixi.dpf.mixin;

import dev.ascpixi.dpf.DisconnectPacketFix;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MessageToByteEncoder.class)
public abstract class MessageToByteEncoderMixin
{
    @Inject(
        at = @At("HEAD"),
        method = "write(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Object;Lio/netty/channel/ChannelPromise;)V"
    )
    private void writeHeadMixin(
        ChannelHandlerContext context,
        Object message,
        ChannelPromise promise,
        CallbackInfo info
    )
    {
        DisconnectPacketFix.setEncodingContext(context);
    }

    @Inject(
        at = @At("RETURN"),
        method = "write(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Object;Lio/netty/channel/ChannelPromise;)V"
    )
    private void writeReturnMixin(
        ChannelHandlerContext context,
        Object message,
        ChannelPromise promise,
        CallbackInfo info
    )
    {
        DisconnectPacketFix.clearEncodingContext();
    }
}