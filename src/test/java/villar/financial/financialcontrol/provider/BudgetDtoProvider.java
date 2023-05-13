package villar.financial.financialcontrol.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import villar.financial.financialcontrol.entrypoint.dto.AccountDto;
import villar.financial.financialcontrol.entrypoint.dto.BudgetDto;
import villar.financial.financialcontrol.entrypoint.dto.CategoryDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import static villar.financial.financialcontrol.ConstantsTest.CATEGORY_NAME;
import static villar.financial.financialcontrol.ConstantsTest.EMAIL_TEST;

public class BudgetDtoProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                new BudgetDto(
                        LocalDateTime.now(),
                        BigDecimal.valueOf(500L),
                        "Compras aleatórias",
                        new AccountDto(EMAIL_TEST),
                        new CategoryDto(CATEGORY_NAME)
                )
        ).map(Arguments::of);
    }
}
