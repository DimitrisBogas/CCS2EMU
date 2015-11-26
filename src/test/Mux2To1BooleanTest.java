//package test;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import sim.gate.Mux2to1Boolean;
//
//import static org.junit.Assert.*;
//
//public class Mux2To1BooleanTest {
//    private Mux2to1Boolean mux;
//
//    @Before
//    public void setUp() throws Exception {
//        mux = new Mux2to1Boolean();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        mux = null;
//    }
//
//    @Test
//    public void testDefaultSelectPinStateShouldBeFalse() throws Exception {
//        boolean defaultState = false;
//        assertEquals(defaultState, mux.getSelectPin());
//    }
//
//    @Test
//    public void selectAInput() throws Exception {
//        boolean selectedInput = false;
//        mux.setSelectPin(selectedInput);
//        assertEquals(selectedInput, mux.getSelectPin());
//    }
//
//    @Test
//     public void selectBInput() throws Exception {
//        boolean selectedInput = true;
//        mux.setSelectPin(selectedInput);
//        assertEquals(selectedInput, mux.getSelectPin());
//    }
//
//    @Test
//     public void inputAIsSelected() throws Exception {
//        boolean inpA = false;
//        boolean selectedInput = inpA;
//        mux.setSelectPin(selectedInput);
//        boolean inputA = true;
//        boolean inputB = false;
//        assertEquals(inputA, mux.getOutput(inputA, inputB));
//        assertNotEquals(inputB, mux.getOutput(inputA, inputB));
//    }
//
//    @Test
//    public void inputBIsSelected() throws Exception {
//        boolean inpB = true;
//        boolean selectedInput = inpB;
//        mux.setSelectPin(selectedInput);
//        boolean inputA = true;
//        boolean inputB = false;
//        assertEquals(inputB, mux.getOutput(inputA, inputB));
//        assertNotEquals(inputA, mux.getOutput(inputA, inputB));
//    }
//
//    @Test
//    public void testDefaultConstructorIfTrueArgumentIsPass() throws Exception {
//        boolean state;
//        state = true;
//        mux = new Mux2to1Boolean(state);
//        assertEquals(state, mux.getSelectPin());
//
//    }
//    @Test
//    public void testDefaultConstructorIfFalseArgumentIsPass() throws Exception {
//        boolean state;
//        state = false;
//        mux = new Mux2to1Boolean(state);
//        assertEquals(state, mux.getSelectPin());
//    }
//}