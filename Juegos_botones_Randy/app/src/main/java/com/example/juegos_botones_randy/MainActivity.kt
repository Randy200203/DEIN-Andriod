import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.juegos_botones_randy.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private fun buttonClickListener(index: Int, uniqueButtonIndex: Int): View.OnClickListener {
        return View.OnClickListener {
            val message = if (index == uniqueButtonIndex) {
                "ME ENCONTRASTE!!"
            } else {
                "Sigue buscando"
            }
            Toast.makeText(
                this@MainActivity,
                "Botón " + String.format("%02d", index) + ": $message",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private val numBotones = 10

    private lateinit var llBotonera: LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llBotonera = findViewById(R.id.llBotonera)

        val uniqueButtonIndex = Random.nextInt(numBotones)

        val ip = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            resources.getDimensionPixelSize(R.dimen.button_height)
        )

        for (i in 0 until numBotones) {
            val button = Button(this)
            button.layoutParams = ip
            button.text = "Botón " + String.format("%02d", i)
            button.setOnClickListener(buttonClickListener(i, uniqueButtonIndex))
            llBotonera.addView(button)
        }
    }
}
