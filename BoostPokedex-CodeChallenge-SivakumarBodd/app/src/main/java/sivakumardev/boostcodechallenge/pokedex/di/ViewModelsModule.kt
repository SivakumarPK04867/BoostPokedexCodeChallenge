package sivakumardev.boostcodechallenge.pokedex.di

import sivakumardev.boostcodechallenge.pokedex.ui.dashboard.DashboardViewModel
import sivakumardev.boostcodechallenge.pokedex.ui.generation.GenerationViewModel
import sivakumardev.boostcodechallenge.pokedex.ui.home.HomeViewModel
import sivakumardev.boostcodechallenge.pokedex.ui.pokedex.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
val viewModelsModule = module {
    viewModel { DashboardViewModel(get()) }
    viewModel { GenerationViewModel() }
    viewModel { HomeViewModel() }
    viewModel { PokedexViewModel(get(), get()) }
}
