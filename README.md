# Disconnect Packet Fix for Fabric
A mod for Fabric-based Minecraft servers that works around the [MC-271325](https://bugs.mojang.com/browse/MC-271325) bug. This bug frequently causes the console to be spammed with exception stacktraces, e.g.:

```
[22:35:52] [Netty Epoll Server IO #5/ERROR]: Error sending packet clientbound/minecraft:disconnect
io.netty.handler.codec.EncoderException: Sending unknown packet 'clientbound/minecraft:disconnect'
	at MC/net.minecraft.network.handler.PacketCodecDispatcher.encode(PacketCodecDispatcher.java:47) ~[server-intermediary.jar:?]
	at MC/net.minecraft.network.handler.PacketCodecDispatcher.encode(PacketCodecDispatcher.java:14) ~[server-intermediary.jar:?]
	at MC/net.minecraft.network.handler.EncoderHandler.encode(EncoderHandler.java:26) ~[server-intermediary.jar:?]
	at MC/net.minecraft.network.handler.EncoderHandler.encode(EncoderHandler.java:12) ~[server-intermediary.jar:?]
	at io.netty.handler.codec.MessageToByteEncoder.write(MessageToByteEncoder.java:107) ~[netty-codec-4.1.97.Final.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.invokeWrite0(AbstractChannelHandlerContext.java:881) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.invokeWrite(AbstractChannelHandlerContext.java:863) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:968) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:856) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.ChannelOutboundHandlerAdapter.write(ChannelOutboundHandlerAdapter.java:113) ~[netty-transport-4.1.97.Final.jar:?]
	at MC/net.minecraft.network.ClientConnection$2.write(ClientConnection.java:530) ~[server-intermediary.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.invokeWrite0(AbstractChannelHandlerContext.java:881) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.invokeWriteAndFlush(AbstractChannelHandlerContext.java:940) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:966) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.writeAndFlush(AbstractChannelHandlerContext.java:934) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.writeAndFlush(AbstractChannelHandlerContext.java:984) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.DefaultChannelPipeline.writeAndFlush(DefaultChannelPipeline.java:1025) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.AbstractChannel.writeAndFlush(AbstractChannel.java:306) ~[netty-transport-4.1.97.Final.jar:?]
	at MC/net.minecraft.network.ClientConnection.sendInternal(ClientConnection.java:350) ~[server-intermediary.jar:?]
	at MC/net.minecraft.network.ClientConnection.sendImmediately(ClientConnection.java:343) ~[server-intermediary.jar:?]
	at MC/net.minecraft.network.ClientConnection.send(ClientConnection.java:325) ~[server-intermediary.jar:?]
	at MC/net.minecraft.network.ClientConnection.sfend(ClientConnection.java:319) ~[server-intermediary.jar:?]
	at MC/net.minecraft.network.ClientConnection.exceptionCaught(ClientConnection.java:170) ~[server-intermediary.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.invokeExceptionCaught(AbstractChannelHandlerContext.java:346) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.invokeExceptionCaught(AbstractChannelHandlerContext.java:325) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.fireExceptionCaught(AbstractChannelHandlerContext.java:317) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.DefaultChannelPipeline$HeadContext.exceptionCaught(DefaultChannelPipeline.java:1377) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.invokeExceptionCaught(AbstractChannelHandlerContext.java:346) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.AbstractChannelHandlerContext.invokeExceptionCaught(AbstractChannelHandlerContext.java:325) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.DefaultChannelPipeline.fireExceptionCaught(DefaultChannelPipeline.java:907) ~[netty-transport-4.1.97.Final.jar:?]
	at io.netty.channel.epoll.AbstractEpollStreamChannel$EpollStreamUnsafe.handleReadException(AbstractEpollStreamChannel.java:728) ~[netty-transport-classes-epoll-4.1.97.Final.jar:?]
	at io.netty.channel.epoll.AbstractEpollStreamChannel$EpollStreamUnsafe.epollInReady(AbstractEpollStreamChannel.java:826) ~[netty-transport-classes-epoll-4.1.97.Final.jar:?]
	at io.netty.channel.epoll.EpollEventLoop.processReady(EpollEventLoop.java:509) ~[netty-transport-classes-epoll-4.1.97.Final.jar:?]
	at io.netty.channel.epoll.EpollEventLoop.run(EpollEventLoop.java:407) ~[netty-transport-classes-epoll-4.1.97.Final.jar:?]
	at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997) ~[netty-common-4.1.97.Final.jar:?]
	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74) ~[netty-common-4.1.97.Final.jar:?]
	at java.base/java.lang.Thread.run(Thread.java:1583) [?:?]
```

This mod serves to fix that until Mojang fixes this bug. The mod itself is extremely minimal, only using a single mixin to inject code to one method.
