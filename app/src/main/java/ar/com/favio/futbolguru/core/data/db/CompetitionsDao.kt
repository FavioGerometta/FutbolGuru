package ar.com.favio.futbolguru.core.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import ar.com.favio.futbolguru.core.data.model.Competitions
import io.reactivex.Flowable

@Dao
interface CompetitionsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCompetitions(competitions: List<Competitions>)

    @Query("SELECT * FROM competitions")
    fun queryCompetitions(): Flowable<List<Competitions>>
}