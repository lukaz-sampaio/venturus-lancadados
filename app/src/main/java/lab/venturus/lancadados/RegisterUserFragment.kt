package lab.venturus.lancadados

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import lab.venturus.lancadados.databinding.FragmentRegisterUserBinding

class RegisterUserFragment : Fragment() {
    private var binding: FragmentRegisterUserBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterUserBinding.inflate(inflater, container, false)

        val playerName = binding?.inputPlayerName
        val getPlayerName = binding?.btnGetPlayerName

        getPlayerName?.setOnClickListener {
            val player = playerName?.text.toString()
            findNavController().navigate(
                R.id.action_navigation_register_to_navigation_dashboard,
                bundleOf("player" to player)
            )
        }
        return binding?.root
    }
}
