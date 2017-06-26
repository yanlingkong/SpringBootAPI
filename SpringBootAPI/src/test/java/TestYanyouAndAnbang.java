import com.hurongsoft.utils.ftp.FTPUtils;
import com.hurongsoft.utils.sftp.SftpLogin;
import com.hurongsoft.utils.sftp.UpLoadFile;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import sun.net.ftp.FtpClient;

import java.io.InputStream;

/**
 * Created by Administrator on 2017/4/5.
 */

public class TestYanyouAndAnbang {
    public static void main(String[] args) {
        String json ="{}";
        //uploadPath=test/22222222_3.png
        Session session = SftpLogin.login("113.108.233.40","abcdsftp","9fKYkjKH","763");
        String dPath = "/test";
        String uploadPath = "test/22222222_3.png";
        String savePath = "11/22/33";
        try {
            ChannelSftp sftp = UpLoadFile.connect(session);
            InputStream input = UpLoadFile.getStreamDownload(uploadPath,sftp);
            if (input != null){
                FtpClient ftpClient = FTPUtils.connectFTP("127.0.0.1",21,"yyq123","123456");
                FTPUtils.upload(input,savePath,ftpClient,"22222222_3.png");
                json = "{\"success\":true,\"msg\""+savePath+"}";
                System.out.println(json);
            }else{
                System.out.println("该文件不存在");
                json = "{\"success\":false,\"msg\":\"上传失败\"}";
            }
        } catch (Exception e) {
            json = "{\"success\":false,\"msg\":\"下载失败\"}";
           e.printStackTrace();
        }
    }
}
