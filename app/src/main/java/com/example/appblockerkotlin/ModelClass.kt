package com.example.appblockerkotlin

import android.os.Parcel
import android.os.Parcelable

data class ModelClass(val app_name: String?, val app_package: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(app_name)
        parcel.writeString(app_package)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelClass> {
        override fun createFromParcel(parcel: Parcel): ModelClass {
            return ModelClass(parcel)
        }

        override fun newArray(size: Int): Array<ModelClass?> {
            return arrayOfNulls(size)
        }
    }
}