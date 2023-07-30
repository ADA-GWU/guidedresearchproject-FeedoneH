package com.mysamples.mvp.model.persistence

import androidx.room.*
import androidx.room.Dao
import com.mysamples.mvp.model.domain.Note


// - Interface Dao for Note table sql operations

@Dao
interface NoteDao {

    // Method #1
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note): Long

    // Method #2
    @Update
    fun update(note: Note)

//    // Method #3
//    @Query("delete from tbl_note where id = :id")
//    fun deleteById(id: Int)

    // Method #4
    @Delete
    fun delete(note: Note)

    // Method #5
    @Query("select * from tbl_note")
    fun getAllNotes(): List<Note>
}