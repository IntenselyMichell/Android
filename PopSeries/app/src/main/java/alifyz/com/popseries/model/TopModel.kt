package alifyz.com.popseries.model

import alifyz.com.popseries.database.entity.Top
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TopModel {

    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null
    @SerializedName("results")
    @Expose
    var results: List<Top>? = null
}