package fr.technosens.fdjtest.data.repository

import fr.technosens.fdjtest.data.api.ApiService
import fr.technosens.fdjtest.data.model.LeagueResponse
import fr.technosens.fdjtest.data.model.TeamResponse
import fr.technosens.fdjtest.domain.repository.LeagueRepository
import javax.inject.Inject

class LeagueRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : LeagueRepository {
    override suspend fun getLeagues(): LeagueResponse = apiService.getLeagues()
    override suspend fun getTeams(leagueId: String): TeamResponse = apiService.getTeams(leagueId)
}
