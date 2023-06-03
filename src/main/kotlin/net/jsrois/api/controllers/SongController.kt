package net.jsrois.api.controllers

import net.jsrois.api.domain.Song
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/songs2")
class SongController {
    @GetMapping
    fun allSongs() = listOf(
        Song("Como una ola", "Rocio Jurado"),
        Song("Thick as a brick", "Jethro Tull")
    )
}