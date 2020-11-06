package com.example.myapplication.ui.main

import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.ui.dictation.DictationActivity
import com.example.myapplication.ui.kasper.KasperActivity

sealed class TestType(val intent: Intent, val text: String) {
    class KasperTest(context: Context, text: String) :
        TestType(KasperActivity.newIntent(context), text)

    class DictationTest(context: Context, text: String) :
        TestType(DictationActivity.newIntent(context), text)
}

class MainViewModel @ViewModelInject constructor(application: Application) :
    AndroidViewModel(application) {
    private val listItem =
        MutableLiveData(
            listOf(
                TestType.KasperTest(application.baseContext, "Kasper"),
                TestType.DictationTest(application.baseContext, "Dictation")
            )
        )

    fun getItemList(): LiveData<List<TestType>> = listItem


}

