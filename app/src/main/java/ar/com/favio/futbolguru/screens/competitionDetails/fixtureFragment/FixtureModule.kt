package ar.com.favio.futbolguru.screens.competitionDetails.fixtureFragment

import android.arch.lifecycle.ViewModelProvider
import ar.com.favio.futbolguru.core.data.Repository
import ar.com.favio.futbolguru.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class FixtureModule {

    @Provides
    internal fun provideViewModel(repository: Repository): FixtureViewModel {
        return FixtureViewModel(repository)
    }

    @Provides
    internal fun provideViewModelFactory(viewModel: FixtureViewModel): ViewModelProvider.Factory{
        return ViewModelProviderFactory(viewModel)
    }
}