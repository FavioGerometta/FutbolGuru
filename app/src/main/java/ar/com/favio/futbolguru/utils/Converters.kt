package ar.com.favio.futbolguru.utils
import android.arch.persistence.room.TypeConverter
import ar.com.favio.futbolguru.core.data.model.Season
import com.squareup.moshi.Moshi

class Converters {

    @TypeConverter
    fun fromSeason(season: Season): String {
        return Moshi.Builder().build().adapter(Season::class.java).toJson(season)
    }

    @TypeConverter
    fun toSeason(season: String): Season {
        return Moshi.Builder().build().adapter(Season::class.java).fromJson(season)!!
    }
}