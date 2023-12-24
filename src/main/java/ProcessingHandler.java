import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProcessingHandler extends ChannelInboundHandlerAdapter {


    public static Logger logger = LogManager.getLogger(ProcessingHandler.class);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
             {

        logger.info(msg);
        String requestData = (String) msg;
        ChannelFuture future = ctx.writeAndFlush(requestData);
        future.addListener(ChannelFutureListener.CLOSE);
        System.out.println(requestData);
    }
}