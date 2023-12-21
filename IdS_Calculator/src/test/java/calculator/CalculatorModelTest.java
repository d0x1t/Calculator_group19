/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import calculator.Entity.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ACER
 */
public class CalculatorModelTest {

    Stack stack = new Stack(null);

    BufferVariable bufVariable = new BufferVariable(null);

    CalculatorView view = new CalculatorView();
    CalculatorController controller = new CalculatorController();

    CalculatorModel model = new CalculatorModel(stack, bufVariable, controller);

    @Test
    public void testIsValidComplexNumberTN01() {
        assertTrue(model.isValidComplexNumber("3+4j"), "Valid complex number with positive real and imaginary parts");
    }

    @Test
    public void testIsValidComplexNumberTN02() {
        assertTrue(model.isValidComplexNumber("-2.5 - 1.7j"), "Valid complex number with negative real and imaginary parts");
    }

    @Test
    public void testIsValidComplexNumberTN03() {
        assertTrue(model.isValidComplexNumber("5j"), "Valid complex number with positive imaginary part and zero real part");
    }

    @Test
    public void testIsValidComplexNumberTN04() {
        assertTrue(model.isValidComplexNumber("7"), "Valid complex number with positive real part and zero imaginary part");
    }

    @Test
    public void testIsValidComplexNumberTN05() {
        assertFalse(model.isValidComplexNumber("invalid"), "Invalid complex number");
    }

    @Test
    public void testIsValidComplexNumberTN06() {
        assertTrue(model.isValidComplexNumber("0 + 4j"), "Valid complex number with positive imaginary part and zero real part (separated)");
    }

    @Test
    public void testIsValidComplexNumberTN07() {
        assertTrue(model.isValidComplexNumber("-3.6"), "Valid complex number with negative real part and zero imaginary part");
    }

    @Test
    public void testIsValidComplexNumberTN08() {
        assertTrue(model.isValidComplexNumber("0 - 2j"), "Valid complex number with negative imaginary part and zero real part (separated)");
    }

    @Test
    public void testIsValidComplexNumberTN09() {
        assertTrue(model.isValidComplexNumber("-1.2 + 0j"), "Valid complex number with negative real part and zero imaginary part (separated)");
    }

    @Test
    public void testIsValidComplexNumberTN10() {
        assertTrue(model.isValidComplexNumber("-1.5 - 2.5j"), "Valid complex number with negative real and imaginary parts (separated)");
    }

    @Test
    public void testIsValidComplexNumberTN11() {
        assertTrue(model.isValidComplexNumber("+5.5 - 1.2j"), "Valid complex number with positive real and negative imaginary parts (separated)");
    }

    @Test
    public void testIsValidComplexNumberTN12() {
        assertTrue(model.isValidComplexNumber("-4.2 + 3.8j"), "Valid complex number with negative real and positive imaginary parts (separated)");
    }

    @Test
    public void testIsValidComplexNumberTN13() {
        assertTrue(model.isValidComplexNumber("0 + 0j"), "Valid complex number with negative real and positive imaginary parts (separated)");
    }

    @Test
    public void testIsValidVariableTV01() {
        assertTrue(model.isValidVariable("<a"));
    }

    @Test
    public void testIsValidVariableTV02() {
        assertTrue(model.isValidVariable(">b"));
    }

    @Test
    public void testIsValidVariableTV03() {
        assertTrue(model.isValidVariable("+c"));
    }

    @Test
    public void testIsValidVariableTV04() {
        assertTrue(model.isValidVariable("-z"));
    }

    @Test
    public void testIsValidVariableTV05() {
        assertFalse(model.isValidVariable(null));
    }

    @Test
    public void testIsValidVariableTV06() {
        assertFalse(model.isValidVariable(""));
    }

    @Test
    public void testIsValidVariableTV07() {
        assertFalse(model.isValidVariable(" "));
    }

    @Test
    public void testIsValidVariableTV08() {
        assertFalse(model.isValidVariable("<1"));
    }

    @Test
    public void testIsValidVariableTV09() {
        assertTrue(model.isValidVariable(">A"));
    }

    @Test
    public void testIsValidVariableTV10() {
        assertFalse(model.isValidVariable("+"));
    }

    @Test
    public void testIsValidVariableTV11() {
        assertFalse(model.isValidVariable("-"));
    }

    @Test
    public void testIsValidVariableTV12() {
        assertFalse(model.isValidVariable("<ab"));
    }

    @Test
    public void testIsValidVariableTV13() {
        assertFalse(model.isValidVariable("<>"));
    }

    @Test
    public void testIsValidVariableTV14() {
        assertFalse(model.isValidVariable("++"));
    }

    @Test
    public void testIsValidVariableTV15() {
        assertFalse(model.isValidVariable("--"));
    }

    @Test
    public void testIsValidVariableTV16() {
        assertFalse(model.isValidVariable("÷"));
    }

    @Test
    public void testIsValidVariableTV17() {
        assertFalse(model.isValidVariable("×"));
    }

    @Test
    public void testIsValidVariableTV18() {
        assertFalse(model.isValidVariable("<+"));
    }

    @Test
    public void testIsValidVariableTV19() {
        assertFalse(model.isValidVariable(">-"));
    }

    @Test
    public void testIsValidVariableTV20() {
        assertFalse(model.isValidVariable("<÷"));
    }

    @Test
    public void testIsValidVariableTV21() {
        assertFalse(model.isValidVariable(">×"));
    }

    @Test
    public void testIsValidVariableTV22() {
        assertFalse(model.isValidVariable("<+-5"));
    }

    @Test
    public void testIsValidVariableTV23() {
        assertFalse(model.isValidVariable(">+-1"));
    }

    @Test
    public void testIsValidVariableTV24() {
        assertFalse(model.isValidVariable("<a1"));
    }

    @Test
    public void testIsValidVariableTV25() {
        assertFalse(model.isValidVariable(">a1"));
    }

    @Test
    public void testIsValidOperatorTO01() {
        assertTrue(model.isValidOperator("+"));
    }

    @Test
    public void testIsValidOperatorTO02() {
        assertTrue(model.isValidOperator("-"));
    }

    @Test
    public void testIsValidOperatorTO03() {
        assertTrue(model.isValidOperator("×"));
    }

    @Test
    public void testIsValidOperatorTO04() {
        assertTrue(model.isValidOperator("÷"));
    }

    @Test
    public void testIsValidOperatorTO05() {
        assertTrue(model.isValidOperator("√"));
    }

    @Test
    public void testIsValidOperatorTO06() {
        assertTrue(model.isValidOperator("+/-"));
    }

    @Test
    public void testIsValidOperatorTO07() {
        assertFalse(model.isValidOperator("-/+"));
    }

    @Test
    public void testIsValidOperatorTO08() {
        assertFalse(model.isValidOperator("+\\-"));
    }

    @Test
    public void testIsValidOperatorTO09() {
        assertFalse(model.isValidOperator("sqrt"));
    }

    @Test
    public void testIsValidOperatorTO10() {
        assertFalse(model.isValidOperator("/"));
    }

    @Test
    public void testIsValidOperatorTO11() {
        assertFalse(model.isValidOperator("x"));
    }

    @Test
    public void testIsValidOperatorTO12() {
        assertFalse(model.isValidOperator("*"));
    }

 @Test
    public void testexecuteOperationsTE01() throws ErrorHandler {
        stack.push("3+2j");
        stack.push("1+4.2j");
        stack.push("+");
        model.executeOperations();
        assertEquals("4+6,2j", stack.pop());
    }

    @Test
    public void testexecuteOperationsTE02() throws ErrorHandler {
        stack.push("5+3j");
        stack.push("2+1j");
        stack.push("-");
        model.executeOperations();
        assertEquals("3+2j", stack.pop());
    }

    @Test
    public void testexecuteOperationsTE03() throws ErrorHandler {
        stack.push("3+2j");
        stack.push("1+4j");
        stack.push("×");
        model.executeOperations();
        assertEquals("-5+14j", stack.pop());
    }

    @Test
    public void testexecuteOperationsTE04() throws ErrorHandler {
        stack.push("3+2j");
        stack.push("1+4j");
        stack.push("÷");
        model.executeOperations();
        assertEquals("0,65-0,59j", stack.pop());
    }

    @Test
    public void testexecuteOperationsTE05() throws ErrorHandler {
        stack.push("4+0j");
        stack.push("√");
        model.executeOperations();
        assertEquals("2", stack.pop());
    }

    @Test
    public void testexecuteOperationsTE06() throws ErrorHandler {
        stack.push("1+1j");
        stack.push("+/-");
        model.executeOperations();
        assertEquals("-1-1j", stack.pop());
    }

    @Test
    public void testexecuteOperationsTE07() throws ErrorHandler {
        stack.clear();
        stack.push("3+2j");
        stack.push("1+1j");
        stack.push("4+0j");
        stack.push("+");
        stack.push("-");
        stack.push("2+2j");
        stack.push("÷");
        model.executeOperations();
        assertEquals("-0,25+0,75j", stack.pop());
    }

    @Test
    public void testHandleVariablesTH01() throws ErrorHandler {
        stack.push("3+4j");
        assertDoesNotThrow(() -> model.handleVariables(">x"));
        assertEquals("3+4j", bufVariable.valueVariable('x'));
    }

    @Test
    public void testHandleVariablesTH02() throws ErrorHandler {
        stack.push("+");
        assertThrows(ErrorHandler.class, () -> model.handleVariables(">x"));
    }

    @Test
    public void testHandleVariablesTH03() {
      
       assertThrows(ErrorHandler.class, () -> model.handleVariables(">x"));
    }

    @Test
    public void testHandleVariablesTH04() {
       stack.push("3+4j");
      assertThrows(ErrorHandler.class, () -> model.handleVariables("<x"));
    }

    @Test
    public void testHandleVariablesTH05() throws ErrorHandler {
        stack.push("3+4j");//faccio questa operazione per inserire almeno un valore nello stack. altrimenti viene lanciata un eccezione di tipo ErrorHandler che in questo test non mi interessa
        bufVariable.storeVariable('x', "5+2j");
        assertDoesNotThrow(() -> model.handleVariables("<x"));
        assertEquals("5+2j", stack.peek());
    }

    @Test
    public void testHandleVariablesTH06() {
        assertThrows(ErrorHandler.class, () -> model.handleVariables("+x"));
    }

    @Test
    public void testHandleVariablesTH07() throws ErrorHandler {
        bufVariable.storeVariable('x', "3+2j");
        stack.push("5-1j");
        assertDoesNotThrow(() -> model.handleVariables("+x"));
        assertEquals("8+1j", bufVariable.valueVariable('x'));
    }

    @Test
    public void testHandleVariablesTH08() {
        assertThrows(ErrorHandler.class, () -> model.handleVariables("-x"));
    }

    @Test
    public void testHandleVariablesTH09() throws ErrorHandler {
        bufVariable.storeVariable('x', "7+4j");
        stack.push("2+1j");
        assertDoesNotThrow(() -> model.handleVariables("-x"));
        assertEquals("5+3j", bufVariable.valueVariable('x'));
    }
}
