package com.example.android.testing.notes.addnote

import com.example.android.testing.notes.data.NotesRepository
import com.example.android.testing.notes.util.ImageFile
import com.nhaarman.mockito_kotlin.mock
import org.junit.Before
import org.junit.Test

/**
 * Created by nutron on 6/8/17.
 */
class AddNotePresenterTestKt {

    // TODO: mock data here
    private val notesRepository: NotesRepository = mock()
    private val imageFile: ImageFile = mock()
    private val addNoteView: AddNoteContract.View = mock()

    private lateinit var addNotePresenter: AddNotePresenter

    @Before
    fun setupAddNotePresenter() {
        // TODO: init AddNotePresenter here
        // Get a reference to the class under test
//        addNotePresenter = AddNotePresenter(notesRepository, addNoteView, imageFile)
    }

    @Test
    fun saveNoteToRepository_showsSuccessMessageUi() {
        // NOTE: showcase we want to stub some method return (need add else case in if image.Exist())
        // NOTE: it difference from ->  whenever(imageFile.exists()).thenReturn(true)
//        doReturn(true).whenever(imageFile).exists()


        // TODO: When the presenter is asked to save a note (just uncomment)
//        addNotePresenter.saveNote("New Note Title", "Some Note Description")

        // TODO: Then verify the saveNote in repository is called and show Note List is shown in the UI

    }

    @Test
    fun saveNote_emptyNoteShowsErrorUi() {
        // TODO: When the presenter is asked to save an empty note (just uncomment)
//        addNotePresenter.saveNote("", "")

        // TODO: Then an empty not error is shown in the UI

    }

    @Test
    fun takePicture_CreatesFileAndOpensCamera() {
        // TODO: When the presenter is asked to take an image

        // TODO: Then an image file is created and camera is opened

        // TODO: verify imageFile.getPath() is called

        // TODO: verify view call to open camera

    }

    @Test
    fun imageAvailable_SavesImageAndUpdatesUiWithThumbnail() {
        // Given an a stubbed image file
        val imageUrl = "path/to/file"
        // TODO: stub method calling here (just uncomment)

        // TODO: When an image is made available to the presenter -> call imageAvailable

        // TODO: Then the preview image of the stubbed image is shown in the UI
    }

    @Test
    fun imageAvailable_FileDoesNotExistShowsErrorUi() {
        // TODO: Given the image file does not exist -> add `when`

        // TODO: When an image is made available to the presenter -> call imageAvailable

        // TODO: Then an error is shown in the UI and the image file is deleted

    }

    @Test
    fun noImageAvailable_ShowsErrorUi() {
        // TODO: When the presenter is notified that image capturing failed -> call imageCaptureFailed

        // TODO: Then an error is shown in the UI and the image file is deleted
    }

}