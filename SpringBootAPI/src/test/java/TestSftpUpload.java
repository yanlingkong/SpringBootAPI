import com.hurongsoft.utils.sftp.SftpLogin;
import com.hurongsoft.utils.sftp.UpLoadFile;
import com.jcraft.jsch.Session;

/**
 * Created by Administrator on 2017/3/22.
 */
public class TestSftpUpload {
    public static void main(String[] args) {
        Session session = SftpLogin.login(null,null,null,null);
        System.out.println(session);
        String filePath = "F://1111111.jpg";
        String dPath = "/test";
        UpLoadFile.connect(session);
       // UpLoadFile.download(session, filePath, dPath);
    }
}
