package recyclerViewSimple

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.R

class EjemploViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    private val tvEjemplo: TextView =
        view.findViewById(R.id.tvEjemplo)
    fun pintarViews(item: TextoEjemplo){
        tvEjemplo.text = item.texto
        tvEjemplo.setTextColor(item.colorTexto)
    }

}
