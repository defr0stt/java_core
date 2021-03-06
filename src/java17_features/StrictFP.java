package java17_features;

// strictfp - это модификатор, введенный в java 1.2, ограничивающий
// точность вычислений с float и double по стандарту IEEE. Дело в том,
// что JVM использует всю возможную точность процессора, а она на
// разных системах разная, поэтому и результат может получиться разный.
// Данный модификатор используется в программах требующих точность
// вычислений превышающих IEEE
//
// В классе он обозначает, что все методы будут на всех системах
// возвращать вещественные числа с одинаковой точностью.
// 0.112 и 0.113 Если эти числа сравнивать с точность до сотых,
// то они будут одинаковы.

strictfp public class StrictFP
{
    private static double num1 = 10e+102;
    private static double num2 = 6e+08;
    static double calculate() {
        return num1 + num2;
    }
}