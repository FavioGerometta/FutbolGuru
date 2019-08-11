package ar.com.favio.futbolguru.screens.competitionDetails.fixtureFragment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import ar.com.favio.futbolguru.core.data.Repository
import ar.com.favio.futbolguru.core.data.model.MatchResponse
import javax.inject.Inject

class FixtureViewModel@Inject constructor(
    private var repository: Repository
) : ViewModel() {

    var liveData = MutableLiveData<MatchResponse>()

    fun getSingleMatch(id: Long, date: String): LiveData<MatchResponse> {
        liveData = repository.getSingleMatch(id, date) as MutableLiveData<MatchResponse>
        return liveData
    }
}