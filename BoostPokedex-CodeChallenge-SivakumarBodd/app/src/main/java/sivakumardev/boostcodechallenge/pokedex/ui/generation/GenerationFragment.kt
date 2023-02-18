package sivakumardev.boostcodechallenge.pokedex.ui.generation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import sivakumardev.boostcodechallenge.pokedex.R
import sivakumardev.boostcodechallenge.pokedex.databinding.FragmentGenerationBinding
import sivakumardev.boostcodechallenge.pokedex.model.Generation
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class GenerationFragment : BottomSheetDialogFragment() {

    private val generationViewModel: GenerationViewModel by viewModel()

    private var viewBinding: FragmentGenerationBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_generation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentGenerationBinding.bind(view)

        val layoutManager = GridLayoutManager(context, 2)
        viewBinding?.recyclerView?.layoutManager = layoutManager

        generationViewModel.getListGeneration().observe(viewLifecycleOwner, Observer {
            val pokemons: List<Generation> = it
            viewBinding?.recyclerView?.adapter = GenerationAdapter(pokemons, view.context)
        })
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }
}
