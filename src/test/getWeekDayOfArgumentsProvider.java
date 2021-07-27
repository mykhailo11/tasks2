package test;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigInteger;
import java.util.stream.Stream;

public class getWeekDayOfArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(BigInteger.valueOf(2), BigInteger.valueOf(16), BigInteger.valueOf(6), BigInteger.valueOf(3)),
                Arguments.of(BigInteger.valueOf(4), BigInteger.valueOf(11), BigInteger.valueOf(0), BigInteger.valueOf(1))
        );
    }
}
