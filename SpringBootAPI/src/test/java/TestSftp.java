import com.hurongsoft.utils.sftp.SftpLogin;
import com.hurongsoft.utils.sftp.UpLoadFile;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/3/22.
 */
public class TestSftp {
    public static void main(String[] args) {
       Session session = SftpLogin.login("113.108.233.40","abcdsftp","9fKYkjKH","763");
        //Session session = SftpLogin.login("sftpd.ucsmy.com","abcdsftp","3K6k2MKc","763");
        System.out.println(session);
        String filePath = "F://1111111.jpg";
        String dPath = "/dddddd/33";
        UpLoadFile.connect(session);
        //UpLoadFile.upload(session, filePath, dPath);

        File file = new File(filePath);
        //UpLoadFile.upload(file,file.getName(),dPath);

        try {
            InputStream inputStream = new FileInputStream(file);
            UpLoadFile.upload(session,inputStream,dPath,file.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String a = "{\n" +
                "    \"Data\": [\n" +
                "        {\n" +
                "            \"OrderNo\": \"FQCD201703291722240048910\",\n" +
                "            \"InstallmentList\": [\n" +
                "                {\n" +
                "                    \"RepayDate\": \"2017-03-23 00:00:00\",\n" +
                "                    \"PrincipalAmount\": 555.56,\n" +
                "                    \"InterestAmount\": 105.56,\n" +
                "                    \"ActualAmount\": 661.12,\n" +
                "                    \"OverdueAmount\": 0,\n" +
                "                    \"OverdueDays\": 7,\n" +
                "                    \"PunishAmount\": 0,\n" +
                "                    \"RemainAmount\": 0,\n" +
                "                    \"RemainPeriods\": 35,\n" +
                "                    \"BillId\": \"3c3ff14d-0b9a-4d13-aafb-333d033215b9\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"Code\": 0,\n" +
                "    \"Message\": null\n" +
                "}\n";
    }
}
