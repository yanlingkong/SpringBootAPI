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
public class TestTTUpload {
    public static void main(String[] args) {
        //2.上传文件至sftp
        Session session = SftpLogin.login("113.108.233.40","abcdsftp","9fKYkjKH","763");
        ChannelSftp sftp = UpLoadFile.connect(session);
        //InputStream input = UpLoadFile.getStreamDownload("test/22222222_3.png",sftp);
        InputStream input = null;
        try {
            input = UpLoadFile.getStreamDownload("车贷审核资料/14883c49-7a33-4bd7-aa73-5c5df92f4b15.doc",sftp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(input);


        FtpClient ftpClient = FTPUtils.connectFTP("127.0.0.1",21,"test","123456");
        FTPUtils.upload(input,"test",ftpClient,"1111.doc");

        /*byte[] bytes = new byte[1024];
        int index=0;
        try {
            FileOutputStream downloadFile = new FileOutputStream("F:/test/22222222_4.png");
            while ((index = input.read(bytes)) != -1) {
                downloadFile.write(bytes, 0, index);
                downloadFile.flush();
            }
            downloadFile.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
