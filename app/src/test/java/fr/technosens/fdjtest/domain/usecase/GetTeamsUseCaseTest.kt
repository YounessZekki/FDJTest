package fr.technosens.fdjtest.domain.usecase

import fr.technosens.fdjtest.domain.repository.LeagueRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetTeamsUseCaseTest {

    private lateinit var getTeamsUseCase: GetTeamsUseCase

    @Mock
    private lateinit var leagueRepository: LeagueRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getTeamsUseCase = GetTeamsUseCase(leagueRepository)
    }

    @Test
    fun `invoke calls getTeams on repository with correct parameter`(): Unit = runBlocking {
        val leagueId = "Frensh league 1"
        getTeamsUseCase(leagueId)
        Mockito.verify(leagueRepository).getTeams(leagueId)
    }
}
