package ar.com.favio.futbolguru.core.dagger.modules

import android.arch.persistence.room.Room
import android.content.Context
import ar.com.favio.futbolguru.FutbolApplication
import ar.com.favio.futbolguru.core.data.Repository
import ar.com.favio.futbolguru.core.data.db.AppDatabase
import ar.com.favio.futbolguru.core.data.db.CompetitionsDao
import ar.com.favio.futbolguru.core.data.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FutbolMainModule {

    @Singleton
    @Provides
    internal fun provideContext(application: FutbolApplication): Context {
        return application
    }

    @Provides
    internal fun provideRepository(apiService: ApiService, dao: CompetitionsDao): Repository{
        return Repository(apiService, dao)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase = Room.databaseBuilder(
        context, AppDatabase::class.java, "competitions_db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideCompetitionDao(appDatabase: AppDatabase):
            CompetitionsDao = appDatabase.competitionsDao()
}