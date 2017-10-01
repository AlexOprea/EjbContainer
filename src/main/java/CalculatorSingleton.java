
import javax.ejb.Stateless;

@Stateless(name="Calculator")
public class CalculatorSingleton implements Calculator{
    public int add(int x, int y)
    {
        return x+y;
    }
    public int subtract(int x, int y,Minuend minuend)
    {
        switch (minuend)
        {
            case MIN_X:
                return x-y;
            case MIN_Y:
                return y-x;
                default:
                    return 0;
        }

    }

    public enum Minuend
    {
        MIN_X,MIN_Y
    };
}
