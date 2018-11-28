package 第四版_第十四章_类型信息;

import Fourth_util.Null;

import java.util.List;

public interface Robot {

    String              name();
    String              model();
    List<Operation>     operations();   // desctibes what the Robot is capable of doing.

    class Test  {
        public static void test(Robot r) {
            if (r instanceof Null)
                System.out.println("[Null Robot]");
            System.out.println();
        }
    }
}
