package com.florian.esgiandroid.application

import android.os.Parcel
import android.os.Parcelable

class ProductParcelable() : Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductParcelable> {
        override fun createFromParcel(parcel: Parcel): ProductParcelable {
            return ProductParcelable(parcel)
        }

        override fun newArray(size: Int): Array<ProductParcelable?> {
            return arrayOfNulls(size)
        }
    }
}