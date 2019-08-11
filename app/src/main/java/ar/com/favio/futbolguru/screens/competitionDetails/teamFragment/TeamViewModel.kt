package ar.com.favio.futbolguru.screens.competitionDetails.teamFragment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ar.com.favio.futbolguru.core.data.Repository
import ar.com.favio.futbolguru.core.data.model.PlayerResponse
import ar.com.favio.futbolguru.core.data.model.TeamResponse
import javax.inject.Inject

class TeamViewModel @Inject constructor(
    private var repository: Repository
) : ViewModel() {

    var liveData = MutableLiveData<TeamResponse>()
    var playerLiveData = MutableLiveData<PlayerResponse>()

    fun getTeams(id: Long): LiveData<TeamResponse> {
        liveData = repository.getTeam(id) as MutableLiveData<TeamResponse>
        return liveData
    }

    fun getPlayers(id: Long): LiveData<PlayerResponse> {
        playerLiveData = repository.getPlayers(id) as MutableLiveData<PlayerResponse>
        return playerLiveData
    }

}