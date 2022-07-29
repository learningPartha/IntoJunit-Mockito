package org.mockitobasic;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.addressing.WsaTubeHelper;
import org.junit.Test;

public class SpyTest {

    @Test
    public void test() {
        List arraySpy = spy(ArrayList.class);
        assertEquals(0, arraySpy.size());
        /*
        arraySpy.add("Dummy");// this has no impact since mock will return size 5 when assert called
        assertEquals(1, arraySpy.size());
        arraySpy.remove("Dummy");
        assertEquals(0,arraySpy.size());*/
        /*stub(arraySpy.size()).toReturn(5);
        assertEquals(5,arraySpy.size());*/

        arraySpy.add("Dummy");
        verify(arraySpy).add("Dummy");//checks whether method was called
        verify(arraySpy, never()).clear();//checks whether method was every called
    }
}
