package com.example.smalltalk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class LoginFragment : Fragment() {

    lateinit var emailUsername: EditText
    lateinit var password: EditText
    lateinit var buttonLogin: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)
        emailUsername = view.findViewById(R.id.editTextTextEmail_Username)
        password = view.findViewById(R.id.editTextTextPassword)
        buttonLogin = view.findViewById(R.id.button_log_In)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogin.setOnClickListener {
            (activity as MainActivity).login(emailUsername.text.toString(), password.text.toString())

        }
    }
}


