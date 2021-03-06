package alifyz.com.popseries.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SeriesModel : Parcelable {
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
    val results: List<SeriesMetaData>? = null

    inner class SeriesMetaData(
            var id: Int? = null,
            @SerializedName("original_name")
            @Expose
            var originalName: String? = null,
            @SerializedName("name")
            @Expose
            var name: String? = null,
            @SerializedName("popularity")
            @Expose
            var popularity: Double? = null,
            @SerializedName("vote_count")
            @Expose
            var voteCount: Int? = null,
            @SerializedName("vote_average")
            @Expose
            var voteAverage: Double? = null,
            @SerializedName("first_air_date")
            @Expose
            var firstAirDate: String? = null,
            @SerializedName("poster_path")
            @Expose
            var posterPath: String? = null,
            @SerializedName("genre_ids")
            @Expose
            var genreIds: List<Int>? = null,
            @SerializedName("original_language")
            @Expose
            var originalLanguage: String? = null,
            @SerializedName("backdrop_path")
            @Expose
            var backdropPath: String? = null,
            @SerializedName("overview")
            @Expose
            var overview: String? = null,
            @SerializedName("origin_country")
            @Expose
            var originCountry: List<String>? = null
    )

    constructor(source: Parcel) : this()

    constructor()

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {}

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SeriesModel> = object : Parcelable.Creator<SeriesModel> {
            override fun createFromParcel(source: Parcel): SeriesModel = SeriesModel(source)
            override fun newArray(size: Int): Array<SeriesModel?> = arrayOfNulls(size)
        }
    }
}
