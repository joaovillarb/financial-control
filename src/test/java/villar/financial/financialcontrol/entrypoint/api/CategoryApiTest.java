package villar.financial.financialcontrol.entrypoint.api;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.boot.test.mock.mockito.MockBean;
import villar.financial.financialcontrol.BaseIntegrationTest;
import villar.financial.financialcontrol.dataprovider.database.entity.Category;
import villar.financial.financialcontrol.dataprovider.database.repository.CategoryRepository;
import villar.financial.financialcontrol.entrypoint.dto.CategoryDto;
import villar.financial.financialcontrol.provider.CategoryDtoProvider;

import java.net.URI;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CategoryApiTest extends BaseIntegrationTest {

    @MockBean
    private CategoryRepository categoryRepositoryMock;

    @ParameterizedTest
    @ArgumentsSource(CategoryDtoProvider.class)
    void shouldSaveWithSuccess(final CategoryDto request) throws Exception {
        // GIVEN
        final var categoryExpected = createCategoryEntity();
        given(this.categoryRepositoryMock.saveAndFlush(
                any(Category.class))
        ).willReturn(categoryExpected);

        // WHEN
        final var resultActions = requestPost(request, URI.create("/category"));

        // THEN
        resultActions.andExpect(status().isCreated())
                .andExpect(jsonPath("$", is(categoryExpected.getId())));
    }
}