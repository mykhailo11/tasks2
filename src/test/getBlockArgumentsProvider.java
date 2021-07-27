package test;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigInteger;
import java.util.stream.Stream;

public class getBlockArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(BigInteger.valueOf(9), BigInteger.valueOf(4), BigInteger.valueOf(1), BigInteger.valueOf(1)),
                Arguments.of(BigInteger.valueOf(9), BigInteger.valueOf(4), BigInteger.valueOf(36), BigInteger.valueOf(1)),
                Arguments.of(BigInteger.valueOf(9), BigInteger.valueOf(4), BigInteger.valueOf(37), BigInteger.valueOf(2)),
                Arguments.of(BigInteger.valueOf(9), BigInteger.valueOf(4), BigInteger.valueOf(72), BigInteger.valueOf(2))
        );
    }
}
