package com.know.myapplication.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.know.androidnew.TextViewHolder
import com.know.myapplication.R
import com.know.myapplication.databinding.CandidateRowBinding
import com.know.myapplication.databinding.TopOptionsLayBinding

class CandidateAdapter(var data: List<Candidates>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.candidate_row,parent,false)
        return CandidateRowHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return data.size
    }
}

class CandidateRowHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = CandidateRowBinding.bind(view!!)
}
