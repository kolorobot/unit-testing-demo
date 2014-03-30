package com.github.kolorobot.execution;


import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(JUnit4.class) // Tests can be run with different runners
public class JunitExecutionTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JunitExecutionTest.class);
    
    private Helper helper = new Helper();

    // No-arg constructor
    public JunitExecutionTest() {
        LOGGER.info("JunitExecutionTest.JunitExecutionTest");
    }

    //
    // Test Fixture
    //

    @BeforeClass
    public static void beforeClass() {
        LOGGER.info("JunitExecutionTest.beforeClass");
    }

    @Before
    public void before() {
        LOGGER.info("JunitExecutionTest.before");
    }

    @AfterClass
    public static void afterClass() {
        LOGGER.info("JunitExecutionTest.afterClass");
    }

    @After
    public void after() {
        LOGGER.info("JunitExecutionTest.after");
    }

    //
    // Test Cases
    //

    @Test
    public void test1() {
        LOGGER.info("JunitExecutionTest.test1");
        Assert.assertTrue(true);

    }

    @Test
    public void test2() {
        LOGGER.info("JunitExecutionTest.test2");
        Assert.assertTrue(true);
    }

    class Helper {
        Helper() {
            LOGGER.info("Helper.Helper");
        }
    }
}


