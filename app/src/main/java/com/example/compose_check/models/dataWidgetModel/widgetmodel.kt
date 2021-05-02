package com.example.compose_check.models.dataWidgetModel

import android.os.Parcel
import android.os.Parcelable

data class WidgetModel(val value: Int, val title: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(value)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WidgetModel> {
        override fun createFromParcel(parcel: Parcel): WidgetModel {
            return WidgetModel(parcel)
        }

        override fun newArray(size: Int): Array<WidgetModel?> {
            return arrayOfNulls(size)
        }
    }
}
