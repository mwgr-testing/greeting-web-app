package net.mwgr.testing.github.greeting.lib;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

public class GreeterTest {

	private final Greeter greeter = new Greeter();

	@Test
	public void testGreeterWithoutArgument() {
		assertThat(greeter.greet()).isEqualTo("Hello World!");
	}

	@Test
	public void testGreeterWithArgument() {
		assertThat(greeter.greet("MWGR")).isEqualTo("Hello MWGR!");
	}

	@Test
	public void nullArgumentShouldBeRejected() {
		ThrowingCallable test = () -> greeter.greet(null);
		assertThatExceptionOfType(NullPointerException.class).isThrownBy(test).withNoCause();
	}

}
