package ar.com.favio.futbolguru.screens.bottomSheet

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ar.com.favio.futbolguru.core.data.model.Player
import ar.com.favio.futbolguru.databinding.TeamLineNamesBinding

class BottomSheetAdapter (private var squadList: List<Player>): RecyclerView.Adapter<BottomSheetAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder (view : View): RecyclerView.ViewHolder(view) {

            val binding: TeamLineNamesBinding? = DataBindingUtil.bind(view)
            init {
                view.tag = binding
            }
    }
}