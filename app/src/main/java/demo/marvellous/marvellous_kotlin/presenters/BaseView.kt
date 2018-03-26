package demo.marvellous.marvellous_kotlin.presenters

/**
 * Created by leslied on 20/03/2018.
 */
interface BaseView {
    /**
     * This is a general method used for showing some kind of progress during a background task. For example, this
     * method should show a progress bar and/or disable buttons before some background work starts.
     */
    abstract fun showProgress()

    /**
     * This is a general method used for hiding progress information after a background task finishes.
     */
    abstract fun hideProgress()

    /**
     * This method is used for showing error messages on the UI.
     *
     * @param message The error message to be dislayed.
     */
    abstract fun showError(message: String?)
}