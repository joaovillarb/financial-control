package villar.financial.financialcontrol.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import villar.financial.financialcontrol.entrypoint.dto.AccountDto;
import villar.financial.financialcontrol.entrypoint.dto.CategoryDto;
import villar.financial.financialcontrol.entrypoint.dto.GoalDto;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static villar.financial.financialcontrol.ConstantsTest.CATEGORY_NAME;
import static villar.financial.financialcontrol.ConstantsTest.EMAIL_TEST;

public class GoalDtoProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                new GoalDto(
                        BigDecimal.valueOf(1000L),
                        new AccountDto(EMAIL_TEST),
                        new CategoryDto(CATEGORY_NAME)
                )
        ).map(Arguments::of);
    }
}
