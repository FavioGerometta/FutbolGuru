package ar.com.favio.futbolguru.screens.competition.competitions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import ar.com.favio.futbolguru.core.data.Repository
import ar.com.favio.futbolguru.core.data.model.CompetitionResponse
import javax.inject.Inject

class CompetitionsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var liveData = MutableLiveData<CompetitionResponse>()

    fun getCompetitions(): LiveData<CompetitionResponse> {
        liveData = repository.getCompetitions() as MutableLiveData<CompetitionResponse>
        return liveData
    }
}