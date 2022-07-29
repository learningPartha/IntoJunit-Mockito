package org.mockitobasic;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ListMockitoTest {

    @Test
    public void testMockListSize(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());
    }

    @Test
    public void testMockListSizeMultiReturnValue(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());
    }

    @Test
    public void testMockListGet(){
        List<String> listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("Ranga");
        assertEquals("Ranga",listMock.get(0));
        assertNull(listMock.get(1));
    }

    @Test
    public void testMockListGetAny(){
        List<String> listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("Ranga");
        assertEquals("Ranga",listMock.get(0));
        assertEquals("Ranga",listMock.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void testMockListException(){
        List<String> listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenThrow(new RuntimeException("Something"));
        listMock.get(0);
    }

    @Test
    public void testMockListGetAnyBDD(){
        //Given
        List<String> listMock = mock(List.class);
        given(listMock.get(Mockito.anyInt())).willReturn("Ranga");
        //when
        String firstElement = listMock.get(0);
        //then
        assertThat(firstElement,is("Ranga"));
    }

}
