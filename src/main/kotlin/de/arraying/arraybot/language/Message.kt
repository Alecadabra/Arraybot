package de.arraying.arraybot.language

import de.arraying.arraybot.data.database.categories.GuildEntry
import de.arraying.arraybot.data.database.core.Entry
import net.dv8tion.jda.core.entities.TextChannel
import net.dv8tion.jda.core.requests.RestAction

/**
 * Copyright 2017 Arraying
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
enum class Message {

    COMMAND_UNAVAILABLE_DEVELOPER,
    COMMAND_UNAVAILABLE_EMBED,
    COMMAND_PERMISSION,
    COMMAND_SUBCOMMAND_UNKNOWN,
    COMMANDS_PING_PING;

    /**
     * Sends the message to the channel.
     */
    fun send(channel: TextChannel, replacePrefix: Boolean = false): RestAction<net.dv8tion.jda.core.entities.Message> {
        return channel.sendMessage(content(channel.guild.idLong, replacePrefix))
    }

    /**
     * Gets the message content.
     */
    fun content(channel: TextChannel, replacePrefix: Boolean = false): String {
        return content(channel.guild.idLong, replacePrefix)
    }

    /**
     * Gets the message content.
     */
    fun content(id: Long, replaceBoolean: Boolean = false): String {
        return replace(Languages.get(id, name.toLowerCase().replace("_", ".")), id, replaceBoolean)
    }

    companion object {

        private val githubBase = "https://github.com/Arraying/arraybot/"

        /**
         * Gets a random message.
         */
        fun getMessage(channel: TextChannel, message: String, replacePrefix: Boolean = false): String {
            return replace(Languages.get(channel.guild, message), channel, replacePrefix)
        }

        /**
         * Replaces common placeholders.
         */
        private fun replace(input: String, channel: TextChannel, replacePrefix: Boolean = false): String {
            return replace(input, channel.guild.idLong, replacePrefix)
        }

        /**
         * Replaces common placeholders.
         */
        fun replace(input: String, id: Long, replacePrefix: Boolean = false): String {
            var output = input
                    .replace("{github}", githubBase)
                    .replace("{zwsp}", "​")
                    .replace("-", "    **-**")
            if(replacePrefix) {
                val entry = Entry.Category.GUILD.entry as? GuildEntry ?:
                        throw IllegalStateException("Expected guild entry to be instanceof GuildEntry.")
               output = output.replace("{prefix}", entry.fetch(entry.getField(GuildEntry.Fields.PREFIX), id, null))
            }
            return output
        }
    }

}