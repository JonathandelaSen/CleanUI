package devjdelasen.com.cleanuilib

import android.text.format.DateUtils
import devjdelasen.com.cleanui.chat.models.ChatMessageModel
import devjdelasen.com.cleanui.chat.models.ChatMessageModelAbstract
import devjdelasen.com.cleanui.chat.models.FileChatMessageModel
import devjdelasen.com.cleanui.chat.models.ImageChatMessageModel
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class JsonMapping {

    companion object {


        fun getMessages(stringJson: String): ArrayList<ChatMessageModelAbstract>{
            val json = JSONArray(stringJson)
            return getMessages(json)
        }


        private fun getMessages(jsonArray: JSONArray): ArrayList<ChatMessageModelAbstract> {
            val messages: ArrayList<ChatMessageModelAbstract> = ArrayList()
            for (i in 0 until jsonArray.length()) {
                try {
                    if (jsonArray.getJSONObject(i).has(Constants.JSON.IMAGE_URL)) {
                        messages.add(getImageMessage(jsonArray.getJSONObject(i)))
                        continue
                    }
                    if (jsonArray.getJSONObject(i).has(Constants.JSON.FILE_URL)) {
                        messages.add(getFileMessage(jsonArray.getJSONObject(i)))
                        continue
                    }
                    messages.add(getMessage(jsonArray.getJSONObject(i)))
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
            return messages
        }

        @Throws(JSONException::class)
        private fun getImageMessage(json: JSONObject): ImageChatMessageModel {
            val id = json.getString(Constants.JSON._ID)
            var message = ""
                try {
                message = json.getString(Constants.JSON.BODY)
            } catch (e: JSONException) {
            }
            val createdAt = json.getString(Constants.JSON.CREATED_AT)
            val senderId = json.getString(Constants.JSON.SENDER_ID)
            val imageUrl = json.getString(Constants.JSON.IMAGE_URL)
            val receptorId = json.getString(Constants.JSON.RECEPTOR_ID)
            var conversationId = ""
            try {
                conversationId = json.getString(Constants.JSON.CONVERSATION_ID)
            } catch (e: JSONException) {
            }
            return ImageChatMessageModel(
                id = id,
                message = message,
                senderId = senderId,
                imageUrl = imageUrl,
                conversationId = conversationId,
                receptorId = receptorId,
                createdAt = getDate(createdAt))
        }

        @Throws(JSONException::class)
        private fun getFileMessage(json: JSONObject): FileChatMessageModel {
            val id = json.getString(Constants.JSON._ID)
            val createdAt = json.getString(Constants.JSON.CREATED_AT)
            val senderId = json.getString(Constants.JSON.SENDER_ID)
            val fileUrl = json.getString(Constants.JSON.FILE_URL)
            val receptorId = json.getString(Constants.JSON.RECEPTOR_ID)
            var conversationId = ""
            try {
                conversationId = json.getString(Constants.JSON.CONVERSATION_ID)
            } catch (e: JSONException) {
            }
            return FileChatMessageModel(
                id = id,
                senderId = senderId,
                fileUrl = fileUrl,
                conversationId = conversationId,
                receptorId = receptorId,
                createdAt = getDate(createdAt))
        }

        @Throws(JSONException::class)
        private fun getMessage(json: JSONObject): ChatMessageModel {
            val id = json.getString(Constants.JSON._ID)
            val message = json.getString(Constants.JSON.BODY)
            val createdAt = json.getString(Constants.JSON.CREATED_AT)
            val senderId = json.getString(Constants.JSON.SENDER_ID)
            val receptorId = json.getString(Constants.JSON.RECEPTOR_ID)
            var conversationId = ""
            try {
                conversationId = json.getString(Constants.JSON.CONVERSATION_ID)
            } catch (e: JSONException) {
            }
            return ChatMessageModel(id = id, message = message, senderId = senderId, conversationId = conversationId, receptorId = receptorId, createdAt = getDate(createdAt))
        }

        private fun getDate(stringDate: String?): Date {
            if (stringDate == null) {
                throw ParseException("", 0)
            }
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault())
             (simpleDateFormat.parse(stringDate))?.let {
                 return it
             }
            return Date()
        }
    }
}