package sivakumardev.boostcodechallenge.pokedex.di

import sivakumardev.boostcodechallenge.pokedex.repository.PokemonService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
val networkModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/mrcsxsiq/b94dbe9ab67147b642baa9109ce16e44/raw/97811a5df2df7304b5bc4fbb9ee018a0339b8a38/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create<PokemonService>()
    }
}
