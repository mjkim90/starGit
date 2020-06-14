package km.project.metaweatherdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import km.project.metaweatherdemo.R
import km.project.metaweatherdemo.model.WeatherDataModel
import km.project.metaweatherdemo.views.CustomWeatherView
import kotlinx.android.synthetic.main.list_item_weather_item.view.*

class WeatherLocationAdapter(private val listWeatherData: List<WeatherDataModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_HEADER else TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_HEADER) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_weather_header, parent, false)
            TitleViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_weather_item, parent, false)
            WeatherViewHolder(view)
        }
    }


    override fun getItemCount(): Int {
        return listWeatherData.size + 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == TYPE_HEADER) {
            return
        }

        val itemHolder = holder as WeatherViewHolder
        val lastPosition = position - 1

        itemHolder.txtCityName.text = listWeatherData[lastPosition].location.title
        itemHolder.viewWeatherToday.setWeather(listWeatherData[lastPosition].todayWeather)
        itemHolder.viewWeatherTomorrow.setWeather(listWeatherData[lastPosition].tomorrowWeather)
    }


    inner class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtCityName: TextView = itemView.txt_city_name
        val viewWeatherToday: CustomWeatherView = itemView.view_weather_today
        val viewWeatherTomorrow: CustomWeatherView = itemView.view_weather_tomorrow
    }

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }
}