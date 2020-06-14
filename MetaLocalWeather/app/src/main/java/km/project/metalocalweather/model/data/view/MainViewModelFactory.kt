package km.project.metalocalweather.model.data.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import km.project.metalocalweather.`interface`.APIRequest

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val apiRequest: APIRequest) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(apiRequest) as T
    }
}