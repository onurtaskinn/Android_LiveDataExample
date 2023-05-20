package es.uam.eps.dadm.myapplication


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel: ViewModel() {
    private var liveData = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = liveData

    val isEven: LiveData<Boolean> =
        Transformations.switchMap(number, ::transform)

    private fun transform(num: Int): MutableLiveData<Boolean> {
        return if (num % 2 == 0)
            MutableLiveData<Boolean>().apply { value = true }
        else
            MutableLiveData<Boolean>().apply { value = false }
    }

    fun generateNumber() {
        liveData.value = Random.nextInt(100)
    }
}