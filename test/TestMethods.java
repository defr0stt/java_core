import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

// added libraries to project (junit, hamcrest-all)
// in a case of MVN project - dependency
// test methods NOT static
public class TestMethods {
    @Test
    public void testCalculatorAdd(){
        Assert.assertEquals(15,Calculator.add(10,5));
    }

    @Test
    public void testCalculatorSubs(){
        Assert.assertEquals(5,Calculator.substract(10,5));
    }

    @Test
    public void testCalculatorMultiply(){
        Assert.assertEquals(50,Calculator.multiply(10,5));
    }

    @Test
    public void testCalculatorDivide(){
        Assert.assertEquals(2,Calculator.divide(10,5));
    }

    // @Before = before test
    // @After = after test

    //              -- Mockito --
    // Mockito idea = return value we define by ourselves

    @Mock
    int a = 10, b = 5;
    // MockitoAnnotations.initMocks(this) = in methods to mock

    @Test
    public void testMockitoCalculatorAdd(){
        given(Calculator.add(a,b)).willReturn(15);
        boolean isTrue = Calculator.add(a, b) == 15;
        assertThat(isTrue).isTrue();
    }
}
