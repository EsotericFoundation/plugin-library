package foundation.esoteric.minecraft.plugins.library.messages

import foundation.esoteric.utility.resource.ResourceUtility
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

/**
 * The message manager class provides utility for dealing with messages in your
 * plugin, as well as internationalising your plugin, which means allowing messages
 * to be in a language that the player has selected.
 *
 * If you intend to use the message manager, create a "messages"
 * folder in your "resources" directory.
 */
class MessageManager(plugin: JavaPlugin) {

    private val messagesFolder: File

    init {
        ResourceUtility.getResourceFilePaths("messages").forEach {
            path -> plugin.saveResource(path.toString(), !plugin.config.getBoolean("messages.enable-customisation", false))
        }

        messagesFolder = File(plugin.dataFolder, "messages")
    }
}