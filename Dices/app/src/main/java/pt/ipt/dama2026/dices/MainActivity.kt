package pt.ipt.dama2026.dices

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pt.ipt.dama2026.dices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // instanciar a variável 'binding' ligá-la à interface gráfica (layout)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //findViewById<Button>(R.id.btRodaDado).setOnClickListener {  }
        binding.btRodaDado.setOnClickListener {
            rodaDado()
        }
    }

    /**
     * função que simula o lançamento de um dado, gerando um número aleatório entre 1 e 6,
     * e atualiza o TextView com o resultado
     */
    fun rodaDado() {
        /* Algoritmo
            1- Gerar um número aleatório entre 1 e 6
            2- Alterar a imagem do dado para a face correspondente ao número gerado
            3 - Alterar o texto do TextView para mostrar o número gerado
         */

        // 1.
        val numAleatorio = (1..6).random()
        // val numAleatorio = Random.nextInt(1, 7)
        // val numAleatorio = Random().nextInt(6) + 1

        // 2.
        val imgSrc = when (numAleatorio) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        binding.diceImage.setImageResource(imgSrc)

        // 3.
        binding.txtNumDice.text = numAleatorio.toString()
    }
}
