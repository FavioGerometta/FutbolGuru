package ar.com.favio.futbolguru.screens.competition.today

import android.arch.lifecycle.ViewModelProvider
import ar.com.favio.futbolguru.core.data.Repository
import ar.com.favio.futbolguru.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class TodayModule {

    @Provides
    internal fun provideViewModel(repository: Repository): TodayFixturesViewModel {
        return TodayFixturesViewModel(repository)
    }

    @Provides
    internal fun provideViewModelFactory(viewModel: TodayFixturesViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(viewModel)
    }
}