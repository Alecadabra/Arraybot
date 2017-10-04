package de.arraying.arraybot.language

import de.arraying.arraybot.Arraybot
import org.json.JSONObject
import org.slf4j.LoggerFactory
import java.io.File
import java.util.*
import java.util.regex.Pattern

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
object Languages {

    private val languages = HashMap<String, JSONObject>()
    private val default = Arraybot.getInstance().configuration.botLanguage
    private val filePattern = Pattern.compile("[a-z]{2,}\\.json")
    private val logger = LoggerFactory.getLogger("Languages")
    private var refreshing = false

    /**
     * Refreshes the languages.
     * Loads in all properties from the files into the cache.
     */
    @Throws(Exception::class)
    fun cache() {
        synchronized(this) {
            refreshing = true
            val directory = File("languages")
            if(!directory.exists()) {
                directory.mkdirs()
                throw IllegalStateException("The language directory did not exist, I have created it.")
            }
            for(file in directory.listFiles()) {
                var name = file.name
                if(!filePattern.matcher(name).find()) {
                    continue
                }
                name = name.substring(0, name.lastIndex - 4)
                languages.put(name, JSONObject(file.readText()))
                logger.info("Registered the language \"$name\"")
            }
            if(languages.isEmpty()) {
                throw IllegalArgumentException("No valid language were found.")
            }
            if(!languages.containsKey(Arraybot.getInstance().configuration.botLanguage)) {
                throw IllegalArgumentException("The default language specified does not exist.")
            }
            refreshing = false
        }
    }

    /**
     * Gets the text specified for the language.
     */
    fun getEntry(key: String, guildLanguage: String): String {
        while(refreshing) {
            Thread.sleep(50)
        }
        val language = if(languages.containsKey(guildLanguage)) guildLanguage else default
        return if(!languages[language]!!.has(key)) {
                return if(!languages[default]!!.has(key)) {
                    "Something went very wrong. Contact a developer if you see this message."
                } else {
                    languages[default]!!.getString(key)
                }
            } else {
                languages[language]!!.getString(key)
            }
    }

    /**
     * Checks if the default language contains the key.
     */
    fun has(key: String) = languages[default]!!.has(key)

}