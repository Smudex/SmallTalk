package com.example.smalltalk

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class GroupChatFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: ProfileAdapter

    lateinit var lineGroupChat: View
    lateinit var lineChat: View
    lateinit var groupChat: TextView
    lateinit var chat: TextView
    private lateinit var settings: TextView
    lateinit var newMessage: TextView

    lateinit var statusLine: View
    lateinit var statusOffOn: TextView

    private lateinit var sharedPreferences: SharedPreferences
    var sharedPrefKey = "STATUS_KEY_OFF_ON"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_group_chat, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        statusLine = view.findViewById((R.id.view_status_Line))
        statusOffOn = view.findViewById(R.id.textView_status_OffOn)

        sharedPreferences = requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)

        settings = view.findViewById(R.id.textView_Settings)

        settings.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                setReorderingAllowed(true)
                add<FragmentSettings>(R.id.Main_Frame)
                addToBackStack(null)
            }

        }

        lineGroupChat = view.findViewById(R.id.Line_GroupChat)
        lineChat = view.findViewById(R.id.Line_Chat)


        groupChat = view.findViewById(R.id.textView_Group_Chat)
        chat = view.findViewById(R.id.textView_Chat)

        lineChat.setBackgroundColor(getResources().getColor(R.color.gray))

        groupChat.setOnClickListener {
            lineGroupChat.setBackgroundColor(getResources().getColor(R.color.black))
            lineChat.setBackgroundColor(getResources().getColor(R.color.gray))

        }

        chat.setOnClickListener {
            lineChat.setBackgroundColor(getResources().getColor(R.color.black))
            lineGroupChat.setBackgroundColor(getResources().getColor(R.color.gray))
        }


        val profiles = listOf(
            Message("Sander", "Hei, Øivind. Går det bra?", Date()),
            Message("Øivind", "Hei, Det går RÆVA!", Date()),
            Message("David", "RÆÆÆÆVA?? Covid mannen.", Date()),
            Message("Øivind", "Ja, heia Covid!", Date()),
            Message("Sander", "Du er full du?", Date()),
            Message("Øivind", "Ja, på CocaCola/Lime?", Date()),
            Message("David", "Æsj...", Date())
        )


        recyclerView = view.findViewById(R.id.recyclerView_Group)

        layoutManager = LinearLayoutManager(activity)

        adapter = ProfileAdapter(profiles)




        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun onResume() {

        val online = sharedPreferences.getBoolean(sharedPrefKey, true)

        if (!online) {
            statusLine.setBackgroundColor(getResources().getColor(R.color.SoftGreen))
            statusOffOn.text = "Online"
        } else {
            statusLine.setBackgroundColor(getResources().getColor(R.color.PinkRed))
            statusOffOn.text = "Offline"
        }
        super.onResume()
    }


}