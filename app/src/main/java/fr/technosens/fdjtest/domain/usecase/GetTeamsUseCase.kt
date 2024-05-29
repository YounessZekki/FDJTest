package fr.technosens.fdjtest.domain.usecase

import fr.technosens.fdjtest.data.model.TeamResponse
import fr.technosens.fdjtest.domain.repository.LeagueRepository
import javax.inject.Inject

class GetTeamsUseCase @Inject constructor(
    private val repository: LeagueRepository
) {
    suspend operator fun invoke(leagueName: String): TeamResponse = repository.getTeams(leagueName)
}