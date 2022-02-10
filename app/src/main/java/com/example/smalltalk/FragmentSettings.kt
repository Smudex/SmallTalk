package com.example.smalltalk

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class FragmentSettings : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var profilePicture: ImageView
    lateinit var profileInfo: TextView
    lateinit var online: TextView
    lateinit var offline: TextView
    lateinit var editProfile: TextView
    lateinit var changePhoto: TextView
    lateinit var changePassword: TextView
    lateinit var help: TextView
    lateinit var back: TextView
    lateinit var save: TextView
    lateinit var logOut: TextView
    lateinit var lineOnline: View
    lateinit var lineOffline: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)

        lineOnline = view.findViewById(R.id.Line_Online)
        lineOffline = view.findViewById(R.id.Line_Offline)

        online = view.findViewById(R.id.textView_Online)
        offline = view.findViewById(R.id.textView_Offline)

        lineOnline.setBackgroundColor(getResources().getColor(R.color.black))
        lineOffline.setBackgroundColor(getResources().getColor(R.color.gray))

        online.setOnClickListener {
            lineOnline.setBackgroundColor(getResources().getColor(R.color.black))
            lineOffline.setBackgroundColor(getResources().getColor(R.color.gray))
            sharedPreferences.edit().putBoolean("STATUS_KEY_OFF_ON", true).apply()

        }

        offline.setOnClickListener {
            lineOffline.setBackgroundColor(getResources().getColor(R.color.black))
            lineOnline.setBackgroundColor(getResources().getColor(R.color.gray))
            sharedPreferences.edit().putBoolean("STATUS_KEY_OFF_ON", false).apply()

        }

    }
}

// color FFB1BCBE (chat_cell)
