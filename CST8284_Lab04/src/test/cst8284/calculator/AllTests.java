package test.cst8284.calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//https://stackoverflow.com/questions/2255046/run-all-tests-in-junit-4

@RunWith(Suite.class)
@SuiteClasses({ TestComplex.class, TestComplexCalculator.class })
public class AllTests {

}
