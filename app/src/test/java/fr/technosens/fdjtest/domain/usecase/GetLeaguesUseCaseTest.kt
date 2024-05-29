package fr.technosens.fdjtest.domain.usecase

import fr.technosens.fdjtest.domain.repository.LeagueRepository
import org.junit.Assert.*


import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetLeaguesUseCaseTest {

    private lateinit var getLeaguesUseCase: GetLeaguesUseCase

    @Mock
    private lateinit var leagueRepository: LeagueRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getLeaguesUseCase = GetLeaguesUseCase(leagueRepository)
    }

    @Test
    fun `invoke calls getLeagues on repository`(): Unit = runBlocking {
        getLeaguesUseCase()
        Mockito.verify(leagueRepository).getLeagues()
    }
}
