package ir.arcademy.noteproject.data.model

import java.io.Serializable

data class Note(
    val id: Long,
    val title: String,
    val body: String,
    val dateTime: String,
    val categories: List<Category>
): Serializable