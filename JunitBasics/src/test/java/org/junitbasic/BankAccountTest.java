package org.junitbasic;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing BankAccount")
public class BankAccountTest {

    BankAccount bankAccount;
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
        bankAccount=new BankAccount();
        testReporter.publishEntry("Running "+testInfo.getDisplayName());
    }

    @AfterEach
    void cleanup(){
        System.out.println("Testing methods done");
    }

    @Test
    @DisplayName("Test withdraw method")
    void testWithdraw(){
        assertThrows(InsufficientFundException.class, ()->bankAccount.withdraw(25000.00),
                "Insufficient balance");
    }
}
