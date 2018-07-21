package de.arraying.arraybot.language

import de.arraying.arraybot.data.database.categories.GuildEntry
import de.arraying.arraybot.data.database.core.Category
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
enum class Message(private val prefix: Boolean = false) {

    CHANNEL_INVALID,
    COMMAND_NAME_PROVIDE,
    COMMAND_NAME_INVALID,
    COMMAND_PERMISSION,
    COMMAND_PREMIUM(true),
    COMMAND_UNAVAILABLE_DEVELOPER,
    COMMAND_UNAVAILABLE_EMBED,
    COMMAND_SUBCOMMAND_UNKNOWN,
    COMMANDS_ANNOUNCER_CHANNEL,
    COMMANDS_ANNOUNCER_CHANNEL_INVALID,
    COMMANDS_ANNOUNCER_CHANNEL_NONE,
    COMMANDS_ANNOUNCER_EMBED_DESCRIPTION,
    COMMANDS_ANNOUNCER_EMBED_VALUE(true),
    COMMANDS_ANNOUNCER_MESSAGE,
    COMMANDS_ANNOUNCER_MESSAGE_LENGTH,
    COMMANDS_ANNOUNCER_MESSAGE_NONE,
    COMMANDS_ANNOUNCER_PROVIDE,
    COMMANDS_ANNOUNCER_TOGGLE_ON,
    COMMANDS_ANNOUNCER_TOGGLE_OFF,
    COMMANDS_ANNOUNCER_UPDATED,
    COMMANDS_ANNOUNCER_WARNING,
    COMMANDS_AUTOROLE_EMBED_DESCRIPTION,
    COMMANDS_AUTOROLE_EMBED_VALUE(true),
    COMMANDS_AUTOROLE_ROLE_PROVIDE,
    COMMANDS_AUTOROLE_SHOW,
    COMMANDS_AUTOROLE_SHOW_NONE,
    COMMANDS_AUTOROLE_SHOW_INVALID,
    COMMANDS_AUTOROLE_TOGGLE_ON,
    COMMANDS_AUTOROLE_TOGGLE_OFF,
    COMMANDS_AUTOROLE_UPDATED,
    COMMANDS_AUTOROLE_WARNING,
    COMMANDS_CLEAR_BOUND,
    COMMANDS_CLEAR_CLEAR,
    COMMANDS_CLEAR_INTEGER,
    COMMANDS_CLEAR_LITTLE,
    COMMANDS_CLEAR_PERMISSION,
    COMMANDS_CLEAR_PROVIDE,
    COMMANDS_COMMANDS_DISABLE_DEVELOPER,
    COMMANDS_COMMANDS_DISABLE_COMMANDS,
    COMMANDS_COMMANDS_DISABLE_DISABLED(true),
    COMMANDS_COMMANDS_EMBED_MAIN_DESCRIPTION,
    COMMANDS_COMMANDS_EMBED_MAIN_VALUE(true),
    COMMANDS_COMMANDS_INFO_ALIASES,
    COMMANDS_COMMANDS_INFO_CATEGORY,
    COMMANDS_COMMANDS_INFO_COMMANDDESCRIPTION,
    COMMANDS_COMMANDS_INFO_DESCRIPTION,
    COMMANDS_COMMANDS_INFO_HELP_TITLE,
    COMMANDS_COMMANDS_INFO_HELP_VALUE,
    COMMANDS_COMMANDS_INFO_NAME,
    COMMANDS_COMMANDS_INFO_PERMISSION,
    COMMANDS_COMMANDS_INFO_SYNTAX,
    COMMANDS_COMMANDS_INFO_TYPE,
    COMMANDS_COMMANDS_ENABLE(true),
    COMMANDS_COMMANDS_LIST_DESCRIPTION(true),
    COMMANDS_CONVERT_MONEY_INVALID,
    COMMANDS_CONVERT_MONEY_NUMBER,
    COMMANDS_CONVERT_MONEY_RESULT,
    COMMANDS_CONVERT_PROVIDE_FROM,
    COMMANDS_CONVERT_PROVIDE_TO,
    COMMANDS_CONVERT_PROVIDE_VALUE,
    COMMANDS_CONVERT_FROM,
    COMMANDS_CONVERT_VALUE_INVALID,
    COMMANDS_CONVERT_UNKNOWN,
    COMMANDS_CUSTOM_CREATED,
    COMMANDS_CUSTOM_DELETED,
    COMMANDS_CUSTOM_DESCRIPTION,
    COMMANDS_CUSTOM_DESCRIPTION_LENGTH,
    COMMANDS_CUSTOM_EMBED_DESCRIPTION,
    COMMANDS_CUSTOM_EMBED_VALUE(true),
    COMMANDS_CUSTOM_EXISTS,
    COMMANDS_CUSTOM_LIST(true),
    COMMANDS_CUSTOM_NAME_LENGTH,
    COMMANDS_CUSTOM_NOT_EXISTS,
    COMMANDS_CUSTOM_PROVIDE_DESCRIPTION,
    COMMANDS_CUSTOM_PROVIDE_NAME,
    COMMANDS_CUSTOM_PROVIDE_PERMISSION,
    COMMANDS_CUSTOM_PROVIDE_SYNTAX,
    COMMANDS_CUSTOM_PROVIDE_TYPE,
    COMMANDS_CUSTOM_PROVIDE_VALUE,
    COMMANDS_CUSTOM_UPDATED,
    COMMANDS_CUSTOM_VALUE_LENGTH,
    COMMANDS_EIGHTBALL_ANSWER_DEFINITELY,
    COMMANDS_EIGHTBALL_ANSWER_MAYBE,
    COMMANDS_EIGHTBALL_ANSWER_NO,
    COMMANDS_EIGHTBALL_ANSWER_NOT,
    COMMANDS_EIGHTBALL_ANSWER_YES,
    COMMANDS_EIGHTBALL_EIGHTBALL,
    COMMANDS_EIGHTBALL_PROVIDE,
    COMMANDS_EVAL_CODE_PROVIDE,
    COMMANDS_EVAL_ENGINE_INVALID,
    COMMANDS_EVAL_ENGINE_PROVIDE,
    COMMANDS_EVAL_ERROR,
    COMMANDS_EVAL_EVALUATED,
    COMMANDS_FILTER_ADD,
    COMMANDS_FILTER_BYPASS_ADD,
    COMMANDS_FILTER_BYPASS_ID_EXISTS,
    COMMANDS_FILTER_BYPASS_ID_NUMBER,
    COMMANDS_FILTER_BYPASS_INFO_DESCRIPTION,
    COMMANDS_FILTER_BYPASS_INFO_TYPE,
    COMMANDS_FILTER_BYPASS_INFO_VALUE,
    COMMANDS_FILTER_BYPASS_LIST_DESCRIPTION(true),
    COMMANDS_FILTER_BYPASS_LIST_TITLE,
    COMMANDS_FILTER_BYPASS_PROVIDE_ID,
    COMMANDS_FILTER_BYPASS_PROVIDE_VALUE,
    COMMANDS_FILTER_BYPASS_REMOVE,
    COMMANDS_FILTER_BYPASS_TYPE_PROVIDE,
    COMMANDS_FILTER_BYPASS_TYPE_INVALID,
    COMMANDS_FILTER_BYPASS_VALUE_INVALID,
    COMMANDS_FILTER_EMBED_DESCRIPTION,
    COMMANDS_FILTER_EMBED_VALUE(true),
    COMMANDS_FILTER_LIST_DESCRIPTION(true),
    COMMANDS_FILTER_LIST_TITLE,
    COMMANDS_FILTER_MESSAGE,
    COMMANDS_FILTER_MESSAGE_LENGTH,
    COMMANDS_FILTER_MESSAGE_NONE,
    COMMANDS_FILTER_PHRASE_LENGTH,
    COMMANDS_FILTER_PHRASE_PROVIDE,
    COMMANDS_FILTER_REGEX_ON,
    COMMANDS_FILTER_REGEX_OFF,
    COMMANDS_FILTER_REMOVED,
    COMMANDS_FILTER_SILENT_ON,
    COMMANDS_FILTER_SILENT_OFF,
    COMMANDS_FILTER_TOGGLE_OFF,
    COMMANDS_FILTER_TOGGLE_ON,
    COMMANDS_FILTER_UPDATED,
    COMMANDS_HELP_EMBED_ANNOUNCEMENT,
    COMMANDS_HELP_EMBED_DESCRIPTION,
    COMMANDS_HELP_EMBED_HELP_TITLE,
    COMMANDS_HELP_EMBED_HELP_VALUE,
    COMMANDS_HELP_EMBED_START_TITLE,
    COMMANDS_HELP_EMBED_START_VALUE(true),
    COMMANDS_HISTORY_EMBED_DESCRIPTION(true),
    COMMANDS_HISTORY_EMBED_TITLE,
    COMMANDS_HISTORY_USER_INVALID(true),
    COMMANDS_HISTORY_USER_PROVIDE,
    COMMANDS_ID_CHANNEL_TEXT,
    COMMANDS_ID_CHANNEL_VOICE,
    COMMANDS_ID_EMBED_DESCRIPTION,
    COMMANDS_ID_EMBED_TITLE,
    COMMANDS_ID_PROVIDE,
    COMMANDS_ID_ROLE,
    COMMANDS_ID_USER,
    COMMANDS_INVITE_EMBED_DESCRIPTION,
    COMMANDS_INVITE_EMBED_TITLE,
    COMMANDS_INVITE_EMBED_VALUE,
    COMMANDS_LANGUAGE_EMBED_DESCRIPTION,
    COMMANDS_LANGUAGE_EMBED_TITLE,
    COMMANDS_LANGUAGE_INVALID,
    COMMANDS_LANGUAGE_UPDATED,
    COMMANDS_LOOKUP_EXISTS,
    COMMANDS_LOOKUP_INTEGER,
    COMMANDS_LOOKUP_PROVIDE,
    COMMANDS_MODLOGS_CHANNEL,
    COMMANDS_MODLOGS_CHANNEL_INVALID,
    COMMANDS_MODLOGS_CHANNEL_NONE,
    COMMANDS_MODLOGS_UPDATED,
    COMMANDS_MUTESETTINGS_EMBED_DESCRIPTION,
    COMMANDS_MUTESETTINGS_EMBED_VALUE(true),
    COMMANDS_MUTESETTINGS_ROLE,
    COMMANDS_MUTESETTINGS_ROLE_NONE,
    COMMANDS_MUTESETTINGS_PERMISSION,
    COMMANDS_MUTESETTINGS_SYNTAX,
    COMMANDS_MUTESETTINGS_UPDATED,
    COMMANDS_OVERRIDE_DEVELOPER(true),
    COMMANDS_OVERRIDE_DISABLED,
    COMMANDS_OVERRIDE_ENABLED,
    COMMANDS_PING_PING,
    COMMANDS_PREFIX_PREFIX,
    COMMANDS_PREFIX_PREFIX_LENGTH,
    COMMANDS_PREFIX_UPDATED,
    COMMANDS_PREMIUM_EMBED_BENEFITS_TITLE,
    COMMANDS_PREMIUM_EMBED_BENEFITS_VALUE,
    COMMANDS_PREMIUM_EMBED_DESCRIPTION,
    COMMANDS_PREMIUM_EMBED_HOW_TITLE,
    COMMANDS_PREMIUM_EMBED_HOW_VALUE,
    COMMANDS_PREMIUM_EMBED_LOCKED_TITLE,
    COMMANDS_PREMIUM_EMBED_LOCKED_VALUE,
    COMMANDS_PREMIUM_EMBED_WHAT_TITLE,
    COMMANDS_PREMIUM_EMBED_WHAT_VALUE,
    COMMANDS_PREMIUM_EMBED_WHY_TITLE,
    COMMANDS_PREMIUM_EMBED_WHY_VALUE,
    COMMANDS_RELOAD_APP,
    COMMANDS_RELOAD_EMBED_DESCRIPTION,
    COMMANDS_RELOAD_EMBED_VALUE(true),
    COMMANDS_RELOAD_INPUT_PROVIDE,
    COMMANDS_RELOAD_LANGUAGES_RELOADED,
    COMMANDS_RELOAD_MODE_PROVIDE,
    COMMANDS_RELOAD_SHARD_ERROR,
    COMMANDS_RELOAD_SHARD_INVALID,
    COMMANDS_RELOAD_SHARD_RELOADED,
    COMMANDS_SCRIPT_ERROR_LINK,
    COMMANDS_SCRIPT_EXECUTED,
    COMMANDS_SCRIPT_PROVIDE,
    COMMANDS_SHARDS_EMBED_DESCRIPTION(true),
    COMMANDS_SHARDS_EMBED_TITLE,
    COMMANDS_SKIN_PROVIDE,
    COMMANDS_STATS_EMBED_CHANNELS_TITLE,
    COMMANDS_STATS_EMBED_CHANNELS_VALUE,
    COMMANDS_STATS_EMBED_COMMANDS_REGISTERED,
    COMMANDS_STATS_EMBED_COMMANDS_RUN,
    COMMANDS_STATS_EMBED_CPU,
    COMMANDS_STATS_EMBED_DESCRIPTION,
    COMMANDS_STATS_EMBED_GUILDS_TITLE,
    COMMANDS_STATS_EMBED_GUILDS_VALUE,
    COMMANDS_STATS_EMBED_JDA,
    COMMANDS_STATS_EMBED_MESSAGES,
    COMMANDS_STATS_EMBED_RAM,
    COMMANDS_STATS_EMBED_THREADS,
    COMMANDS_STATS_EMBED_USERS_TITLE,
    COMMANDS_STATS_EMBED_USERS_VALUE,
    COMMANDS_STATS_EMBED_VERSION,
    COMMANDS_STATS_EMBED_ZEUS,
    COMMANDS_URBAN_EMBED_DESCRIPTION,
    COMMANDS_URBAN_EMBED_DEFINITION,
    COMMANDS_URBAN_EMBED_EXAMPLE,
    COMMANDS_URBAN_NONE,
    COMMANDS_URBAN_PROVIDE,
    CUSTOM_ARGUMENT,
    CUSTOM_ARGUMENT_PROVIDE(true),
    CUSTOM_DESCRIPTION,
    CUSTOM_PERMISSION,
    CUSTOM_SCRIPT_INVALID,
    CUSTOM_SYNTAX_INVALID,
    CUSTOM_TYPE_INVALID,
    CUSTOM_TYPE_IMPLEMENTED,
    CUSTOM_TYPE_PRIVATE,
    CUSTOM_TYPE_ROLE_ADDED,
    CUSTOM_TYPE_ROLE_PERMISSION,
    CUSTOM_TYPE_ROLE_REMOVED,
    CUSTOM_TYPE_ROLE_TOGGLED,
    CUSTOM_TYPE_ROLE_UNKNOWN_ROLE,
    CUSTOM_TYPE_ROLE_UNKNOWN_USER,
    CUSTOM_TYPE_ROLE_VALUE,
    CUSTOM_VALUE_EMPTY,
    CUSTOM_VALUE_LENGTH,
    EMBED_FOOTER,
    EMBED_TITLE_COMMANDS,
    EMBED_TRANSLATED,
    FILTER_MESSAGE,
    FILTER_REGEX,
    MISC_NONE,
    PAGE_FOOTER,
    PAGE_COMMAND_UNKNOWN,
    PERMISSION_PERMISSION,
    PERMISSION_ROLE,
    PERMISSION_INVALID,
    PUNISH_COMMAND_ALREADY_BANNED,
    PUNISH_COMMAND_ALREADY_MUTED,
    PUNISH_COMMAND_FAIL,
    PUNISH_COMMAND_REVOKE_FAIL,
    PUNISH_COMMAND_REVOKE_FIND,
    PUNISH_COMMAND_REVOKE_SUCCESS,
    PUNISH_COMMAND_SELF,
    PUNISH_COMMAND_SUCCESS,
    PUNISH_COMMAND_TIME_INVALID,
    PUNISH_COMMAND_TIME_PROVIDE,
    PUNISH_COMMAND_USER_INVALID,
    PUNISH_COMMAND_USER_PROVIDE,
    PUNISH_EMBED_AUTOMATIC,
    PUNISH_EMBED_EXPIRATION,
    PUNISH_EMBED_EXPIRATION_FOOTER,
    PUNISH_EMBED_REASON,
    PUNISH_EMBED_REASON_DEFAULT,
    PUNISH_EMBED_STAFF,
    PUNISH_EMBED_TITLE,
    PUNISH_EMBED_UNKNOWN,
    PUNISH_EMBED_USER,
    PUNISH_MUTE_INVALID_ROLE,
    PUNISH_MUTE_INVALID_PERMISSION,
    PUNISH_PUNISHMENT,
    PUNISH_REASON_LENGTH,
    PUNISH_TYPE_BAN,
    PUNISH_TYPE_KICK,
    PUNISH_TYPE_MUTE,
    PUNISH_TYPE_SOFTBAN,
    PUNISH_TYPE_TEMPBAN,
    PUNISH_TYPE_TEMPMUTE,
    PUNISH_TYPE_UNBAN,
    PUNISH_TYPE_UNKNOWN,
    PUNISH_TYPE_UNMUTE,
    ROLE_INVALID,
    ROLE_OR_PERMISSION_INVALID,
    SCRIPT_ERROR,
    SCRIPT_ERROR_PREMIUM(true),
    SCRIPT_ERROR_URL;

    /**
     * Returns a usable rest action that can be queued to send to the channel.
     * The replace parameter can be used to format the string.
     */
    fun send(channel: TextChannel, vararg format: String): RestAction<net.dv8tion.jda.core.entities.Message> {
        return channel.sendMessage(getContent(channel.guild.idLong, *format))
    }

    /**
     * Gets the content of the message for the specific guild.
     * The replace parameter can be used to format the string.
     */
    fun getContent(guild: Long, vararg format: String): String {
        val entry = Category.GUILD.entry as GuildEntry
        var content = Languages.getEntry(name.toLowerCase(), entry.fetch(entry.getField(GuildEntry.Fields.LANGUAGE), guild, null))
        if(prefix) {
            content = content.replace("{prefix}", entry.fetch(entry.getField(GuildEntry.Fields.PREFIX), guild, null))
        }
        content = content
                .replace("{github}", "https://github.com/Arraying/arraybot/")
                .replace("{zwsp}", "​")
                .replace("-", "    **-**")
        content = content.format(*format)
        return content
    }

    /**
     * Alias method to get the content of the message.
     */
    fun getContent(channel: TextChannel, vararg format: String): String {
        return getContent(channel.guild.idLong, *format)
    }

}