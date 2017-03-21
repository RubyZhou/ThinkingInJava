package interfaces.classprocessor;
import java.util.*;
import static util.Print.*;

class Processor {
    public String name() {
	return getClass().getSimpleName();
    }
    Object process(Object input) {
	return ((String)input).toUpperCase();
    }
}
public class Apply {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}
