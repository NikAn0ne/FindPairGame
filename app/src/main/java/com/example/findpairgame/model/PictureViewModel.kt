package com.example.findpairgame.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.findpairgame.R
import com.example.findpairgame.navigation.Screen

class PictureViewModel : ViewModel() {
    private val pictures: MutableLiveData<MutableList<PictureModel>> by lazy {
        MutableLiveData<MutableList<PictureModel>>()
    }
    fun getPictures(): LiveData<MutableList<PictureModel>>{
        return pictures
    }
    private fun nextScreen(navController: NavHostController, score: Int){
        navController.navigate(route = Screen.ResultScreen.passScore(score))
    }

    fun loadPictures(){
        pictures.value = mutableListOf(
            PictureModel(R.drawable.kingdiamond),
            PictureModel(R.drawable.kingheart),
            PictureModel(R.drawable.tenheart),
            PictureModel(R.drawable.aceblack),
            PictureModel(R.drawable.jokerdiamond),
            PictureModel(R.drawable.qeenheart),
            PictureModel(R.drawable.kingdiamond),
            PictureModel(R.drawable.kingheart),
            PictureModel(R.drawable.tenheart),
            PictureModel(R.drawable.aceblack),
            PictureModel(R.drawable.jokerdiamond),
            PictureModel(R.drawable.qeenheart),
        ).apply { shuffle() }

    }

    fun updateShowVisibleCard(id: String,navController: NavHostController,score: Int) {
        val selects: List<PictureModel>? = pictures.value?.filter { it -> it.isSelect }
        val selectCount: Int = selects?.size ?: 0
        var charFind: Int = 0;
        if (selectCount >= 2) {
            val hasSameChar: Boolean = selects!!.get(0).char == selects.get(1).char
            if (hasSameChar) {
                charFind = selects.get(0).char
            }
        }

        val list: MutableList<PictureModel>? = pictures.value?.map { it ->
            if (selectCount >= 2) {
                it.isSelect = false
            }

            if (it.char == charFind) {
                it.isVisible = false
            }

            if (it.id == id) {
                it.isSelect = true
            }

            it
        } as MutableList<PictureModel>?

        val visibleCount: Int = list?.filter { it -> it.isVisible }?.size ?: 0
        if (visibleCount <= 0) {
            nextScreen(navController, score)
            loadPictures()
            return
        }

        pictures.value?.removeAll { true }
        pictures.value = list
    }

}