import com.hurongsoft.utils.ftp.FTPUtils;
import sun.net.ftp.FtpClient;

/**
 * Created by Administrator on 2017/3/22.
 */
public class TestFtpUpload {
    public static void main(String[] args) {
        FtpClient ftpClient = FTPUtils.connectFTP("127.0.0.1",21,"test","123456");
        String path = "F:\\test\\20170322103935838.png";
        String ftpPath = "p2p_article/p2p_bannerlink/95570019494802875987178647910228/20170322103935838.png";
        ftpPath = "/test";
        //String localFile, String ftpFile, FtpClient ftp

        FTPUtils.upload(path,ftpPath,ftpClient,"12.png");
    }
}
