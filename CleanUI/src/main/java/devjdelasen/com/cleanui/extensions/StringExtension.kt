package devjdelasen.com.cleanui.extensions

import java.util.*


internal fun String.capitalize(): String {
    return this.substring(0, 1).toUpperCase(Locale.ROOT) + this.substring(1)
}