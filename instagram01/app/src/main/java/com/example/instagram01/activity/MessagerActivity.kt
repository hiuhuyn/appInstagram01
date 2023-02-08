package com.example.instagram01.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram01.R
import com.example.instagram01.adapters.MessageAdapter
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class MessagerActivity : AppCompatActivity() {

    private var item_selected_position: Int = -1
    private var touchPositionX: Int = 0
    private var touchPositionY: Int = 0
    private val messages  = JSONArray()
    private var is_selecting_emoji = false
    private lateinit var emoji_selection_view: View
    private val LAUNCH_EMOJI_ACTIVITY = 1
    private lateinit var message_list_view : ListView
    private lateinit var empty_element : TextView
    private lateinit var sendBtn : ImageButton
    private lateinit var editText : EditText
    private lateinit var attachmentBtn : ImageButton

    private lateinit var adapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messager)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        message_list_view = findViewById(R.id.message_list_view)
        empty_element = findViewById(R.id.empty_element)
        sendBtn = findViewById(R.id.sendBtn)
        editText = findViewById(R.id.editText)
        attachmentBtn = findViewById(R.id.attachmentBtn)


        message_list_view.emptyView = empty_element

        createMessages()

        displayMessages()

        message_list_view.setOnTouchListener(OnTouchListener { view, event ->
            touchPositionX = event.x.toInt()
            touchPositionY = event.y.toInt()
            false
        })

        sendBtn.setOnClickListener {
            val text = editText.text.trim()
            if (text.isNotEmpty()) {
                val msg = JSONObject()
                msg.put("Text", text)
                msg.put("Hour", SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date()))
                msg.put("Speaker", "me")
                msg.put("Emoji", "")
                messages.put(msg)

                adapter.notifyDataSetChanged();

                //val ring: MediaPlayer = MediaPlayer.create(applicationContext, R.raw.send)
                //ring.start()

                scrollToBottom()
                editText.setText("")
            }
        }

        attachmentBtn.setOnClickListener {

        }

        // Set title bar
        title = "Yutar";
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun createMessages() {

        var msg = JSONObject()
        msg.put("Text", "Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ ")
        msg.put("Hour", "20:40")
        msg.put("Speaker", "other")
        msg.put("Emoji", "")
        messages.put(msg)

        msg = JSONObject()
        msg.put("Text", "Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ")
        msg.put("Hour", "20:40")
        msg.put("Speaker", "other")
        msg.put("Emoji", "")
        messages.put(msg)

        msg = JSONObject()
        msg.put("Text", "Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ")
        msg.put("Hour", "20:42")
        msg.put("Speaker", "me")
        msg.put("Emoji", "")
        messages.put(msg)

        msg = JSONObject()
        msg.put("Text", "Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ")
        msg.put("Hour", "20:43")
        msg.put("Speaker", "me")
        msg.put("Emoji", "")
        messages.put(msg)

        msg = JSONObject()
        msg.put("Text", "Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ")
        msg.put("Hour", "20:43")
        msg.put("Speaker", "me")
        msg.put("Emoji", "heart")
        messages.put(msg)

        msg = JSONObject()
        msg.put("Text", "Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ")
        msg.put("Hour", "20:44")
        msg.put("Speaker", "me")
        msg.put("Emoji", "")
        messages.put(msg)

        msg = JSONObject()
        msg.put("Text", "Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ")
        msg.put("Hour", "20:47")
        msg.put("Speaker", "other")
        msg.put("Emoji", "")
        messages.put(msg)

        msg = JSONObject()
        msg.put("Text", "Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ")
        msg.put("Hour", "20:48")
        msg.put("Speaker", "other")
        msg.put("Emoji", "")
        messages.put(msg)

        msg = JSONObject()
        msg.put("Text", "Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ")
        msg.put("Hour", "20:48")
        msg.put("Speaker", "other")
        msg.put("Emoji", "")
        messages.put(msg)

        msg = JSONObject()
        msg.put("Text", "Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ")
        msg.put("Hour", "20:49")
        msg.put("Speaker", "me")
        msg.put("Emoji", "")
        messages.put(msg)

        msg = JSONObject()
        msg.put("Text", "Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ Hệ")
        msg.put("Hour", "20:52")
        msg.put("Speaker", "other")
        msg.put("Emoji", "like")
        messages.put(msg)

        msg = JSONObject()
        msg.put("Text", "Hệ Hệ  \uD83D\uDE18")
        msg.put("Hour", "20:53")
        msg.put("Speaker", "me")
        msg.put("Emoji", "")
        messages.put(msg)
    }

    private fun scrollToBottom(){
        message_list_view.post(Runnable { // Select the last row so it will scroll into view...
            message_list_view.setSelection(adapter.count - 1)
        })
    }

    private fun displayMessages() {
        adapter = MessageAdapter(this, messages)
        message_list_view.adapter = adapter

        scrollToBottom()

        // Long press
        message_list_view.setOnItemLongClickListener { parent, view, position, id ->
            val element = adapter.getItem(position) // The item that was clicked

            val item: JSONObject = adapter.getItem(position) as JSONObject // The item that was clicked

            Log.d("MESSAGES", "Touched: $element")
            Log.d("MESSAGES", "X: $view.x, Y: $view.y")
            Log.d("MESSAGES", "X: $touchPositionX, Y: $touchPositionY")

            emoji_selection_view = view
            item_selected_position = position
            is_selecting_emoji = true

            val i = Intent(applicationContext, ReactionsActivity::class.java)
            i.putExtra("x", touchPositionX)
            i.putExtra("y", touchPositionY)
            startActivityForResult(i, LAUNCH_EMOJI_ACTIVITY)

            false
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LAUNCH_EMOJI_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data!!.getStringExtra("emoji")
                Log.d("EMOJI", "Res $result")

                val jsonObject: JSONObject = messages.getJSONObject(item_selected_position)
                jsonObject.put("Emoji", result)

                messages.put(item_selected_position, jsonObject)

                adapter.notifyDataSetChanged();
                //val ring: MediaPlayer = MediaPlayer.create(applicationContext, R.raw.pop)
               // ring.start()
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}