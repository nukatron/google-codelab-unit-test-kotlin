package com.example.android.testing.notes.notedetail

import com.example.android.testing.notes.data.Note
import org.junit.Before
import org.junit.Test

/**
 * Created by nutron on 6/8/17.
 */
class NotesDetailPresenterTestKt {

    private val INVALID_ID = "INVALID_ID"

    private val TITLE_TEST = "title"

    private val DESCRIPTION_TEST = "description"

    //TODO: add mock data here

    //TODO: add argument captor here

    private lateinit var notesDetailsPresenter: NoteDetailPresenter

    @Before
    fun setupNotesPresenter() {
        // No need to call:
        // MockitoAnnotations.initMocks(this);

        //TODO: init mNotesDetailsPresenter here
        // Get a reference to the class under test
//        notesDetailsPresenter =  NoteDetailPresenter(noteRepository, noteDetailView)
    }

    @Test
    fun getNoteFromRepositoryAndLoadIntoView() {
        // Given an initialized NoteDetailPresenter with stubbed note
        val note = Note(TITLE_TEST, DESCRIPTION_TEST)

        //TODO: When notes presenter is asked to open a note

        //TODO: Then note is loaded from model, callback is captured and progress indicator is shown
        //TODO: When note is finally loaded --> Trigger callback

        //TODO: Then progress indicator is hidden and title and description are shown in UI
    }

    @Test
    fun getUnknownNoteFromRepositoryAndLoadIntoView() {
        // TODO: When loading of a note is requested with an invalid note ID.

        // TODO: Then note with invalid id is attempted to load from model, callback is captured and
        // TODO: progress indicator is shown.

        // TODO: When note is finally loaded -->  Trigger callback

        // TODO: Then progress indicator is hidden and missing note UI is shown
    }
}