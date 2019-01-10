package Fourth_util;

import java.io.File;
import java.io.IOException;

/**
 *  查找特定扩展名的文件
 */
public class ProcessFiles {

    // 策略接口 : 本例在 main 中以匿名内部类的方式实现
    public interface Strategy {
        void process(File file);
    }

    private Strategy    strategy;
    private String      ext;

    // 构造器 : strategy - 策略接口; ext - 文件后缀
    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy   = strategy;
        this.ext        = ext;
    }

    // (调度) 遍历 args, 调用 processDirectoryTree() 处理目录,
    public void     start(String args[]) {
        try {
            if (args.length == 0) {                     // <1> 未传入参数 : 从 "." 目录开始执行
                processDirectoryTree(new File("."));
            }
            else {
                for (String arg : args) {               // <2> 传入 n 个参数, 则遍历 n 个目录
                    File fileArg = new File(arg);

                    if (fileArg.isDirectory()) {            // <2.1> arg参数为目录 : 直接调用 processDirectoryTree() 执行
                        processDirectoryTree(fileArg);
                    }
                    else {
                        if ( !arg.endsWith("." + ext) ) {   // <2.2> arg参数为文件 : 如果不是 .${ext} 结尾, 加上 .${ext} 后调用 process() 进行 print
                            arg += "." + ext;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                } // END : for
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }   // END : try
    }

    // (控制逻辑) 处理目录 : 调用 Directory 类遍历目录找到 .${ext} 结尾的文件, 找到则调用 process
    // canonical - adj.标准的
    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsoluteFile(), ".*\\." + ext))
            strategy.process(file.getCanonicalFile());
    }

    public static void main(String[] args) {


        new ProcessFiles(
                new ProcessFiles.Strategy() {   // 参数1 - 策略接口的实现 : 来一个 file 不做判断直接显示 (执行逻辑)
                    public void process(File file)  { System.out.println(file); }
                },
                "java"  // 参数2 - 后缀名设为 "java"
        ).start(args); // 调用 .start 启动
    }
}