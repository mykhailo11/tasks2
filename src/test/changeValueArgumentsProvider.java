package test;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import java.math.BigInteger;
import java.util.stream.Stream;

public class changeValueArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(BigInteger.valueOf(40), BigInteger.valueOf(50)),
                Arguments.of(BigInteger.valueOf(-11), BigInteger.valueOf(45)),
                Arguments.of(BigInteger.valueOf(-321), BigInteger.valueOf(-43)),
                Arguments.of(BigInteger.valueOf(1012), BigInteger.valueOf(-5))
        );
    }
}
