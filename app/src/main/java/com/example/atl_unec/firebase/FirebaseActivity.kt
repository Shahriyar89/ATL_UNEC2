package com.example.atl_unec.firebase

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import com.example.atl_unec2.databinding.ActivityFirebaseBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.remoteconfig.ConfigUpdate
import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException

class FirebaseActivity : AppCompatActivity() {


    /**
     * Firebase setup
     * Firebase ile elaqe yaradin Crashlyitics tool -nu proyekte elave edin
     * Crashlytic ucun en azi 3 key ve bir Log gonderin
     *
     * FirebaseRemoteConfig elave ederek bir String deyerin neticesinden asli olaraq ekranda :
     *          - Spinner gelirse verilmis listi spinnerde gosterin
     *          - RecylcerView gelirse Recycler view kimi gosterin
     *
     *          spinner ve recyclerView setirleri eyni layout data classlari da eyni olacaq
     *
     *
     *
     */


    lateinit var binding: ActivityFirebaseBinding
    lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseDb: FirebaseFirestore
    private lateinit var database: DatabaseReference


    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                // FCM SDK (and your app) can post notifications.
            } else {
                // Inform user that your app will not show notifications.
            }
        }


    companion object {
        const val TAG = "FirebaseActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirebaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)

//        setFirebaseAuth()
//        cloudMessage()

        setFirebaseFireStore()


//        setFirebaseRealTimeDB()


//        setFirebaseCrashlytics()
//        setRemoteConfig()
//        addFirebaseAnalyticsEvent()


    }


    fun setFirebaseCrashlytics() {
        binding.firebaseToolsButton.setOnClickListener {
//
//            val crashlytics = FirebaseCrashlytics.getInstance()
////            crashlytics.setUserId("user123456789")
//
//            // Initialize Crashlytics
//
//            crashlytics.log("Button clicked")
//
//            // Set custom keys
//            crashlytics.setCustomKey("app_version", "3.0.1")
//            crashlytics.setCustomKey("user_level", 5)
//            crashlytics.setCustomKey("last_screen", "FirebaseActivity")
//            throw RuntimeException("Test Crash3") // Force a crash
        }

//        addContentView( binding.addToCrashlytics, ViewGroup.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT))
//
    }


    private fun setRemoteConfig() {

        val remoteConfig = FirebaseRemoteConfig.getInstance()

        remoteConfig.setDefaultsAsync(
//            R.xml.firebase_remote_configure
            mapOf(
                "show_toast" to false,
                "show_message" to "default"
            )
        )

        binding.firebaseToolsButton.setOnClickListener {
            remoteConfig.fetchAndActivate()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Use the fetched value
                        val updated = task.result
                        val isShow = remoteConfig.getBoolean("show_toast")
                        val message = remoteConfig.getString("simple_message")
                        if (isShow)
                            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    } else {
                        // Handle fetch failure
                    }
                }
        }

        remoteConfig.addOnConfigUpdateListener(object : ConfigUpdateListener {
            override fun onUpdate(configUpdate: ConfigUpdate) {

            }

            override fun onError(error: FirebaseRemoteConfigException) {
                Log.w("TAG1", "Config update error with code: " + error.code, error)
            }
        })

    }

    private fun addFirebaseAnalyticsEvent() {

        binding.firebaseToolsButton.setOnClickListener {
            val firebaseAnalytics = FirebaseAnalytics.getInstance(this)

            // Log an event
            val bundle = Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "id123")
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "name123")
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "contentType123")
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)


            firebaseAnalytics.logEvent(
                "my_first_event_from_android",
                bundleOf("Name" to "Firebase")
            )
//        firebaseAnalytics.setUserProperty("favorite_food", "pizza")
        }
    }


    private fun setFirebaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance()
        binding.login.setOnClickListener {
            val email = binding.userName.text.toString()
            val password = binding.userPassword.text.toString()
            signIn(email, password)
        }

        binding.register.setOnClickListener {
            val email = binding.userName.text.toString()
            val password = binding.userPassword.text.toString()
            signUp(email, password)
        }
    }


    private fun signUp(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign up success
                    Toast.makeText(
                        baseContext,
                        "Sign Up Successful.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // If sign up fails, display a message to the user.
                    Toast.makeText(
                        baseContext,
                        "Sign Up Failed: ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }


    private fun signIn(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success
                    Toast.makeText(
                        baseContext,
                        "Sign In Successful. user id:  ${task.result.user?.uid}",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext,
                        "Sign In Failed: ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

    }

    private fun cloudMessage() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when {
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED -> {
                    // FCM SDK (and your app) can post notifications.
                }

                shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS) -> {
                    // Display an educational UI explaining to the user why your app requires this permission.
                }

                else -> {
                    // Directly ask for the permission
                    requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            }
        }

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@addOnCompleteListener
            }

            val token = task.result

            Log.d(TAG, "FCM Registration token: $token")
            Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
        }

    }


    private fun setFirebaseFireStore() {
        firebaseDb = FirebaseFirestore.getInstance()

        // Example: Add data
//        addData()

        // Example: Get data
        getData()

        // Example: Update data
//        updateData()

//        deleteData()
    }


    private fun addData() {
        // Create a new user with a first, middle, and last name
        val user = hashMapOf(
            "first" to "AdaM",
            "middle" to "Lovelace",
            "last" to "Byron",
            "born" to 1815
        )

        // Add a new document with a generated ID
        firebaseDb.collection("users1")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    private fun getData() {
        firebaseDb.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }

    private fun updateData() {
        val washingtonRef = firebaseDb.collection("users1").document("sLGcU3ZtgZSepOvSwsx2")

        // Set the "born" field of the user 'Ada' to 1816
        washingtonRef
            .update("born", 2024)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully updated!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error updating document", e) }
    }


    private fun deleteData() {
        val washingtonRef = firebaseDb.collection("users1").document("sLGcU3ZtgZSepOvSwsx2")
        washingtonRef.delete()
            .addOnSuccessListener {
                //silindi
            }
            .addOnFailureListener {
                //ugursuz
            }

    }


    /**
     * realtime Database
     */

    private fun setFirebaseRealTimeDB() {
        database = FirebaseDatabase.getInstance().reference

        // Example: Write data
//        writeData("4", "John Doe", "john@example.com")

        // Example: Read data
//        readData("1")

        // Example: Update data
//        updateData("1", "Jane Doe", "jane@example.com")

        // Example: Delete data
//        deleteData("1")
    }

    private fun writeData(userId: String, name: String, email: String) {
        val user = User(name, email,"121344","shagsdjhagdhj")
        database.child("users").child(userId).setValue(user)
            .addOnSuccessListener {
                Log.d(TAG, "User added successfully")
            }
            .addOnFailureListener {
                Log.e(TAG, "Failed to add user", it)
            }
    }

    private fun readData(userId: String) {
        database.child("users").child(userId).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user = dataSnapshot.getValue(User::class.java)
                user?.let {
                    Log.d(TAG, "User: ${it.name}, Email: ${it.email}")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG, "Failed to read user", error.toException())
            }
        })
    }

    private fun updateData(userId: String, name: String, email: String) {
        val userUpdates = mapOf<String, Any>(
            "name" to name,
            "email" to email
        )
        database.child("users").child(userId).updateChildren(userUpdates)
            .addOnSuccessListener {
                Log.d(TAG, "User updated successfully")
            }
            .addOnFailureListener {
                Log.e(TAG, "Failed to update user", it)
            }
    }

    private fun deleteData(userId: String) {
        database.child("users").child(userId).removeValue()
            .addOnSuccessListener {
                Log.d(TAG, "User deleted successfully")
            }
            .addOnFailureListener {
                Log.e(TAG, "Failed to delete user", it)
            }
    }


    data class User(
        var name: String? = null,
        var email: String? = null,
        var password: String? = null,
        var id: String? = null,
    )
}