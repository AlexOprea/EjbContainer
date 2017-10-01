import javax.ejb.Local;

@Local
public interface Calculator {
    int add(int x, int y);
    int subtract(int x, int y, CalculatorSingleton.Minuend minuend);
}
