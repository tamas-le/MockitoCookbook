package mockito;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SpyTester {
	

	
	@Test
	public void testList(){
		List list = new LinkedList();
		List spy = spy(list);
		
		doReturn("foo").when(spy).get(0);
		when(spy.size()).thenReturn(100);
		
		System.out.println(spy.get(0));
		System.out.println(spy.size());

		
	}

}
