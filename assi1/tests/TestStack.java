import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestStack {

	@Test
	public void test_create_generic_stack() {
		Stack st_generic = new Stack();

		assertTrue(st_generic instanceof Stack);

		int int_value = 1;
		String string_value = "2";

		st_generic.push(int_value);
		st_generic.push(string_value);

		assertEquals(st_generic.pop(), string_value);
		assertEquals(st_generic.pop(), int_value);

		st_generic.push(int_value);
		st_generic.push(string_value);

		assertTrue(st_generic.pop() instanceof String);
		assertTrue(st_generic.pop() instanceof Integer);

	}

	@Test
	public void test_create_type_stack() {
		Stack<Integer> st_int = new Stack<>();
		// assertEquals(3,a.dec(4));
	}
}
