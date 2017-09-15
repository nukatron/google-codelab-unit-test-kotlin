package com.example.android.testing.notes.addnote

import com.example.android.testing.notes.data.NotesRepository
import com.example.android.testing.notes.util.ImageFile
import com.nhaarman.mockito_kotlin.*
import org.junit.Before
import org.junit.Test
import org.mockito.Matchers

/**
 * Created by nutron on 6/8/17.
 */
class AddNotePresenterTestKtAns {

    // TODO: mock data here
    private val notesRepository: NotesRepository = mock()
    private val imageFile: ImageFile = mock()
    private val addNoteView: AddNoteContract.View = mock()

    private lateinit var addNotePresenter: AddNotePresenter

    @Before
    fun setupAddNotePresenter() {
        // TODO: init AddNotePresenter here
        // Get a reference to the class under test
        addNotePresenter = AddNotePresenter(notesRepository, addNoteView, imageFile)
    }

    @Test
    fun saveNoteToRepository_showsSuccessMessageUi() {
        // showcase we want to stub some method return (need add else case in if image.Exist())
        doReturn(true).whenever(imageFile).exists()

        // TODO: When the presenter is asked to save a note (just uncomment)
        addNotePresenter.saveNote("New Note Title", "Some Note Description")

        // TODO: Then verify the saveNote in repository is called and show Note List is shown in the UI
        verify(notesRepository).saveNote(any())

    }

    @Test
    fun saveNote_emptyNoteShowsErrorUi() {
        // TODO: When the presenter is asked to save an empty note (just uncomment)
        addNotePresenter.saveNote("", "")

        // TODO: Then an empty not error is shown in the UI
        verify(addNoteView).showEmptyNoteError()

    }

    @Test
    fun takePicture_CreatesFileAndOpensCamera() {
        // TODO: When the presenter is asked to take an image
        addNotePresenter.takePicture()

        // TODO: Then an image file is created and camera is opened
        verify(imageFile).create(any(), any())
        // TODO: verify imageFile.getPath() is called
        verify(imageFile).path
        // TODO: verify view call to open camera
        verify(addNoteView).openCamera(any())

    }

    @Test
    fun imageAvailable_SavesImageAndUpdatesUiWithThumbnail() {
        // Given an a stubbed image file
        val imageUrl = "path/to/file"
        // TODO: stub method calling here (just uncomment)
        doReturn(true).whenever(imageFile).exists()
        doReturn(imageUrl).whenever(imageFile).path

        // TODO: When an image is made available to the presenter -> call imageAvailable
        addNotePresenter.imageAvailable()

        // TODO: Then the preview image of the stubbed image is shown in the UI
        verify(addNoteView).showImagePreview(Matchers.contains(imageUrl))
    }

    @Test
    fun imageAvailable_FileDoesNotExistShowsErrorUi() {
        // TODO: Given the image file does not exist -> add `when`
        doReturn(false).whenever(imageFile).exists()

        // TODO: When an image is made available to the presenter -> call imageAvailable
        addNotePresenter.imageAvailable()

        // TODO: Then an error is shown in the UI and the image file is deleted
        inOrder(imageFile, addNoteView) {
            verify(imageFile).delete()
            verify(addNoteView).showImageError()
        }

    }

    @Test
    fun noImageAvailable_ShowsErrorUi() {
        // TODO: When the presenter is notified that image capturing failed -> call imageCaptureFailed
        addNotePresenter.imageCaptureFailed()

        // TODO: Then an error is shown in the UI and the image file is deleted
        verify(imageFile).delete()
        verify(addNoteView).showImageError()
    }

}