package sivakumardev.boostcodechallenge.pokedex.ui.dashboard.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import sivakumardev.boostcodechallenge.pokedex.R
import sivakumardev.boostcodechallenge.pokedex.databinding.FragmentAboutBinding
import sivakumardev.boostcodechallenge.pokedex.ui.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class AboutFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by viewModel()
    private var viewBinding: FragmentAboutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = checkNotNull(arguments?.getString("id"))

        viewBinding = FragmentAboutBinding.bind(view)

        dashboardViewModel.getPokemonById(id).observe(viewLifecycleOwner, Observer { pokemonValue ->
            pokemonValue?.let { pokemon ->
                viewBinding?.apply {
                    textViewDescription.text = pokemon.xdescription
                    textViewHeight.text = pokemon.height
                    textViewWeight.text = pokemon.weight
                    textViewEggCycle.text = pokemon.cycles
                    textViewEggGroups.text = pokemon.egg_groups
                    textViewBaseEXP.text = pokemon.base_exp
                }
            }
        })
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance(id: String?) = AboutFragment().apply {
            arguments = Bundle().apply {
                putString("id", id)
            }
        }
    }
}
