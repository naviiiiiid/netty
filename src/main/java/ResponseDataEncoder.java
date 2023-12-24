import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ResponseDataEncoder
        extends MessageToByteEncoder<String> {

    public static Logger logger = LogManager.getLogger(ResponseDataEncoder.class);

    @Override
    protected void encode(ChannelHandlerContext ctx,
                          String msg, ByteBuf out) throws Exception {
        logger.info(msg);
        out.writeBytes(msg.getBytes(Charset.forName("windows-1256")));
    }
}