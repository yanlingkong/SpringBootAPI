import com.hurongsoft.utils.ftp.FTPUtils;
import sun.net.ftp.FtpClient;

/**
 * Created by Administrator on 2017/3/22.
 */
public class TestFtp {
    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 21;
        String user = "test";
        String password = "123456";
        String path = "F:\\test\\20170322103935838.png";
        String ftpPath = "p2p_article/p2p_bannerlink/95570019494802875987178647910228/20170322103935838.png";
       // FTPUtils.downloadFileFtp(ip,port,user,password,path);
        FtpClient ftpClient = FTPUtils.connectFTP(ip,port,user,password);
        FTPUtils.download(path,ftpPath,ftpClient);
    }
}
