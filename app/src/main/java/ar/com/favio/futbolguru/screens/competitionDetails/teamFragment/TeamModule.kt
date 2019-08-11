package ar.com.favio.futbolguru.screens.competitionDetails.teamFragment

import android.arch.lifecycle.ViewModelProvider
import ar.com.favio.futbolguru.core.data.Repository
import ar.com.favio.futbolguru.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class TeamModule {

    @Provides
    internal fun provideViewModel(repository: Repository): TeamViewModel {
        return TeamViewModel(repository)
    }

    @Provides
    internal fun provideViewModelFactory(viewModel: TeamViewModel): ViewModelProvider.Factory{
        return ViewModelProviderFactory(viewModel)
    }
}