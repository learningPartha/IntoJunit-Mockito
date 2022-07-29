package org.mockitobasic;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Every.everyItem;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatcherTest {

    @Test
    public void basicHamcrestMatchers(){
        List<Integer> scoreList = Arrays.asList(99,100,105,85);
        assertThat(scoreList, hasSize(4));
        assertThat(scoreList, hasItems(100,99));
        assertThat(scoreList, everyItem(greaterThan(80)));
        assertThat(scoreList,everyItem(lessThan(120)));

        assertThat("",isEmptyString());
        assertThat(null,isEmptyOrNullString());

        Integer[] marks = {1,2,3};
        assertThat(marks, arrayWithSize(3));
        assertThat(marks, arrayContainingInAnyOrder(2,3,1));
    }

}
