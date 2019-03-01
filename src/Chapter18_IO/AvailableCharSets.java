package Chapter18_IO;


import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

import static Fourth_util.Print.printnb;

/**
 * Charset 类 : 将数据编码成不同类型的字符集的一个工具
 */
public class AvailableCharSets {

    public static void main(String[] args) {

        SortedMap<String, Charset> charSets = Charset.availableCharsets();
        Iterator<String> it = charSets.keySet().iterator();

        while (it.hasNext()) {
            String csName = it.next();
            printnb(csName);
            Iterator aliases = charSets.get(csName).aliases().iterator();

            if (aliases.hasNext()) {
                printnb(": ");
            }

            while (aliases.hasNext()) {
                printnb(aliases.next());
                if (aliases.hasNext()) {
                    printnb(", \n");
                }
            }
        }
    }
}
