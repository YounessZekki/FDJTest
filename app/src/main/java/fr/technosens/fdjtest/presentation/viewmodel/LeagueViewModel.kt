package fr.technosens.fdjtest.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.technosens.fdjtest.data.model.League
import fr.technosens.fdjtest.data.model.Team
import fr.technosens.fdjtest.domain.usecase.GetLeaguesUseCase
import fr.technosens.fdjtest.domain.usecase.GetTeamsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueViewModel @Inject constructor(
    private val getLeguesUseCase: GetLeaguesUseCase,
    private val getTeamsUseCase: GetTeamsUseCase
) : ViewModel() {

    private val _leagues = MutableLiveData<List<League>>()
    val leagues: LiveData<List<League>> = _leagues

    private val _teams = MutableLiveData<List<Team>>()
    val teams: LiveData<List<Team>> = _teams

    fun fetchLeagues() {
        viewModelScope.launch {
            _leagues.value = getLeguesUseCase().leagues
        }
    }

    fun fetchTeams(leagueId: String) {
        viewModelScope.launch {
            val teamResponse = getTeamsUseCase(leagueId)
            _teams.value = teamResponse.teams.sortedByDescending { it.strTeam }
                .filterIndexed { index, _ -> index % 2 == 1 }
        }
    }
}