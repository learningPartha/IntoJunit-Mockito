package org.junitbasic;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing MinMaxFind")
public class MinMaxFindTest {

    MinMaxFinder minMaxFinder;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeStartup(){
        System.out.println("Going to start testing");
    }

    @AfterAll
    static void afterCleanup(){
        System.out.println("All testing completed");
    }

    @BeforeEach
    void init(TestInfo testInfo,TestReporter testReporter){
        this.testInfo=testInfo;
        this.testReporter=testReporter;
        minMaxFinder=new MinMaxFinder();
        testReporter.publishEntry("Running "+testInfo.getDisplayName());
    }

    @AfterEach
    void cleanup(){
        System.out.println("Testing methods done");
    }

    @Nested
    @DisplayName("Testing findMinMax method")
    class findMinMaxTest{

        @Test
        @DisplayName("when array has positive numbers")
        void testMinMaxPositive(){
            int[] expected = new int[]{1,35};
            int[] actual = minMaxFinder.findMinMax(new int[]{3,4,17,9,35,1});
            assertArrayEquals(expected,actual,"should give correct min max for positive numbers");
        }

        @Test
        @DisplayName("when array has negative numbers")
        void testMinMaxNegative(){
            int[] expected = new int[]{-89,-1};
            int[] actual = minMaxFinder.findMinMax(new int[]{-1,-13,-14,-89});
            assertArrayEquals(expected,actual,"should give correct min max for negative numbers");
        }

        @Test
        @DisplayName("when array has both positive negative numbers")
        void testMinMaxNumbers(){
            int[] expected = new int[]{-17,35};
            int[] actual = minMaxFinder.findMinMax(new int[]{-13,4,-17,9,35,-1});
            assertArrayEquals(expected,actual,"should give correct min max for positive/negative numbers");
        }
    }

    @Nested
    @DisplayName("Testing findMinMax Object method")
    class findMinMaxObjectTest{

        @Test
        @DisplayName("when array has positive numbers for object")
        void testMinMaxObjectPositive(){
            MinMax expected = new MinMax(1,35);
            MinMax actual = minMaxFinder.findMinMaxObject(new int[]{3,4,17,9,35,1});
            assertEquals(expected.toString(),actual.toString(),"object should give correct min max for positive numbers");
        }

        @Test
        @DisplayName("when array has negative numbers for object")
        void testMinMaxObjectNegative(){
            MinMax expected = new MinMax(-89,-1);
            MinMax actual = minMaxFinder.findMinMaxObject(new int[]{-1,-13,-14,-89});
            assertEquals(expected.toString(),actual.toString(),"object should give correct min max for negative numbers");
        }

        @Test
        @DisplayName("when array has both positive negative numbers for object")
        void testMinMaxObjectNumbers(){
            MinMax expected = new MinMax(-17,35);
            MinMax actual = minMaxFinder.findMinMaxObject(new int[]{-13,4,-17,9,35,-1});
            assertEquals(expected.toString(),actual.toString(),"object should give correct min max for positive/negative numbers");
        }
    }
}
