package com.adedom.tictactoe.data.model

import android.os.Parcel
import android.os.Parcelable

data class GameMode(
    val modeId: Int,
    val modeName: String?,
    val size: Int,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(modeId)
        parcel.writeString(modeName)
        parcel.writeInt(size)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GameMode> {
        override fun createFromParcel(parcel: Parcel): GameMode {
            return GameMode(parcel)
        }

        override fun newArray(size: Int): Array<GameMode?> {
            return arrayOfNulls(size)
        }
    }
}
