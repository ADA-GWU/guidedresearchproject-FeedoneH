package com.mysamples.mvc.model.domain

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


// - Entity class for note table
// - A Parcelable is the Android implementation of the Java Serializable
// - It is used to transfer data between activities or fragments

@Entity(tableName = "tbl_note")
class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    )

    override fun toString(): String {
        return title ?: ""
    }

    // Method #2
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
    }

    // Method #3
    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        // Method #4
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        // Method #5
        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }

    // Method #6
    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (title?.hashCode() ?: 0)
        return result
    }


}