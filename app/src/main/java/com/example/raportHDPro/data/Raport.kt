package com.example.raportHDPro.data

import android.os.Parcelable
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Raport (val id: String? = null,
                   val name: String? = null,
                   val zone: String? = null,
                   val date: Timestamp? = null,
                   val control: String? = null,
                   val uid:String? = null,
                   val uemail:String? = null,
                   val TISO001: Boolean?=null,
                   val TISO002: Boolean?=null,
                   val TISO003: Boolean?=null,
                   val TISO004: Boolean?=null,
                   val TISO005: Boolean?=null,
                   val TISO006: Boolean?=null,
                   val TISO007: Boolean?=null,
                   val TISO008: Boolean?=null,
                   val TISO009: Boolean?=null,
                   val TISO010: Boolean?=null,
                   val TISO011: Boolean?=null,
                   val TISO012: Boolean?=null,
                   val TISO013: Boolean?=null,
                   val TISO014: Boolean?=null,
                   val TISO015: Boolean?=null,
                   val TISO016: Boolean?=null,
                   val TISO001_uwagi:String? = null,
                   val TISO002_uwagi:String? = null,
                   val TISO003_uwagi:String? = null,
                   val TISO004_uwagi:String? = null,
                   val TISO005_uwagi:String? = null,
                   val TISO006_uwagi:String? = null,
                   val TISO007_uwagi:String? = null,
                   val TISO008_uwagi:String? = null,
                   val TISO009_uwagi:String? = null,
                   val TISO010_uwagi:String? = null,
                   val TISO011_uwagi:String? = null,
                   val TISO012_uwagi:String? = null,
                   val TISO013_uwagi:String? = null,
                   val TISO014_uwagi:String? = null,
                   val TISO015_uwagi:String? = null,
                   val TISO016_uwagi:String? = null,
                   @DocumentId
                   val documentId: String? = null,
    ):Parcelable