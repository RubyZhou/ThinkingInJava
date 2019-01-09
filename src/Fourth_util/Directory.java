package Fourth_util;


import 第四版_源码_util.PPrint;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 *  所属章节 : Chapter18_IO
 *
 *  目录工具
 *
 */
public final class Directory {

    // 给出目录的 File类 和 查询的正则, 返回搜索结果的文件列表
    public static File[]    local(File dir, final String regex) {
        return
                dir.listFiles(new FilenameFilter() {
                    private Pattern pattern = Pattern.compile(regex);
                    @Override
                    public boolean accept(File dir, String name) {
                        return pattern.matcher(new File(name).getName()).matches();
                    }
                });
    }

    // 只给出文件路径时, 包装成File类再调用
    public static File[]    local(String path, final String regex)  {
        return  local(new File(path), regex);
    }

    // 内部类 : TreeInfo
    // A two-tuple for returning a pair of objects
    public static class TreeInfo implements Iterable<File> {
        public List<File>   files   = new ArrayList<File>();
        public List<File>   dirs    = new ArrayList<File>();

        // 用于遍历 List
        @Override
        public Iterator<File>   iterator() {
            return  files.iterator();
        }

        // 添加额外的 文件和目录 : 需要一个同样的 TreeInfo类
        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        public String   toString() {
            return  "dirs : "  + PPrint.pformat(dirs) + "\n\n" +
                    "files : " + PPrint.pformat(files);
        }
    }

    /*----------------------------------------------------------------*
     *                       3 种启动方式
     *----------------------------------------------------------------*/
    // 给出 start 路径, 启动 recurse Dirs
    public static TreeInfo  walk(String start, String regex) {
        return  recurseDirs(new File(start), regex);
    }

    // 直接给 File 结构, 就不需要包装了
    public static TreeInfo  walk(File start, String regex) {
        return  recurseDirs(start, regex);
    }

    // 若不传入 regex 则默认 ".*"
    public static TreeInfo  walk(String start) {
        return  recurseDirs(new File(start), ".*");
    }
    /*----------------------------------------------------------------*/

    // recurseDirs() : 列出所有 Dir,
    //      @return : TreeInfo
    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();

        for (File item : startDir.listFiles()) {

            if (item.isDirectory()) {   // 是目录的话 : 添加至目录列表, 并递归调用该目录
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else {                    // 匹配到文件, 则符合正则直接加到文件列表
                if (item.getName().matches(regex))
                    result.files.add(item);
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(walk("."));
        }
        else {
            for (String arg :
                    args) {
                System.out.println(walk(arg));
            }
        }
    }
}
