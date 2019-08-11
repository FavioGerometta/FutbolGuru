package ar.com.favio.futbolguru.screens.competitionDetails.tableFragment

import android.arch.lifecycle.ViewModelProvider
import ar.com.favio.futbolguru.core.data.Repository
import ar.com.favio.futbolguru.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class TableModule {

    @Provides
    internal fun provideViewModel(repository: Repository): TableViewModel {
        return TableViewModel(repository)
    }

    @Provides
    internal fun provideViewModelFactory(viewModel: TableViewModel): ViewModelProvider.Factory{
        return ViewModelProviderFactory(viewModel)
    }
}