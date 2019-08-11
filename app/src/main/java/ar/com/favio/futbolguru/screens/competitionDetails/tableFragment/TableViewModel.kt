package ar.com.favio.futbolguru.screens.competitionDetails.tableFragment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ar.com.favio.futbolguru.core.data.Repository
import ar.com.favio.futbolguru.core.data.model.StandingResponse
import javax.inject.Inject

class TableViewModel @Inject constructor(
    private var repository: Repository
) : ViewModel() {

    var liveData = MutableLiveData<StandingResponse>()

    fun getStandings(id: Long, standingType: String): LiveData<StandingResponse> {
        liveData = repository.getStandings(id, standingType) as MutableLiveData<StandingResponse>
        return liveData
    }
}