package com.know.androidnew

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.know.myapplication.R
import com.know.myapplication.data.CrowthData
import com.know.myapplication.databinding.*
import com.know.myapplication.ui.home.CandidateAdapter
import com.know.myapplication.ui.home.Candidates
import com.know.myapplication.ui.home.ViewPagerAdapter

/*Adapter class to show the list on RecyclerView*/
class HomeAdapter (var crowthData: List<CrowthData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
         val view =  when (viewType) {
            0 -> return TopVirwHolder(LayoutInflater.from(parent.context).inflate(R.layout.top_options_lay, parent, false))
            1 -> return GroupViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_pager_image,parent,false))
            2 -> return TextViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.textdata,parent,false))
            3 ->  return CandidateHolder(LayoutInflater.from(parent.context).inflate(R.layout.type3view,parent,false))
            else -> { // Note the block
                 return DummyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.dummy_view, parent, false))
            }
        }
//
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is GroupViewHolder) {

            val userImage = mutableListOf<Int>()
            repeat(10) { index ->
                userImage.add( R.mipmap.image_user)
            }
            val adapter = ViewPagerAdapter(userImage)
            holder.viewPager2.adapter = adapter

            }else if(holder is CandidateHolder){
              val candidates = mutableListOf<Candidates>()
            repeat(10) { index ->
               val candidate = Candidates()
                candidates.add(candidate)
            }
            val adapter = CandidateAdapter(candidates)
               holder.candidateRecyclerView.setAdapter(adapter)

            }

    }


    override fun getItemViewType(position: Int): Int {
        return  crowthData[position].type
    }


    override fun getItemCount(): Int {
     return crowthData.size;
    }
}

class CandidateHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
   val binding = Type3viewBinding.bind(view!!)
    var candidateRecyclerView = binding.candidateRecyclerView

}

class TextViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
 val binding = TextdataBinding.bind(view!!)
}

class GroupViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
 val binding = ViewPagerImageBinding.bind(view!!)
   var viewPager2 = binding.viewPager

}

class DummyViewHolder(view: View) : RecyclerView.ViewHolder(view!!) {
    val binding= DummyViewBinding.bind(view!!)
}

class TopVirwHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
    /*View Binding object from KooItemBinding using koo_item.xml */
    val binding = TopOptionsLayBinding.bind(view!!)

}
