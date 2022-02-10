package com.example.smalltalk

import android.content.SharedPreferences
import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var main: FrameLayout
    lateinit var loginFragment: LoginFragment
    lateinit var fragmentGroupChat: GroupChatFragment
    lateinit var settings: FragmentSettings
    var sPKey = "LOGIN_LOGOUT"

    var loggetInn: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main = findViewById(R.id.Main_Frame)
        loginFragment = LoginFragment()
        fragmentGroupChat = GroupChatFragment()
        settings = FragmentSettings()
        sharedPreferences = getPreferences(MODE_PRIVATE)
        loggetInn = sharedPreferences.getBoolean(sPKey, false)
        if (loggetInn) {
            supportFragmentManager.commit{
                setReorderingAllowed(true)
                add<GroupChatFragment>(R.id.Main_Frame)
            }
        } else {
            supportFragmentManager.commit{
                setReorderingAllowed(true)
                add<LoginFragment>(R.id.Main_Frame)
            }
        }

    }

    //fun chooseFragment(fragment: Fragment) {
      //  supportFragmentManager.beginTransaction().add(R.id.Main_Frame, fragment).commit()
    //}

    /*
    fun logout() {
        loggetInn = false
        chooseFragment(loginFragment)
        sharedPreferences.edit().putBoolean(sPKey, loggetInn).apply()
    }
*/
    fun login(username: String, password: String) {

        if (username == "s" && password == "s") {
            loggetInn = true
            supportFragmentManager.commit{
                setReorderingAllowed(true)
                add<GroupChatFragment>(R.id.Main_Frame)
            }
            loginFragment.emailUsername.text.clear()
            loginFragment.password.text.clear()
            sharedPreferences.edit().putBoolean(sPKey, loggetInn).apply()

        } else {
            Toast.makeText(
                applicationContext,
                "Wrong password or username. try again!",
                Toast.LENGTH_SHORT
            ).show()
            loginFragment.emailUsername.text.clear()
            loginFragment.password.text.clear()

        }
    }


}