package ar.com.favio.futbolguru.core.dagger.builders

import ar.com.favio.futbolguru.screens.competition.HomeActivity
import ar.com.favio.futbolguru.screens.competition.HomeActivityModule
import ar.com.favio.futbolguru.screens.competition.competitions.CompetitionsFragmentProvider
import ar.com.favio.futbolguru.screens.competition.today.TodayFragmentProvider
import ar.com.favio.futbolguru.screens.competitionDetails.CompetitionDetailsActivity
import ar.com.favio.futbolguru.screens.competitionDetails.CompetitionDetailsActivityModule
import ar.com.favio.futbolguru.screens.competitionDetails.fixtureFragment.FixtureFragmentProvider
import ar.com.favio.futbolguru.screens.competitionDetails.tableFragment.TableFragmentProvider
import ar.com.favio.futbolguru.screens.competitionDetails.teamFragment.TeamFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(
        HomeActivityModule::class,
        TodayFragmentProvider::class,
        CompetitionsFragmentProvider::class))
    internal abstract fun contributeFixturesActivityModule(): HomeActivity

    @ContributesAndroidInjector(modules = arrayOf(
        CompetitionDetailsActivityModule::class,
        FixtureFragmentProvider::class,
        TableFragmentProvider::class,
        TeamFragmentProvider::class))
    internal abstract fun contributeMatchesActivityModule(): CompetitionDetailsActivity
}