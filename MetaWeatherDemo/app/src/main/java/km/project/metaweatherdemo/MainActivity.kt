package km.project.metaweatherdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import km.project.metaweatherdemo.adapter.WeatherLocationAdapter
import km.project.metaweatherdemo.api.APIConsts
import km.project.metaweatherdemo.model.WeatherDataModel
import km.project.metaweatherdemo.util.AlertUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pull to Refresh
        layout_swipe_refresh.apply {
            setOnRefreshListener {
                recycler_view.visibility = View.GONE
                requestSearchWeatherInfo(APIConsts.SE)
            }
        }

        // 지역리스트 반환
        requestSearchWeatherInfo(APIConsts.SE)
    }

    private fun requestSearchWeatherInfo(keyword: String) {
        val weatherSearch = WeatherSearch()
        AlertUtil.showProgress(this@MainActivity)

        weatherSearch.setResultListener(object : WeatherSearch.WeatherSearchListener {
            override fun onSuccess(weatherDataList: List<WeatherDataModel>) {
                layout_swipe_refresh?.isRefreshing = false
                recycler_view.adapter = WeatherLocationAdapter(weatherDataList)
                recycler_view.visibility = View.VISIBLE
                AlertUtil.hideProgress()
            }

            override fun onFailure(message: String?) {
                layout_swipe_refresh?.isRefreshing = false
            }
        })

        weatherSearch.searchWeatherInfo(keyword)
    }

}
