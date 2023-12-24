import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jpos.iso.ISOMsg;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class RequestDecoder extends ReplayingDecoder<String> {


    public static Logger logger = LogManager.getLogger(RequestDecoder.class);

    private final Charset charset = Charset.forName("windows-1256");

    @Override
    protected void decode(ChannelHandlerContext ctx,
                          ByteBuf in, List<Object> out) throws Exception {

         String inputString =   in.readCharSequence(4, charset).toString();
         int len = Integer.parseInt(inputString);
         String message = in.readCharSequence(len , charset).toString();

        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(NettyServer.packager);
        isoMsg.unpack(message.getBytes());

        ISOMsg replyISO = mqManage.reply(isoMsg, "00");
        String isoReplaySuccess = new String(replyISO.pack());
        isoReplaySuccess = Utility.LPad(String.valueOf(isoReplaySuccess.length()) , 4 , '0') + isoReplaySuccess;

        logger.info("iso message [" + isoReplaySuccess+"]");

        out.add(isoReplaySuccess);
    }
}