package com.discord.bikumin.service

import com.discord.bikumin.model.GuildSettings

class GuildSettingsService(val mongoService: MongoService) {

    fun getGuildSettings(guildId: Long) : GuildSettings {
        mongoService.apply {
            val doc = findGuildSettings(guildId)
            if(doc == null){
                val settings = GuildSettings(guildId)
                replaceGuildSettings(guildId, settings.toDocument())
                return settings
            }
            return GuildSettings.fromDocument(doc)
        }
    }
}