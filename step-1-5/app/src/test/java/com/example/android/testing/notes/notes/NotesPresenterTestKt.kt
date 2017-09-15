package com.example.android.testing.notes.notes

import com.example.android.testing.notes.data.Note
import com.example.android.testing.notes.data.NotesRepository
import com.nhaarman.mockito_kotlin.KArgumentCaptor
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import org.junit.Before
import org.junit.Test

/**
 * Created by nutron on 6/8/17.
 */
class NotesPresenterTestKt {

    private val NOTES = listOf(Note("Title1", "Description1"), Note("Title2", "Description2"))

    private val EMPTY_NOTES = listOf<Note>()

    private val mNotesRepository: NotesRepository = mock()
    private val mNotesView: NotesContract.View = mock()
    /**
     * {@link ArgumentCaptor} is a powerful Mockito API to capture argument values and use them to
     * perform further actions or assertions on them.
     */
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

        // TODO: Then verify add note UI is shown
    }

    @Test
    fun clickOnNote_ShowsDetailUi() {
        // Given a stubbed note by creating mock object
        val requestedNote = Note("Details Requested", "For this note")

        // TODO: When open note details is requested

        // TODO: Then verify detail UI is shown

    }

    @Test
    fun loadNotesFromRepositoryAndLoadIntoView() {
        // TODO: When loading of Notes is requested

        // TODO: Callback is captured and invoked with stubbed notes --> trigger callback

        // TODO: Then progress indicator is hidden and notes are shown in UI
    }
}