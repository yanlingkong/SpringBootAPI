import com.hurongsoft.utils.ftp.FTPUtils;
import com.hurongsoft.utils.sftp.SftpLogin;
import com.hurongsoft.utils.sftp.UpLoadFile;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import sun.net.ftp.FtpClient;

import java.io.InputStream;

/**
 * Created by Administrator on 2017/3/22.
 */
public class TestSftpAndFtp {
    public static void main(String[] args) {
        //实现文件上传
        //1.先从ftp拿到需要上传的文件
        FtpClient ftpClient = FTPUtils.connectFTP("127.0.0.1",21,"test","123456");
        String path = "F:\\test\\20170322103935838.png";
        String ftpPath = "p2p_article/p2p_bannerlink/95570019494802875987178647910228/20170322103935838.png";
        InputStream is = null;
        try {
            is = FTPUtils.getDownload(ftpPath,ftpClient);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2.上传文件至sftp
        Session session = SftpLogin.login(null,null,null,null);
        String dPath = "/test";
        ChannelSftp sftp = UpLoadFile.connect(session);
        UpLoadFile.upload(session, is, dPath,"22222222_3.png");

    }
}
