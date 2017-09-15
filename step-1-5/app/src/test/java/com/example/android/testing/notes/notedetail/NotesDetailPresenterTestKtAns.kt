package com.example.android.testing.notes.notedetail

import com.example.android.testing.notes.data.Note
import com.example.android.testing.notes.data.NotesRepository
import com.nhaarman.mockito_kotlin.*
import org.junit.Before
import org.junit.Test

/**
 * Created by nutron on 6/8/17.
 */
class NotesDetailPresenterTestKtAns {

    private val INVALID_ID = "INVALID_ID"

    private val TITLE_TEST = "title"

    private val DESCRIPTION_TEST = "description"

    //TODO: add mock data here
    private val noteRepository: NotesRepository = mock()
    private val noteDetailView: NoteDetailContract.View = mock()

    //TODO: add argument captor here
    private lateinit var notesDetailsPresenter: NoteDetailPresenter

    @Before
    fun setupNotesPresenter() {
        // No need to call:
        // MockitoAnnotations.initMocks(this);

        //TODO: init mNotesDetailsPresenter here
        // Get a reference to the class under test
        notesDetailsPresenter =  NoteDetailPresenter(noteRepository, noteDetailView)
    }

    @Test
    fun getNoteFromRepositoryAndLoadIntoView() {
        // Given an initialized NoteDetailPresenter with stubbed note
        val note = Note(TITLE_TEST, DESCRIPTION_TEST)

        //TODO: When notes presenter is asked to open a note
        notesDetailsPresenter.openNote(note.id)

        //TODO: Then note is loaded from model, callback is captured and progress indicator is shown
        //TODO: When note is finally loaded --> Trigger callback
        argumentCaptor<NotesRepository.GetNoteCallback>().apply {
            verify(noteRepository).getNote(eq(note.id), capture())
            firstValue.onNoteLoaded(note)
        }

        //TODO: Then progress indicator is hidden and title and description are shown in UI
        inOrder(noteDetailView) {
            verify(noteDetailView).setProgressIndicator(true)
            verify(noteDetailView).setProgressIndicator(false)
            verify(noteDetailView).showTitle(TITLE_TEST)
            verify(noteDetailView).showDescription(DESCRIPTION_TEST)
        }
    }

    @Test
    fun getUnknownNoteFromRepositoryAndLoadIntoView() {
        // TODO: When loading of a note is requested with an invalid note ID.
        notesDetailsPresenter.openNote(INVALID_ID)

        // TODO: Then note with invalid id is attempted to load from model, callback is captured and
        // TODO: progress indicator is shown.
        argumentCaptor<NotesRepository.GetNoteCallback>().apply {
            verify(noteRepository).getNote(eq(INVALID_ID), capture())
            firstValue.onNoteLoaded(null)
        }

        // TODO: Then progress indicator is hidden and missing note UI is shown
        inOrder(noteDetailView) {
            verify(noteDetailView).setProgressIndicator(true)
            verify(noteDetailView).setProgressIndicator(false)
            verify(noteDetailView).showMissingNote()
        }
    }
}