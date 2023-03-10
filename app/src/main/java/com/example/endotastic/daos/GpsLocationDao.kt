package com.example.endotastic.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.endotastic.repositories.gpsLocation.GpsLocation

@Dao
interface GpsLocationDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addGpsLocation(gpsLocation: GpsLocation)

    @Insert
    fun addGpsLocations(gpsLocations: List<GpsLocation>)

    @Query("SELECT * FROM gps_location_table WHERE gpsSessionId = :gpsSessionId ORDER BY id ASC")
    fun getAllBySessionId(gpsSessionId: Int): List<GpsLocation>
}