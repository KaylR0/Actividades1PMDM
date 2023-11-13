package recyclerViewSimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.R

class RvSimple : AppCompatActivity() {
    private lateinit var rvEjemplo: RecyclerView
    private lateinit var rvAdapter: EjemploAdapter

    private val listaEjemplo = listOf(
        TextoEjemplo("Primer elemento", -871890688),
        TextoEjemplo("Segundo elemento", -1509921024),
        TextoEjemplo("Tercer elemento", -1131230976),
        TextoEjemplo("Cuarto elemento", -1509883935),
        TextoEjemplo("Quinto elemento", -858717953),
        TextoEjemplo("Sexto elemento", -85871795),
        TextoEjemplo("Séptimo elemento", -858117952),
        TextoEjemplo("Octavo elemento", -858817951),
        TextoEjemplo("Novedo elemento", -858716954),
        TextoEjemplo("Décimo elemento", -858417955),
        TextoEjemplo("Undécimo elemento", -858716956)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_simple)
        rvEjemplo = findViewById(R.id.rvEjemplo)
        rvAdapter = EjemploAdapter(listaEjemplo)

        rvEjemplo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvEjemplo.adapter = rvAdapter
    }

}