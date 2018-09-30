package 第四版_第十三章_字符串;

/**
 *  String.format() 模拟 C 的 sprintf ( format 内部会自动创建 Formatter )
 */
public class DatabaseException extends Exception{

    public DatabaseException(int transcationID, int queryID, String message) {
        super(String.format("(t%d, q%d) %s", transcationID, queryID, message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3, 7, " Write failed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
