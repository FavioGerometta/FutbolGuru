package ar.com.favio.futbolguru.screens.competition.today

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import ar.com.favio.futbolguru.core.data.Repository
import ar.com.favio.futbolguru.core.data.model.MatchResponse

import javax.inject.Inject
class TodayFixturesViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var liveData = MutableLiveData<MatchResponse>()

    fun getMatches(date: String): LiveData<MatchResponse> {
        liveData = repository.getMatches(date) as MutableLiveData<MatchResponse>
        return liveData
    }
}