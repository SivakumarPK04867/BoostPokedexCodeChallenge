package sivakumardev.boostcodechallenge.pokedex.di

import androidx.room.Room
import sivakumardev.boostcodechallenge.pokedex.R
import sivakumardev.boostcodechallenge.pokedex.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            androidApplication().baseContext.getString(R.string.app_name)
        ).build()
    }

    single {
        get<AppDatabase>().pokemonDAO()
    }
}
