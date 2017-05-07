/**
 * 
 */
package interfaces;
/**
 * 内容	：
 * 说明	：
 * 作者	：zhouyf
 * 日期	：
 * 
 */

/**
 * @author Administrator
 *
 */
import java.util.*;

public interface RandVals {
    Random RAND = new Random(47);
    int RANDOM_INT = RAND.nextInt(10);
    long RANDOM_LONG = RAND.nextLong() * 10;
    float RANDOM_FLOAT = RAND.nextFloat() * 10;
    double RANDOM_DOUBLE = RAND.nextDouble() * 10;
}
