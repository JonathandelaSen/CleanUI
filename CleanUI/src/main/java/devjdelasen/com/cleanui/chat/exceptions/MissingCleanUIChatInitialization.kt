package devjdelasen.com.cleanui.chat.exceptions

class MissingCleanUIChatInitialization(override val message: String = ""): Exception(if (message.isBlank()) "You must call init on ChatCleanUI" else message)

