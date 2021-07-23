package com.example.pupmaag.repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pupmaag.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.example.pupmaag.data.Car
import com.example.pupmaag.data.User
import com.example.pupmaag.data.Zone1
import com.google.firebase.Timestamp
import java.util.*


class FirebaseRepository {
    private val REPO_DEBUG = "REPO_DEBUG"

    private val storage = FirebaseStorage.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val cloud = FirebaseFirestore.getInstance()

    fun uploadUserPhoto(bytes: ByteArray){
        storage.getReference("users")
                .child("${auth.currentUser!!.uid}.jpg")
                .putBytes(bytes)
                .addOnCompleteListener{
                    Log.d(REPO_DEBUG, "COMPLETE UPLOAD PHOTO")
                }
                .addOnSuccessListener {
                    getPhotoDownloadUrl(it.storage)
                }
                .addOnFailureListener{
                    Log.d(REPO_DEBUG, it.message.toString())
                }
    }

    private fun getPhotoDownloadUrl(storage: StorageReference) {
        storage.downloadUrl
                .addOnSuccessListener {
                    updateUserPhoto(it.toString())
                }
                .addOnFailureListener{
                    Log.d(REPO_DEBUG, it.message.toString())
                }
    }

    private fun updateUserPhoto(url: String?) {
        cloud.collection("users")
                .document(auth.currentUser!!.uid)
                .update("image", url)
                .addOnSuccessListener {
                    Log.d(REPO_DEBUG, "UPDATE USER PHOTO!")
                }
                .addOnFailureListener{
                    Log.d(REPO_DEBUG, it.message.toString())
                }
    }

    fun getUserData(): LiveData<User>{
        val cloudResult = MutableLiveData<User>()
        val uid = auth.currentUser?.uid

        cloud.collection("users")
            .document(uid!!)
            .get()
            .addOnSuccessListener {
                val user = it.toObject(User::class.java)
                cloudResult.postValue(user)
            }
            .addOnFailureListener{
                Log.d(REPO_DEBUG, it.message.toString())
            }

        return cloudResult
    }
    fun getCars(): LiveData<List<Car>>{
        val cloudResult = MutableLiveData<List<Car>>()

        cloud.collection("cars")
            .get()
            .addOnSuccessListener {
                val user = it.toObjects(Car::class.java)
                cloudResult.postValue(user)
            }
            .addOnFailureListener{
                Log.d(REPO_DEBUG, it.message.toString())
            }
        return cloudResult
    }
    fun getFavCars(list: List<String>?): LiveData<List<Car>> {
        val cloudResult = MutableLiveData<List<Car>>()

        if(!list.isNullOrEmpty())
            cloud.collection("cars")
               .whereIn("id", list)
               .get()
               .addOnSuccessListener {
                   val resultList = it.toObjects(Car::class.java)
                   cloudResult.postValue(resultList)
               }
               .addOnFailureListener{
                   Log.d(REPO_DEBUG, it.message.toString())
               }
        return cloudResult
    }
    fun addFavCar(car : Car){
        cloud.collection("users")
            .document(auth.currentUser?.uid!!)
            .update("favCars", FieldValue.arrayUnion(car.id))
            .addOnSuccessListener {
                Log.d(REPO_DEBUG, "Dodana do ulubionych")
            }
            .addOnFailureListener{
                Log.d(REPO_DEBUG, it.message.toString())
            }
    }
    fun removeFavCar(car : Car){
        cloud.collection("users")
            .document(auth.currentUser?.uid!!)
            .update("favCars", FieldValue.arrayRemove(car.id))
            .addOnSuccessListener {
                Log.d(REPO_DEBUG, "Usunieta z ulubionych")
            }
            .addOnFailureListener{
                Log.d(REPO_DEBUG, it.message.toString())
            }
    }
    fun createNewUser(user: User){
        cloud.collection("users")
                .document(user.uid!!)
                .set(user)
    }
    fun editProfileData(map: Map<String, String>){
        cloud.collection("users")
                .document(auth.currentUser!!.uid)
                .update(map)
                .addOnSuccessListener {
                    Log.d(REPO_DEBUG, "Zaktualizowano dane!")
                }
                .addOnFailureListener{
                    Log.d(REPO_DEBUG, it.message.toString())
                }
    }
  /*  fun addCustomClass(){ //test do wyjebania
        val data = hashMapOf(
            "cid" to "NBP",
            "date" to Timestamp(Date()),
            "name" to "garaz",
            "test" to true

        )
        cloud.collection("rooms")
            .add(data)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot written with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }
//do testu sprwadzic jak zadziała ten snapshot
    fun addZone1Raport(zone1: Zone1){
        val docRef = cloud.collection("cities").document("SF")
        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                Log.d(TAG, "Current data: ${snapshot.data}")
            } else {
                Log.d(TAG, "Current data: null")
            }
        }


    }

*/


}