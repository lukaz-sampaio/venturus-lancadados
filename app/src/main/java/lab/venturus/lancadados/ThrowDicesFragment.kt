package lab.venturus.lancadados

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import lab.venturus.lancadados.databinding.FragmentThrowDicesBinding

class ThrowDicesFragment : Fragment() {
    var binding: FragmentThrowDicesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThrowDicesBinding.inflate(inflater, container, false)

        val dice01 = binding?.imgDice01
        val dice02 = binding?.imgDice02
        val btnPlay = binding?.btnJogar
        val welcome = binding?.textViewWelcome
        val shareButton = binding?.share

        val player = "Player Name"
        welcome?.text = arguments?.getString("player")
        val message = getString(R.string.welcome, player)


        shareButton?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "You are a lucky!")
//            intent.setPackage("com.whatsapp")
            intent.type = "text/plain"
            startActivity(intent)

            // abrir compartilhar direto no aplicativo se estiver instalado
//            activity?.packageManager?.run {
//                if (intent.resolveActivity(this) != null) {
//                    startActivity(intent)
//                } else {
//                    Toast.makeText(context, "You don't have WhatsApp app", Toast.LENGTH_LONG).show()
//                }
//            }
        }

        btnPlay?.setOnClickListener {
            dice01?.setImageResource(randomDices())
            dice02?.setImageResource(randomDices())
        }

        return binding?.root
    }

    private fun randomDices() = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6,
    ).random()
}
