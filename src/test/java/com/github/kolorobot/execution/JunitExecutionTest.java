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
        LOGGER.info("JunitExecutionTest ctor");
    }

    //
    // Test Fixture
    //

    @BeforeClass
    public static void beforeClass() {
        LOGGER.info("beforeClass");
    }

    @Before
    public void before() {
        LOGGER.info("before");
    }

    @AfterClass
    public static void afterClass() {
        LOGGER.info("afterClass");
    }

    @After
    public void after() {
        LOGGER.info("after");
    }

    //
    // Test Cases
    //

    @Test
    public void test1() { // must be public and void
        LOGGER.info("test1");
        Assert.assertTrue(true);
    }

    @Test
    public void test2() throws Exception { // can declare exceptions
        LOGGER.info("test2");
        Assert.assertTrue(true);
    }

    @Test
    @Ignore
    public void ignored() { // won't run
        LOGGER.info("ignored");
        Assert.assertTrue(false);
    }

    class Helper {
        Helper() {
            LOGGER.info("Helper ctor");
        }
    }
}


