package ar.com.favio.futbolguru.screens.competitionDetails.fixtureFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FixtureFragmentProvider {

    @ContributesAndroidInjector(modules = arrayOf(FixtureModule::class))
    internal abstract fun contributeFixturesProvider(): FixtureFragment
}