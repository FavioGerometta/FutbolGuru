package ar.com.favio.futbolguru.screens.competition.today

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ar.com.favio.futbolguru.R
import ar.com.favio.futbolguru.core.data.model.Match
import ar.com.favio.futbolguru.databinding.FixturesListItemBinding

class TodayFixturesAdapter(
    private var matchList: List<Match>
): RecyclerView.Adapter<TodayFixturesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.fixtures_list_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return matchList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding?.match = matchList[position]
    }

    fun updateAdapter(value: List<Match>){
        matchList = value
        return notifyDataSetChanged()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val binding: FixturesListItemBinding? = DataBindingUtil.bind(view)
        init {
            view.tag = binding
        }
    }
}

