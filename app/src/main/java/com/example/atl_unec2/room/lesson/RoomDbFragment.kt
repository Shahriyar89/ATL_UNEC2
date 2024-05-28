package com.example.atl_unec2.room.lesson

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.atl_unec2.databinding.FragmentRoomDbBinding
import com.example.atl_unec2.room.sign_in_up.db.MyDatabase

class RoomDbFragment : Fragment() {
    private var _binding: FragmentRoomDbBinding? = null
    private val binding get() = _binding!!


    companion object {
        const val SHARED_PREFERENCE_KEY = "preference_file_key"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoomDbBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        setSharedPreference()

//        setRoomDb()


    }


    private fun setSharedPreference() {
        //init shared
        val sharedPref =
            requireActivity().getSharedPreferences("preference_file_key", Context.MODE_PRIVATE)


        binding.addUser.setOnClickListener {

            // edit data
            val editor = sharedPref.edit()
            editor.putString("username", binding.userName.text.toString())
            editor.apply()


            //get data
            val name = sharedPref.getString("username", "")
            Toast.makeText(requireContext(), "$name", Toast.LENGTH_SHORT).show()


        }
    }


    private fun setRoomDb() {
        val db: CustomRoomDao = MyDatabase.getInstance(requireContext())?.userDao()!!

        binding.addUser.setOnClickListener {

            //insert to db
            db.insertAll(User(4, firstName = "Elvin", lastName = "Alizade"))
            db.insertAll(User(5, firstName = "Vusel", lastName = "Ceferli"))
            db.insertAll(User(6, firstName = "Teymur", lastName = "Mammadov"))

            //get all User list from db
            val userList = db.getAllUser()
            Toast.makeText(requireContext(), "${userList.size}", Toast.LENGTH_SHORT).show()


            //update user in db
            db.updateUser((User(4, firstName = "ELVIN", lastName = "ALIZADE")))

            //delete from db
            db.delete(User(5, firstName = "Vusel", lastName = "Ceferli"))
        }
    }
}