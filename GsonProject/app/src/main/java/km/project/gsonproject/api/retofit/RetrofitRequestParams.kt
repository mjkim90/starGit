package km.project.gsonproject.api.retofit

class RetrofitRequestParams : LinkedHashMap<String, Any>() {
    fun add(key: String, value: Any) {
        if (value is ArrayList<*>) {
            value.forEachIndexed { index, innerValue ->
                this["$key[$index]"] = innerValue
            }
        } else {
            this[key] = value
        }
    }
}