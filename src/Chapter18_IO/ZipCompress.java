package Chapter18_IO;


import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

import static Fourth_util.Print.print;

/**
 * 使用 Zip 进行多个文件保存
 */
public class ZipCompress {
    public static void main(String[] args) throws IOException {

        FileOutputStream     f    = new FileOutputStream("src\\Chapter18_IO\\test.zip");
        CheckedOutputStream  csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream      zos  = new ZipOutputStream(csum);
        BufferedOutputStream out  = new BufferedOutputStream(zos);

        zos.setComment("A test of JAVA Zipping");

        for (String arg : args) {
            print("Writing file " + arg);

            BufferedReader  in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));

            int c;
            while ((c = in.read()) != -1)
                out.write(c);

            in.close();
            out.flush();
        }
        out.close();

        // Checksum valid only after the file has been closed!
        print("Checksum : " + csum.getChecksum().getValue());


        print("----------------------------------------------------------");
        print("Reading file");
        FileInputStream     fi    = new FileInputStream("src\\Chapter18_IO\\test.zip");
        CheckedInputStream  csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream      in2   = new ZipInputStream(csumi);
        BufferedInputStream bis   = new BufferedInputStream(in2);
        ZipEntry ze;

        while ((ze = in2.getNextEntry()) != null) {
            print("Reading file " + ze);
            int x;
            while ((x = bis.read()) != -1)
                System.out.write(x);
        }

        if (args.length == 1) {
            print("Checksum : " + csumi.getChecksum().getValue());
        }
        bis.close();

        ZipFile     zf = new ZipFile("src\\Chapter18_IO\\test.zip");
        Enumeration e  = zf.entries();

        while (e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry) e.nextElement();
            print("File : " + ze2);
        }
    }
}
