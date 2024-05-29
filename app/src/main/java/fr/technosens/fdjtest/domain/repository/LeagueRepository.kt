package fr.technosens.fdjtest.domain.repository

import fr.technosens.fdjtest.data.model.LeagueResponse
import fr.technosens.fdjtest.data.model.TeamResponse

interface LeagueRepository {
    suspend fun getLeagues(): LeagueResponse
    suspend fun getTeams(leagueId: String): TeamResponse
}