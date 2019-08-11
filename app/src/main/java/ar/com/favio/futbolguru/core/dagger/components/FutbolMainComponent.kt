package ar.com.favio.futbolguru.core.dagger.components

import ar.com.favio.futbolguru.FutbolApplication
import ar.com.favio.futbolguru.core.dagger.builders.ActivityBuilder
import ar.com.favio.futbolguru.core.dagger.modules.FutbolMainModule
import ar.com.favio.futbolguru.core.dagger.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidSupportInjectionModule::class,
    FutbolMainModule::class,
    NetworkModule::class,
    ActivityBuilder::class))
interface FutbolMainComponent: AndroidInjector<FutbolApplication> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<FutbolApplication>()
}