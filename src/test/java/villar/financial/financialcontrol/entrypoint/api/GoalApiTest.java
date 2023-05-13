package villar.financial.financialcontrol.entrypoint.api;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.boot.test.mock.mockito.MockBean;
import villar.financial.financialcontrol.BaseIntegrationTest;
import villar.financial.financialcontrol.dataprovider.database.entity.Goal;
import villar.financial.financialcontrol.dataprovider.database.repository.AccountRepository;
import villar.financial.financialcontrol.dataprovider.database.repository.CategoryRepository;
import villar.financial.financialcontrol.dataprovider.database.repository.GoalRepository;
import villar.financial.financialcontrol.entrypoint.dto.GoalDto;
import villar.financial.financialcontrol.provider.GoalDtoProvider;

import java.net.URI;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GoalApiTest extends BaseIntegrationTest {

    @MockBean
    private GoalRepository goalRepositoryMock;

    @MockBean
    private CategoryRepository categoryRepositoryMock;

    @MockBean
    private AccountRepository accountRepositoryMock;

    @ParameterizedTest
    @ArgumentsSource(GoalDtoProvider.class)
    void shouldSaveWithSuccess(final GoalDto request) throws Exception {
        // GIVEN
        final var categoryExpected = createCategoryEntity();
        given(this.categoryRepositoryMock.findByName(
                categoryExpected.getName())
        ).willReturn(Optional.of(categoryExpected));

        final var accountExpected = createAccountEntity();
        given(this.accountRepositoryMock.findByLogin(
                accountExpected.getLogin())
        ).willReturn(Optional.of(accountExpected));

        final var goalExpected = createGoalEntity();
        given(this.goalRepositoryMock.saveAndFlush(
                any(Goal.class))
        ).willReturn(goalExpected);

        // WHEN
        final var resultActions = requestPut(request, URI.create("/goal"));

        // THEN
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$", is(goalExpected.getId())));
    }
}