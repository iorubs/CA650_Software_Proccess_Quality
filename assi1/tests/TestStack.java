import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;



public class TestStack {

	@Test
	public void test_generic_stack() {
		Stack st_generic = new Stack();

		assertTrue(st_generic.isEmpty());

		int int_value = 1;
		String string_value = "1";

		assertNotEquals(int_value, string_value);

		st_generic.push(int_value);
		st_generic.push(string_value);

		assertEquals(st_generic.pop(), string_value);
		assertEquals(st_generic.pop(), int_value);
	}

	@Test
	public void test_type_stack() {
		Stack<Integer> st_int = new Stack<>();
		int num = 1;

		assertTrue(st_int instanceof Stack);
		assertTrue(st_int.isEmpty());
		assertTrue(st_int.push(num));
		assertFalse(st_int.isEmpty());
		// assertEquals(st_int.pop(), num);
		assertTrue(st_int.pop() == num);
		assertTrue(st_int.isEmpty());
	}

	@Test
	public void test_exceed_lower_bound() {
		Stack<String> st_string = new Stack<>();
		String str = "str";

		assertTrue(st_string.isEmpty());
		assertTrue(st_string.push(str));
		assertFalse(st_string.isEmpty());
		assertEquals(st_string.pop(), str);
		assertTrue(st_string.isEmpty());
		assertEquals(st_string.pop(), null);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void test_exceed_upper_bound() {
		int size = 5;

		Stack<Integer> st_int = new Stack<>(size);

		for(int i=0; i<=size; i++) {
			boolean status = st_int.push(i);

			if(i < size)
				assertTrue(status);
			else
				assertFalse(status);
		}
	}

	@Test
	public void test_reassign_stack() {
		Stack<String> st_string = new Stack<String>();
		Stack st_generic = st_string;

		assertTrue(st_string.isEmpty());
		assertTrue(st_generic.isEmpty());

		try {
	        st_generic.push(1);

	        fail("Expected incompatible types: int cannot be converted to String");
	    } catch(Exception e) {
	       assertTrue(st_string.isEmpty());
	    }
	}
}
