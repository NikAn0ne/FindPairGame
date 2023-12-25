package com.example.findpairgame.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.findpairgame.navigation.Screen

class PictureViewModel : ViewModel() {
    private val pictures: MutableLiveData<MutableList<PictureModel>> by lazy {
        MutableLiveData<MutableList<PictureModel>>()
    }
    fun getPictures(): LiveData<MutableList<PictureModel>>{
        return pictures
    }
    private fun nextScreen(navController: NavHostController){
        navController.navigate(Screen.ResultScreen.route)
    }

    fun loadPictures(){
        pictures.value = mutableListOf(
            PictureModel("😍"),
            PictureModel("🥰"),
            PictureModel("😘"),
            PictureModel("😭"),
            PictureModel("😢"),
            PictureModel("😂"),
            PictureModel("😍"),
            PictureModel("🥰"),
            PictureModel("😘"),
            PictureModel("😭"),
            PictureModel("😢"),
            PictureModel("😂"),
        ).apply { shuffle() }

    }

    fun updateShowVisibleCard(id: String,navController: NavHostController) {
        val selects: List<PictureModel>? = pictures.value?.filter { it -> it.isSelect }
        val selectCount: Int = selects?.size ?: 0
        var charFind: String = "";
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
            nextScreen(navController)
            loadPictures()
            return
        }

        pictures.value?.removeAll { true }
        pictures.value = list
    }

}