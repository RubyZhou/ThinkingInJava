package 第四版_第十三章_字符串;


// 使用格式化输出 : System.out.format / System.out.printf

public class SimpleFormat {
        public static void main(String[] args) {
            int x = 5;
            double y = 5.332542;
            System.out.println("Row 1 : [" + x + ", " + y + "]");
            System.out.format("Row 1 : [%d, %f]\n", x, y);
            System.out.printf("Row 1 : [%d, %f]\n", x, y);
        }
}
