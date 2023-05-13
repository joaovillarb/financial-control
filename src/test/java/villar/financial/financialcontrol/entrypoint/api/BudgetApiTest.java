package villar.financial.financialcontrol.entrypoint.api;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.boot.test.mock.mockito.MockBean;
import villar.financial.financialcontrol.BaseIntegrationTest;
import villar.financial.financialcontrol.dataprovider.database.entity.Budget;
import villar.financial.financialcontrol.dataprovider.database.repository.AccountRepository;
import villar.financial.financialcontrol.dataprovider.database.repository.BudgetRepository;
import villar.financial.financialcontrol.dataprovider.database.repository.CategoryRepository;
import villar.financial.financialcontrol.entrypoint.dto.BudgetDto;
import villar.financial.financialcontrol.provider.BudgetDtoProvider;

import java.net.URI;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BudgetApiTest extends BaseIntegrationTest {

    @MockBean
    private BudgetRepository budgetRepositoryMock;

    @MockBean
    private CategoryRepository categoryRepositoryMock;

    @MockBean
    private AccountRepository accountRepositoryMock;

    @ParameterizedTest
    @ArgumentsSource(BudgetDtoProvider.class)
    void shouldSaveWithSuccess(final BudgetDto request) throws Exception {
        // GIVEN
        final var categoryExpected = createCategoryEntity();
        given(this.categoryRepositoryMock.findByName(
                categoryExpected.getName())
        ).willReturn(Optional.of(categoryExpected));

        final var accountExpected = createAccountEntity();
        given(this.accountRepositoryMock.findByLogin(
                accountExpected.getLogin())
        ).willReturn(Optional.of(accountExpected));

        final var budgetExpected = createBudgetEntity();
        given(this.budgetRepositoryMock.saveAndFlush(
                any(Budget.class))
        ).willReturn(budgetExpected);

        // WHEN
        final var resultActions = requestPost(request, URI.create("/budget"));

        // THEN
        resultActions.andExpect(status().isCreated())
                .andExpect(jsonPath("$", is(budgetExpected.getId())));
    }
}