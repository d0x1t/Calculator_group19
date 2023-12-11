package Entity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class OperationComplexNumberTest {

    public OperationComplexNumberTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }
  // test Add
    @Test
    public void testAddTA01() {
        System.out.println("add TA01");
        OperationComplexNumber cn1 = new OperationComplexNumber(1.0, 2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(3.0, 4.0);

        OperationComplexNumber expResult = new OperationComplexNumber(4.0, 6.0);
        OperationComplexNumber result = cn1.add(cn2);

        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }
    @Test
    public void testAddTA02() {
        System.out.println("add TA02");
        OperationComplexNumber cn1 = new OperationComplexNumber(1.0, 2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(3.0, -4.0);

        OperationComplexNumber expResult = new OperationComplexNumber(4.0, -2.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA03() {
        System.out.println("add TA03");
        OperationComplexNumber cn1 = new OperationComplexNumber(1.0, 2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(-3.0, 4.0);

        OperationComplexNumber expResult = new OperationComplexNumber(-2.0, 6.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA04() {
        System.out.println("add TA04");
        OperationComplexNumber cn1 = new OperationComplexNumber(1.0, 2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(-3.0, -4.0);

        OperationComplexNumber expResult = new OperationComplexNumber(-2.0, -2.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA05() {
        System.out.println("add TA05");

        OperationComplexNumber cn1 = new OperationComplexNumber(1.0, -2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(3.0, 4.0);
        OperationComplexNumber expResult = new OperationComplexNumber(4.0, 2.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA06() {
        System.out.println("add TA06");

        OperationComplexNumber cn1 = new OperationComplexNumber(1.0, -2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(3.0, -4.0);
        OperationComplexNumber expResult = new OperationComplexNumber(4.0, -6.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA07() {
        System.out.println("add TA07");

        OperationComplexNumber cn1 = new OperationComplexNumber(1.0, -2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(-3.0, 4.0);
        OperationComplexNumber expResult = new OperationComplexNumber(-2.0, 2.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA08() {
        System.out.println("add TA08");

        OperationComplexNumber cn1 = new OperationComplexNumber(1.0, -2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(-3.0, -4.0);
        OperationComplexNumber expResult = new OperationComplexNumber(-2.0, -6.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA09() {
        System.out.println("add TA09");
        OperationComplexNumber cn1 = new OperationComplexNumber(-1.0, 2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(3.0, 4.0);
        OperationComplexNumber expResult = new OperationComplexNumber(2.0, 6.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA10() {
        System.out.println("add TA10");

        OperationComplexNumber cn1 = new OperationComplexNumber(-1.0, 2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(3.0, -4.0);
        OperationComplexNumber expResult = new OperationComplexNumber(2.0, -2.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA11() {
        System.out.println("add TA11");

        OperationComplexNumber cn1 = new OperationComplexNumber(-1.0, 2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(-3.0, 4.0);
        OperationComplexNumber expResult = new OperationComplexNumber(-4.0, 6.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA12() {
        System.out.println("add TA12");

        OperationComplexNumber cn1 = new OperationComplexNumber(-1.0, 2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(-3.0, -4.0);
        OperationComplexNumber expResult = new OperationComplexNumber(-4.0, -2.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA13() {
        System.out.println("add TA13");
        OperationComplexNumber cn1 = new OperationComplexNumber(-1.0, -2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(3.0, 4.0);
        OperationComplexNumber expResult = new OperationComplexNumber(2.0, 2.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA14() {
        System.out.println("add TA14");
        OperationComplexNumber cn1 = new OperationComplexNumber(-1.0, -2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(3.0, -4.0);
        OperationComplexNumber expResult = new OperationComplexNumber(2.0, -6.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA15() {
        System.out.println("add TA15");
        OperationComplexNumber cn1 = new OperationComplexNumber(-1.0, -2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(-3.0, 4.0);

        OperationComplexNumber expResult = new OperationComplexNumber(-4.0, 2.0);
        OperationComplexNumber result = cn1.add(cn2);

        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
        cn1 = new OperationComplexNumber(1.0, 2.0);
    }

    @Test
    public void testAddTA16() {
        System.out.println("add TA16");
        OperationComplexNumber cn1 = new OperationComplexNumber(1.0, 2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(3.0, 4.0);

        OperationComplexNumber expResult = new OperationComplexNumber(4.0, 6.0);
        OperationComplexNumber result = cn1.add(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testAddTA17() {
        System.out.println("add TA17");

        OperationComplexNumber cn1 = new OperationComplexNumber(-1.0, -2.0); //primo numero
        OperationComplexNumber cn2 = new OperationComplexNumber(-3.0, -4.0); //secondo numero
        //    //copia del primo numero
        OperationComplexNumber expResult = new OperationComplexNumber(-4.0, -6.0); //risultato dell add
        OperationComplexNumber result = cn1.add(cn2); //testo il nu
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    public void testAddTA18() {
        System.out.println("add TA18");
        OperationComplexNumber cn1 = new OperationComplexNumber(0.0, 0.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(0.0, 0.0);
        OperationComplexNumber result = cn1.add(cn2);
        OperationComplexNumber expResult = new OperationComplexNumber(0.0, 0.0);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    // test Subtract
    @Test
    public void testSubtractTS01() {
        System.out.println("testSubstractTS01");
        OperationComplexNumber cn1 = new OperationComplexNumber(5.0, 6.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(3.0, 4.0);
        OperationComplexNumber expResult = new OperationComplexNumber(2.0, 2.0);
        OperationComplexNumber result = cn1.subtract(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    @Test
    public void testSubtractTS02() {
        System.out.println("testSubstractTS02");
        OperationComplexNumber cn1 = new OperationComplexNumber(0.0, 0.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(3.0, 4.0);
        OperationComplexNumber expResult = new OperationComplexNumber(-3.0, -4.0);
        OperationComplexNumber result = cn1.subtract(cn2);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);
    }

    // Tests  multiply 
    @Test
    public void testMultiplyTM01() {
        System.out.println("testMultiplyTM01");
        OperationComplexNumber cn1 = new OperationComplexNumber(1.0, 2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(3.0, 4.0);
        OperationComplexNumber result = cn1.multiply(cn2);
        assertEquals(-5.0, result.getReal(), 0.0001);
        assertEquals(10.0, result.getImaginary(), 0.0001);
    }

    @Test
    public void testMultiplyTM02() {
        System.out.println("testMultiplyTM02");
        OperationComplexNumber cn1 = new OperationComplexNumber(-1.0, -2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(-3.0, -4.0);
        OperationComplexNumber result = cn1.multiply(cn2);
        assertEquals(-5.0, result.getReal(), 0.0001);
        assertEquals(10.0, result.getImaginary(), 0.0001);
    }

    @Test
    public void testMultiplyTM03() {
        System.out.println("testMultiplyTM03");
        OperationComplexNumber cn1 = new OperationComplexNumber(0.0, 0.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(1.0, 2.0);
        OperationComplexNumber result = cn1.multiply(cn2);
        assertEquals(0.0, result.getReal(), 0.0001);
        assertEquals(0.0, result.getImaginary(), 0.0001);
    }
 //Test divide 
    @Test
    public void testDivideTD01() {
        System.out.println("testDivideTD01");
        OperationComplexNumber cn1 = new OperationComplexNumber(1.0, 2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(3.0, 4.0);
        OperationComplexNumber result = cn1.divide(cn2);
        assertEquals(0.44, result.getReal(), 0.01);
        assertEquals(0.08, result.getImaginary(), 0.01);
    }

    @Test
    public void testDivideTD02() {
        System.out.println("testDivideTD02");
        OperationComplexNumber cn1 = new OperationComplexNumber(0.0, 2.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(0.0, 4.0);
        OperationComplexNumber result = cn1.divide(cn2);
        assertEquals(0.500000, result.getReal(), 0.01);
        assertEquals(0.0, result.getImaginary(), 0.01);
    }

    @Test
    public void testDivideTD03() {
        System.out.println("testDivideTD03");
        OperationComplexNumber cn1 = new OperationComplexNumber(10.0, -3.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(0.0, 4.0);
        OperationComplexNumber result = cn1.divide(cn2);
        assertEquals(-0.750000, result.getReal(), 0.01);
        assertEquals(-2.500000, result.getImaginary(), 0.01);
    }

    @Test
    public void testDivideTD04() {
        System.out.println("testDivideTD04");
        OperationComplexNumber cn1 = new OperationComplexNumber(-7.0, 0.0);
        OperationComplexNumber cn2 = new OperationComplexNumber(0.0, 4.0);
        OperationComplexNumber result = cn1.divide(cn2);
        assertEquals(0.000000, result.getReal(), 0.01);
        assertEquals(1.750000, result.getImaginary(), 0.01);
    }

    @Test
    public void testDivideTD05() {
        System.out.println("testDivideTD05");
        OperationComplexNumber cn1 = new OperationComplexNumber(-0.75, -1.5);
        OperationComplexNumber cn2 = new OperationComplexNumber(0.0, -4);
        OperationComplexNumber result = cn1.divide(cn2);
        assertEquals(0.375000, result.getReal(), 0.01);
        assertEquals(-0.187500, result.getImaginary(), 0.01);
    }
// test inverse
    @Test
    public void testInverseTI01() {
        System.out.println("testInverseTI01");
        OperationComplexNumber cn = new OperationComplexNumber(1.0, 2.0);
        OperationComplexNumber result = cn.inverse();
        assertEquals(-1.0, result.getReal(), 0.001);
        assertEquals(-2.0, result.getImaginary(), 0.001);
    }

    @Test
    public void testInverseTI02() {
        System.out.println("testInverseTI02");
        OperationComplexNumber cn = new OperationComplexNumber(0.0, 0.0);
        OperationComplexNumber result = cn.inverse();
        assertEquals(0.0, result.getReal(), 0.001);
        assertEquals(0.0, result.getImaginary(), 0.001);
    }
// test SQRT
    @Test
    public void testSQRTTR01() {
        System.out.println("sqrt TR01");
        OperationComplexNumber cn1 = new OperationComplexNumber(1.0, 1.0);
        OperationComplexNumber result = cn1.sqrt();
        OperationComplexNumber expResult = new OperationComplexNumber(1.09868, 0.45509);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);

    }

    @Test
    public void testSQRTTR02() {
        System.out.println("sqrt TR02");
        OperationComplexNumber cn1 = new OperationComplexNumber(1.0, -1.0);
        OperationComplexNumber result = cn1.sqrt();
        OperationComplexNumber expResult = new OperationComplexNumber(1.09868, -0.45509);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);

    }

    @Test
    public void testSQRTTR03() {
        System.out.println("sqrt TR03");
        OperationComplexNumber cn1 = new OperationComplexNumber(-1.0, 1.0);
        OperationComplexNumber result = cn1.sqrt();
        OperationComplexNumber expResult = new OperationComplexNumber(0.45509, 1.09868);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);

    }

    @Test
    public void testSQRTTR04() {
        System.out.println("sqrt TR04");
        OperationComplexNumber cn1 = new OperationComplexNumber(-1.0, -1.0);
        OperationComplexNumber result = cn1.sqrt();
        OperationComplexNumber expResult = new OperationComplexNumber(0.45509, -1.09868);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);

    }

    @Test
    public void testSQRTTR05() {
        System.out.println("sqrt TR05");
        OperationComplexNumber cn1 = new OperationComplexNumber(0.0, 2.0);
        OperationComplexNumber result = cn1.sqrt();
        OperationComplexNumber expResult = new OperationComplexNumber(1, 1);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);

    }

    @Test
    public void testSQRTTR06() {
        System.out.println("sqrt TR06");
        OperationComplexNumber cn1 = new OperationComplexNumber(0.0, -2.0);
        OperationComplexNumber result = cn1.sqrt();
        OperationComplexNumber expResult = new OperationComplexNumber(1, -1);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);

    }

    @Test
    public void testSQRTTR07() {
        System.out.println("sqrt TR07");
        OperationComplexNumber cn1 = new OperationComplexNumber(2.0, 0.0);
        OperationComplexNumber result = cn1.sqrt();
        OperationComplexNumber expResult = new OperationComplexNumber(1.41421, 0.0);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);

    }

    @Test
    public void testSQRTTR08() {
        System.out.println("sqrt TR08");
        OperationComplexNumber cn1 = new OperationComplexNumber(-2.0, 0.0);
        OperationComplexNumber result = cn1.sqrt();
        OperationComplexNumber expResult = new OperationComplexNumber(0.0, 1.41421);
        assertEquals(expResult.getReal(), result.getReal(), 0.0001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.0001);

    }
}
