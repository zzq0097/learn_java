package com.zzq.learn.ago.learn.socket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyClient {
    public static void main(String[] args) throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new ChannelInboundHandler() {
                                @Override
                                public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
                                    channelHandlerContext.writeAndFlush("???");
                                }

                                @Override
                                public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

                                }

                                @Override
                                public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

                                }

                                @Override
                                public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {

                                }

                                @Override
                                public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }

                                @Override
                                public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {

                                }
                            });
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9999).sync();

            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }

    }
}
