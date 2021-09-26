package com.know.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.know.myapplication.data.CrowthData
import com.know.myapplication.data.Data

class HomeViewModel : ViewModel() {

    private val crowthData = MutableLiveData<List<CrowthData>>().apply {
        value = setData()
    }
    val mCrowthData: MutableLiveData<List<CrowthData>> = crowthData

    /*Livedata  object create data for our List of Objects*/
    private fun setData(): List<CrowthData>{
        val crowthDataList = mutableListOf<CrowthData>()
        var data= Data()
        var crowthData  = CrowthData(data,0)
        crowthDataList!!.add(crowthData)

        var data1= Data()
        var crowthData1  = CrowthData(data1,1)
        crowthDataList!!.add(crowthData1)

        var data2= Data()
        var crowthData2  = CrowthData(data2,2)
        crowthDataList!!.add(crowthData2)

        var data4= Data()
        var crowthData4 = CrowthData(data4,3)
        crowthDataList!!.add(crowthData4)

        var data3= Data()
        var crowthData3  = CrowthData(data3,2)
        crowthDataList!!.add(crowthData3)



        return crowthDataList
    }
}