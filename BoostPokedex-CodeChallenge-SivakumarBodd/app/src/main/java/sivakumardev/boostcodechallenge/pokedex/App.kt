package sivakumardev.boostcodechallenge.pokedex

import android.app.Application
import sivakumardev.boostcodechallenge.pokedex.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDI()
    }

    private fun configureDI() = startKoin {
        androidContext(this@App)
        modules(appComponent)
    }
}
