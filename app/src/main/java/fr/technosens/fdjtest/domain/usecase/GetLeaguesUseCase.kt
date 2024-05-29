package fr.technosens.fdjtest.domain.usecase

import fr.technosens.fdjtest.data.model.League
import fr.technosens.fdjtest.data.model.LeagueResponse
import fr.technosens.fdjtest.domain.repository.LeagueRepository
import javax.inject.Inject

class GetLeaguesUseCase @Inject constructor(
    private val repository: LeagueRepository
) {
    suspend operator fun invoke(): LeagueResponse = repository.getLeagues()
}