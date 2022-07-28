package org.junitbasic;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Testing Mathutil")
class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    /*@BeforeAll//before anything initiates in test
   // static void beforeInit(){
    void beforeInit(){
        System.out.println("This should be run before all");
    }*/

    /*@AfterAll//after everything completes in test
    //static void postCleanup(){
    void postCleanup(){
        System.out.println("This should be run after all");
    }*/

    @BeforeEach //to execute before each test method
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo=testInfo;
        this.testReporter=testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running "+testInfo.getDisplayName()+ " with Tags "+testInfo.getTags());
    }

    @AfterEach//to execute after each test method
    void cleanup(){
        System.out.println("Cleaning up");
    }

    /*@Test
    @DisplayName("Testing add method")//display custom test name instead of method name
    void testAdd() {
        //MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual,
                "Add method should add 2 numbers");
    }*/


    @Nested//nested class to divide test method for different scenario
    @Tag("Math")
    @DisplayName("Add Method")
    class AddTest {
        @Test
        @DisplayName("Test adding two positive number")
        void testAddingTwoPositives() {
            assertEquals(2, mathUtils.add(1, 1),
                    "should return right sum");
        }

        @Test
        @DisplayName("Test adding two negative number")
        void testAddingTwoNegatives() {
            assertEquals(-2, mathUtils.add(-1, -1),
                    "should return right sum");
        }

        @Test
        @DisplayName("Test adding one positive and negative number")
        void testAddingAPositiveAndANegative() {
            int expected = 0;
            int actual = mathUtils.add(-1, 1);
            assertEquals(expected, actual,
                    ()->"should return sum "+expected+" but returned "+actual);//used lambda to lazy assert to optimize
        }
    }


    @Test
    @Tag("Circle")
    @DisplayName("Testing circle area method")
    void testComputeCircleArea() {
        //MathUtils mathUtils = new MathUtils();
        assertEquals(Math.round(314.15926535), Math.round(mathUtils.computeCircleArea(10)),
                "Should return right circle area");
    }

    @Test
   // @EnabledOnOs(OS.LINUX)//enabling on specific OS
    @DisplayName("Testing divide method")
    void testDivide() {
        //MathUtils mathUtils = new MathUtils();
        /*assertThrows(NullPointerException.class,()->mathUtils.divide(1,0),
                "Divide by zero should throw");*/
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),
                "Divide by zero should throw");
        int expected = 2;
        int actual = mathUtils.divide(4, 2);
        assertEquals(expected,actual,
                "Divide should divide 2 numbers");
    }

    //@Test
    @RepeatedTest(3)//to repeat same test multiple times
    @DisplayName("Testing subtract method")
    void testSubtract(RepetitionInfo repetitionInfo){//to use repition info for diff behavior on each iteration
        //if(repetitionInfo.getCurrentRepetition()==1){
            boolean isServerUp = true;
            assumeTrue(isServerUp);//exeucte next line of codes only if this is true
            int expected = 1;
            int actual = mathUtils.subtract(2, 1);
            assertEquals(expected, actual,
                    "Subtract method should subtract 2 numbers");
       // }
    }

    @Test
    @Tag("Math")
    @DisplayName("Testing multiply method")
    void testMultiply(){
        testReporter.publishEntry("Running "+testInfo.getDisplayName()+ " with Tags "+testInfo.getTags());//publishes input to junit output
        int expected = 2;
        int actual = mathUtils.multiply(2, 1);
        assertEquals(expected,actual,
                "Multiply method should multiply 2 numbers");
        assertAll(
                ()->assertEquals(4,mathUtils.multiply(2,2)),
                ()->assertEquals(0,mathUtils.multiply(2,0)),
                ()->assertEquals(-6,mathUtils.multiply(2,-3))
        );
    }

    @Test
    @Disabled
    @DisplayName("Testing disable")
    void testDisabled(){
        fail("This test should fail");
    }
}