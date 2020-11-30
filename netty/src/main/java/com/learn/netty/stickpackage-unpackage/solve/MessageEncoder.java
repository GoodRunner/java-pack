package solve;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @description: 自定义的编码器  这也是 解决粘包拆包的重要一部分
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-26 00:12
 */
public class MessageEncoder extends MessageToByteEncoder<MessageProtocol> {
  @Override
  protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
    out.writeInt(msg.getLen());
    out.writeBytes(msg.getContent());
  }
}