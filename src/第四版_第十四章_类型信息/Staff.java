package 第四版_第十四章_类型信息;

import java.util.ArrayList;

/**
 *  测试空对象 : 职工对象
 *      The Staff class can now look for Null Objects when you are filling positions
 */
public class Staff  extends ArrayList<Position>  {


    public void     add(String title, Person person)    { add(new Position(title, person));   }

    /**
     *  添加元素 : 只给职位名, 则人员设为空
     */
    public void     add(String... titles)   {   // String... titles 表示可变长度的参数列表
        for (String title : titles)
            add(new Position(title));
    }

    /**
     *  构造器 : 添加 Staff 元素
     */
    public Staff(String... titles)  { add(titles);  }


    /**
     *  查询职位是否空缺
     */
    public boolean  positionAvailable(String title) {

        // 遍历 Staff 中的 position
        for (Position position : this)
                // position 中的 title 和查询的 title 是否相等 && 人员为空
            if (position.getTitle().equals(title) && position.getPerson() == Person.NULL)   {
                return true;
            }

        return false;
    }


    /**
     * 填充空缺职位的人员信息
     */
    public void     fillPosition(String title, Person hire) {
        for (Position position : this)  {
            if (position.getTitle().equals(title) && position.getPerson() == Person.NULL) {
                position.setPerson(hire);
                return;
            }
        }
        throw new RuntimeException("Position " + title + " not available");
    }

    public static void main(String[] args) {
        Staff staff = new Staff("President",
                                    "CTO",
                                    "Marketing Manager",
                                    "Product Manager",
                                    "Project Lead",
                                    "Software Engineer",
                                    "Software Engineer",
                                    "Software Engineer",
                                    "Software Engineer",
                                    "Test Engineer",
                                    "Technical Writer"
                        );

        staff.fillPosition("President",
                new Person("Me", "Last", "The Top, Lonely At"));

        staff.fillPosition("Project Lead",
                new Person("Janet", "Planner", "The Burbs"));

        if(staff.positionAvailable("Software Engineer"))
            staff.fillPosition("Software Engineer",
                    new Person("Bob", "Coder", "Bright Light City"));

        System.out.println(staff);
    }
}
