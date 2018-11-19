package 第四版_第十四章_类型信息.factory;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part {
    /**
     * part I :
     *      设定 toString() : 打印类名
     *
     * @return
     */
    public String toString() {
        return getClass().getSimpleName();
    }


    /**
     *  part II : 静态加载的 List ：
     *      a. 元素继承 Factory 接口 : 即需要有一个 create()
     *      b. Factory 接口         : 接受任意类型, 这里规定他继承自 Part
     */
    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();

    /**
     *  part III : 向静态 List[] partFactories 中添加数据, 加载各个工厂的实例
     *
     */
    static {
        // 这里不用 Collections.addAll() 原因 : Collections.addAll() gives an "unchecked generic array creation ... for varargs parameter" warning.
        partFactories.add(  new FuelFilter.Factory()          );
        partFactories.add(  new AirFilter.Factory()           );
        partFactories.add(  new CabinAirFilter.Factory()      );
        partFactories.add(  new OilFilter.Factory()           );
        partFactories.add(  new FanBelt.Factory()             );
        partFactories.add(  new PowerSteeringBelt.Factory()   );
        partFactories.add(  new GeneratorBelt.Factory()       );
    }

    /**
     *  part IV : 随机调用静态 List 中的元素进行 create()
     */
    private static Random rand = new Random(47);
    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return  partFactories.get(n).create();
    }
}


/**
 *  过滤器
 */
class Filter extends Part { }


/**
 *  燃料过滤器
 */
class FuelFilter extends Filter {

    // 内部 Factory 类 ：
    //      这个内部 Factory 类继承自外部的 "第四版_第十四章_类型信息.factory.Factory" 接口
    public static class Factory implements 第四版_第十四章_类型信息.factory.Factory<FuelFilter> {

        public FuelFilter create()  { return new FuelFilter();   }
    }
}

/**
 *  空气过滤器
 */
class AirFilter extends Filter {
    public static class Factory
            implements 第四版_第十四章_类型信息.factory.Factory<AirFilter> {

        public AirFilter create() { return new AirFilter(); }
    }
}

/**
 *  飞机客舱的空气过滤器
 */
class CabinAirFilter extends Filter {
    public static class Factory
            implements 第四版_第十四章_类型信息.factory.Factory<CabinAirFilter> {

        public CabinAirFilter create() { return new CabinAirFilter();   }
    }
}

/**
 *  机油过滤器
 */
class OilFilter extends Filter {
    public static class Factory
            implements 第四版_第十四章_类型信息.factory.Factory<OilFilter> {

        public OilFilter create() { return new OilFilter(); }
    }
}

/**
 *  带子
 */
class Belt extends Part {}

/**
 *  风扇皮带
 */
class FanBelt extends Belt {
    public static class Factory
            implements 第四版_第十四章_类型信息.factory.Factory<FanBelt> {

        public FanBelt create() { return new FanBelt(); }
    }
}

/**
 *  发电机皮带
 */
class GeneratorBelt extends Belt {
    public static class Factory
            implements 第四版_第十四章_类型信息.factory.Factory<GeneratorBelt> {

        public GeneratorBelt create() { return new GeneratorBelt(); }
    }
}

/**
 *  动力转向带
 */
class PowerSteeringBelt extends Belt {
    public static class Factory
            implements 第四版_第十四章_类型信息.factory.Factory<PowerSteeringBelt> {

        public PowerSteeringBelt create() { return new PowerSteeringBelt(); }
    }
}

public class RegisteredFactories {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
}
