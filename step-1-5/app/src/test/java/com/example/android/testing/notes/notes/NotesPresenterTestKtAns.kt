package com.example.android.testing.notes.notes

import com.example.android.testing.notes.data.Note
import com.example.android.testing.notes.data.NotesRepository
import com.nhaarman.mockito_kotlin.KArgumentCaptor
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

/**
 * Created by nutron on 6/8/17.
 */
class NotesPresenterTestKtAns {

    private val NOTES = listOf(Note("Title1", "Description1"), Note("Title2", "Description2"))

    private val EMPTY_NOTES = listOf<Note>()

    private val mNotesRepository: NotesRepository = mock()
    private val mNotesView: NotesContract.View = mock()
    private val argCaptor: KArgumentCaptor<NotesRepository.LoadNotesCallback> = argumentCaptor()

    private lateinit var mNotesPresenter: NotesPresenter

    @Before
    fun setupNotesPresenter() {
        // no need to call:
        // MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mNotesPresenter = NotesPresenter(mNotesRepository, mNotesView)
    }

    @Test
    fun clickOnFab_ShowsAddsNoteUi() {
        // TODO: When adding a new note
        mNotesPresenter.addNewNote()

        // TODO: Then verify add note UI is shown
        verify(mNotesView).showAddNote()
    }

    @Test
    fun clickOnNote_ShowsDetailUi() {
        // Given a stubbed note by creating mock object
        val requestedNote = Note("Details Requested", "For this note")

        // TODO: When open note details is requested
        mNotesPresenter.openNoteDetails(requestedNote)

        // TODO: Then verify detail UI is shown
        verify(mNotesView).showNoteDetailUi(requestedNote.id)

    }

    @Test
    fun loadNotesFromRepositoryAndLoadIntoView() {
        // TODO: When loading of Notes is requested
        mNotesPresenter.loadNotes(true)

        // TODO: Callback is captured and invoked with stubbed notes --> trigger callback
        verify(mNotesRepository).getNotes(argCaptor.capture())
        argCaptor.firstValue.onNotesLoaded(NOTES)

        // TODO: Then progress indicator is hidden and notes are shown in UI
        verify(mNotesView).setProgressIndicator(false)
        verify(mNotesView).showNotes(NOTES)
    }
}