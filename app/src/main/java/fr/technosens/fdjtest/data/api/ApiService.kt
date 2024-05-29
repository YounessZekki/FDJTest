package fr.technosens.fdjtest.data.api

import fr.technosens.fdjtest.data.model.LeagueResponse
import fr.technosens.fdjtest.data.model.Team
import fr.technosens.fdjtest.data.model.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("all_leagues.php")
    suspend fun getLeagues(): LeagueResponse

    @GET("search_all_teams.php")
    suspend fun getTeams(@Query("l") strLeague: String): TeamResponse
}