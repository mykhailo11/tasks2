package test;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigInteger;
import java.util.stream.Stream;

public class evaluateGCDArgumentsProvider implements ArgumentsProvider {
//    {
//        BigInteger.valueOf(4), BigInteger.valueOf(16), BigInteger.valueOf(24), BigInteger.valueOf(36), BigInteger.valueOf(4)},
//    {BigInteger.valueOf(9), BigInteger.valueOf(12), BigInteger.valueOf(18), BigInteger.valueOf(27), BigInteger.valueOf(3)},
//    {BigInteger.valueOf(11), BigInteger.valueOf(4), BigInteger.valueOf(10), BigInteger.valueOf(9), BigInteger.valueOf(1)}
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(BigInteger.valueOf(4), BigInteger.valueOf(4), BigInteger.valueOf(16),
                        BigInteger.valueOf(24), BigInteger.valueOf(36)),
                Arguments.of(BigInteger.valueOf(3), BigInteger.valueOf(9), BigInteger.valueOf(12),
                        BigInteger.valueOf(18), BigInteger.valueOf(27)),
                Arguments.of(BigInteger.valueOf(1), BigInteger.valueOf(11), BigInteger.valueOf(4),
                        BigInteger.valueOf(10), BigInteger.valueOf(9))
        );
    }
}
