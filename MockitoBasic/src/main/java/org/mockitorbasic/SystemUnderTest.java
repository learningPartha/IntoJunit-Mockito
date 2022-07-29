package org.mockitorbasic;

import java.util.ArrayList;
import java.util.List;

public class SystemUnderTest {
    private Dependency dependency;

    public int methodUsingArraylistConstructor() {
        ArrayList list = new ArrayList();
        return list.size();
    }

    public int methodCallStaticMethod() {
        List<Integer> stats = dependency.retrieveAllStats();
        long sum = 0;
        for (int stat : stats) {
            sum += stat;
        }
        return UtilityClass.staticMethod(sum);
    }

    private long privateMethodTest() {
        List<Integer> stats = dependency.retrieveAllStats();
        long sum = 0;
        for (int stat : stats) {
            sum += stat;
        }
        return sum;
    }

}
