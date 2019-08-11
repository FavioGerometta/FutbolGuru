package ar.com.favio.futbolguru.core.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import ar.com.favio.futbolguru.core.data.model.Competitions
import ar.com.favio.futbolguru.core.data.model.Season
import ar.com.favio.futbolguru.utils.Converters

@Database(entities = arrayOf(Competitions::class, Season::class), version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun competitionsDao(): CompetitionsDao
}