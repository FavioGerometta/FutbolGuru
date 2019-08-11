package ar.com.favio.futbolguru.screens.competition.competitions

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CompetitionsFragmentProvider {

    @ContributesAndroidInjector(modules = arrayOf(CompetitionsModule::class))
    internal abstract fun contributeCompetitionProvider(): CompetitionsFragment
}