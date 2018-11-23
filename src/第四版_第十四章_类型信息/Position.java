package 第四版_第十四章_类型信息;

/**
 *  测试空对象 : 工作职位
 */
public class Position {

    private String  title;
    private Person  person;

    /**
     *  构造器 : 带职位和员工
     * @param jobTitle
     * @param employee
     */
    public  Position(String jobTitle, Person employee)   {
        title  = jobTitle;
        person = employee;

        if  (person == null)    {
            person = Person.NULL;
        }
    }

    /**
     * 构造器 : 只带职位名, 员工空缺设置为 NULL
     * @param jobTitle
     */
    public  Position(String jobTitle)    {
        title  = jobTitle;
        person = Person.NULL;
    }

    // get() / set()
    public String   getTitle()                  { return title;     }
    public void     setTitle(String newTitle)   { title = newTitle; }

    public Person   getPerson()                 { return person;    }
    public void     setPerson(Person newPerson) {
        person = newPerson;
        if (person == null) { person = Person.NULL;   } // 仅需在这里测试 person 是否为空
    }

    public String   toString()  {
        return "Position : " + title + ", " + person + "\n";
    }
}
