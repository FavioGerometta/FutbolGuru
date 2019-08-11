package ar.com.favio.futbolguru.screens.competition.competitions

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ar.com.favio.futbolguru.R
import ar.com.favio.futbolguru.core.data.model.Competitions
import ar.com.favio.futbolguru.databinding.CompetitionsListItemBinding

class CompetitionsAdapter(
    private var competitionsList: List<Competitions>,
    private val listener: View.OnClickListener
): RecyclerView.Adapter<CompetitionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.competitions_list_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return competitionsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding?.click = listener
        holder.binding?.competitions = competitionsList[position]
    }

    fun updateAdapter(list: List<Competitions>){
        competitionsList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding: CompetitionsListItemBinding? = DataBindingUtil.bind(view)

        init {
            view.tag = binding
        }

    }
}