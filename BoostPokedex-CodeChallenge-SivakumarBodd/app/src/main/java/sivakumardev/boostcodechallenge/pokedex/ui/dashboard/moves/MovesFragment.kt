package sivakumardev.boostcodechallenge.pokedex.ui.dashboard.moves

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import sivakumardev.boostcodechallenge.pokedex.R

/**
 * Created by Siva kumar boddu on 18/02/23.
 */
class MovesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_moves, container, false)
    }
}
