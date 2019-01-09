package Chapter18_IO;

import Fourth_util.Directory;
import Fourth_util.PPrint;

import java.io.File;

import static 第四版_源码_util.Print.print;

/**
 *  Directory 的测试类
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        // All directories:
        PPrint.pprint(Directory.walk(".").dirs);

        // All files beginning with ‘T’
        for(File file : Directory.local(".", "T.*"))
            print(file);
        print("----------------------");

        // All Java files beginning with ‘T’:
        for(File file : Directory.walk(".", "T.*\\.java"))
            print(file);
        print("======================");

        // Class files containing "Z" or "z":
        for(File file : Directory.walk(".",".*[Zz].*\\.class"))
            print(file);
    }
}
