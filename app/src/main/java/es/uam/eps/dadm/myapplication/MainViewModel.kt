package es.uam.eps.dadm.myapplication


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {
    private var liveData = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = liveData

    fun generateNumber() {
        liveData.value = Random.nextInt(100)
    }
}