package villar.financial.financialcontrol.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import villar.financial.financialcontrol.entrypoint.dto.CategoryDto;

import java.util.stream.Stream;

import static villar.financial.financialcontrol.ConstantsTest.CATEGORY_DESCRIPTION;
import static villar.financial.financialcontrol.ConstantsTest.CATEGORY_NAME;

public class CategoryDtoProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                new CategoryDto(
                        CATEGORY_NAME,
                        CATEGORY_DESCRIPTION
                )
        ).map(Arguments::of);
    }
}
