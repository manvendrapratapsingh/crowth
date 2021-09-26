package com.know.androidnew

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

        if (viewType==0) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.top_options_lay, parent, false)
            return TopVirwHolder(view)
        }else if(viewType==1){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pager_image,parent,false)
            return GroupViewHolder(view)
        }else if(viewType==2){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.textdata,parent,false)
            return TextViewHolder(view)
        }
        else if(viewType==3){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.type3view,parent,false)
            return CandidateHolder(view)
        }
        else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.dummy_view, parent, false)
            return DummyViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is GroupViewHolder) {

                    val imagesList = listOf(
                        R.mipmap.image_user,
                        R.mipmap.image_user,
                        R.mipmap.image_user
                    )

                    val adapter = ViewPagerAdapter(imagesList)
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
