package ar.com.favio.futbolguru

import ar.com.favio.futbolguru.core.dagger.components.DaggerFutbolMainComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class FutbolApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerFutbolMainComponent.builder().create(this)
    }
}