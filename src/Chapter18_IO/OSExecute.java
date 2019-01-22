package Chapter18_IO;


import Fourth_util.OSExecuteException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *  进程控制
 */
public class OSExecute {
    public static void  command(String command) {
        boolean err = false;
        try {
            System.out.println("OSExecute >>>>");
            // 初始化进程
            Process process = new ProcessBuilder(command.split(" ")).start();

            // 进程输入流
            BufferedReader result = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String  s;
            while ((s = result.readLine()) != null) {
                System.out.println(s);
            }
            // 进程错误流
            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream())
            );
            while ((s = errors.readLine()) != null) {
                System.out.println(s);
                err = true;
            }
        }
        catch (Exception e) {
            if (!command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else
                throw new RuntimeException();
        }

        if (err)
            throw new OSExecuteException("Error executing " + command);
    }
}
