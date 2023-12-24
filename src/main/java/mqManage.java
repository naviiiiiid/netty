import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

/**
 * Created by n_soorani on 2023/03/22.
 */
public class mqManage {

    public static Logger logger = LogManager.getLogger(mqManage.class);

    public static ISOMsg reply(ISOMsg isoMsg ,  String bit39) throws ISOException {

        ISOMsg isoMsgRes = new ISOMsg();
        isoMsgRes.setPackager(NettyServer.packager);
        isoMsgRes.setMTI("0230");
        isoMsgRes.set(2 , isoMsg.getString(2));
        isoMsgRes.set(3 , isoMsg.getString(3));
        isoMsgRes.set(11 , isoMsg.getString(11));
        isoMsgRes.set(32 , isoMsg.getString(32));
        isoMsgRes.set(33 , isoMsg.getString(33));
        isoMsgRes.set(37 , isoMsg.getString(37));
        isoMsgRes.set(39 , bit39);
        isoMsgRes.set(41 , isoMsg.getString(41));
        return isoMsgRes;
    }

}
