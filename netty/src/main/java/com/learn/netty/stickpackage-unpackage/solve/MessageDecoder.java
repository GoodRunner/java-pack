package solve;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-11-26 00:16
 */
public class MessageDecoder extends ByteToMessageDecoder {
  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
    // 需要将得到的二进制字节码转换成 对象 MessageProtocol
    int i = in.readInt();
    byte[] content = new byte[i];
    in.readBytes(content); //读取到字节数组中

    MessageProtocol messageProtocol = new MessageProtocol();
    messageProtocol.setLen(i);
    messageProtocol.setContent(content);

    out.add(messageProtocol);
  }
}