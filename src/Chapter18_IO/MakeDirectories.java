package Chapter18_IO;

import java.io.File;

/**
 * File 操作 : 显示信息, 创建目录, 删除目录/文件
 * Demonstrates the use of the File class to create directories and manipulate files.
 * {Args: MakeDirectoriesTest}
 */
public class MakeDirectories {

    private static void usage() {
        System.err.println(
                "Usage : MakeDirectories path1 ...                  \n" +
                        "           Creates each path               \n\n" +
                        "Usage : MakeDirectories -d path1 ...               \n" +
                        "           Deletes each path               \n\n" +
                        "Usage : MakeDirectories -r path1 path2             \n" +
                        "           Renames from path1 to path2");
        System.exit(1);
    }

    // 显示文件信息
    private static void fileData(File f) {
        System.out.println(
                " Absolute path  : " + f.getAbsolutePath() +
                        "\n Can read     : " + f.canRead() +
                        "\n Can write    : " + f.canWrite() +
                        "\n getName      : " + f.getName() +
                        "\n getParent    : " + f.getParent() +
                        "\n getPath      : " + f.getPath() +
                        "\n length       : " + f.length() +
                        "\n lastModified : " + f.lastModified()
        );
        if (f.isFile()) {
            System.out.println("\nIt’s a file");
        } else if (f.isDirectory()) {
            System.out.println("It’s a directory");
        }
    }

    public static void main(String[] args) {

        if (args.length < 1) usage();

        // mv 文件处理
        if (args[0].equals("-r")) {

            if (args.length != 3) usage();

            File old = new File(args[1]),
                    rname = new File(args[2]);

            old.renameTo(rname);

            fileData(old);
            fileData(rname);
            return; // Exit main
        }

        int count = 0;      // 参数序号控制
        boolean del = false;  // 标志 : 是否进行删除
        if (args[0].equals("-d")) {
            count++;
            del = true;
        }
        count--;
        while (++count < args.length) {
            File f = new File(args[count]);

            if (f.exists()) {
                System.out.println(f + " exists!");
                if (del) {
                    System.out.println("deleting..." + f);
                    f.delete();
                }
            } else {  // File doesn't exist
                if (!del) {
                    f.mkdirs();
                    System.out.println("creating..." + f);
                }
            }
            fileData(f);
        }
    }
}










