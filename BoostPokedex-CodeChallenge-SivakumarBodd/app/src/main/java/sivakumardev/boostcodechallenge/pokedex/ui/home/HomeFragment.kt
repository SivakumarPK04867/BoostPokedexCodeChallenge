package sivakumardev.boostcodechallenge.pokedex.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import sivakumardev.boostcodechallenge.pokedex.R
import sivakumardev.boostcodechallenge.pokedex.databinding.FragmentHomeBinding
import sivakumardev.boostcodechallenge.pokedex.model.Menu
import sivakumardev.boostcodechallenge.pokedex.model.News
import sivakumardev.boostcodechallenge.pokedex.utils.PokemonColorUtil
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private var viewBinding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.statusBarColor = PokemonColorUtil(view.context).convertColor(R.color.red)

        viewBinding = FragmentHomeBinding.bind(view)

        viewBinding?.recyclerViewMenu?.layoutManager = GridLayoutManager(context, 2)

        viewBinding?.recyclerViewNews?.layoutManager = LinearLayoutManager(context)

        viewBinding?.recyclerViewNews?.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        homeViewModel.getListMenu().observe(viewLifecycleOwner, Observer {
            val items: List<Menu> = it
            viewBinding?.recyclerViewMenu?.adapter = MenuAdapter(items, view.context)
        })

        homeViewModel.getListNews().observe(viewLifecycleOwner, Observer {
            val items: List<News> = it
            viewBinding?.recyclerViewNews?.adapter = NewsAdapter(items, view.context)
        })
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }

}
