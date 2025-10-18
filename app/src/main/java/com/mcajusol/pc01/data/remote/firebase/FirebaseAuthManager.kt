package com.mcajusol.pc01.data.remote.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

object FirebaseAuthManager {
    private val auth = FirebaseAuth.getInstance()
    private val filestore = FirebaseFirestore.getInstance()


}