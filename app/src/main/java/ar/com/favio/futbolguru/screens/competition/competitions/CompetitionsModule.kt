package ar.com.favio.futbolguru.screens.competition.competitions

import android.arch.lifecycle.ViewModelProvider
import ar.com.favio.futbolguru.core.data.Repository
import ar.com.favio.futbolguru.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class CompetitionsModule {

    @Provides
    internal fun provideViewModel(repository: Repository): CompetitionsViewModel{
        return CompetitionsViewModel(repository)
    }

    @Provides
    internal fun provideViewModelFactory(viewModel: CompetitionsViewModel): ViewModelProvider.Factory{
        return ViewModelProviderFactory(viewModel)
    }
}