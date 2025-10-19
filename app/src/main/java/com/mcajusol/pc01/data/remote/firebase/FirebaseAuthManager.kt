package com.mcajusol.pc01.data.remote.firebase

import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await
import java.time.LocalDateTime

private val FirebaseAuthManager.firestore: Any

object FirebaseAuthManager {
    private val auth = FirebaseAuth.getInstance()
    private val filestore = FirebaseFirestore.getInstance()


    suspend fun loginUser(email: String, password: String): Result<Unit> {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            //auth.signOut()
            Result.success(Unit)


        }catch (e : Exception){
            Result.failure(e)
        }
    }

    suspend fun registerMoneda(uid: String,  monedaOrigen: String,monedaDestino: String, resultado: Double,monto: Double): Result<Unit> {
        return try {

            val monedaResultado = hashMapOf(
                "uid" to uid,
                "monedaOrigen" to monedaOrigen,
                "monedaDestino" to monedaDestino,
                "resultado" to resultado,
                "monto" to monto,
                "createdAt" to LocalDateTime.now()
            )
            firestore.collection("monedas").document(uid).set(monedaResultado).await()
            Result.success(Unit)


        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

