package usecase_adaptor.DeleteWatchlist;

import use_case.DeleteWatchlist.DeleteWatchlistOutputBoundary;
import use_case.DeleteWatchlist.DeleteWatchlistOutputData;

public class DeleteWatchlistPresenter implements DeleteWatchlistOutputBoundary {

    private final DeleteWatchlistViewModel viewModel;

    /**
     * initiate a presenter.
     *
     * @param viewModel a view model object.
     */
    public DeleteWatchlistPresenter(DeleteWatchlistViewModel viewModel) {

        this.viewModel = viewModel;
    }

    /**
     * prepare view if failed to add.
     *
     * @param error string of error message when add failed.
     */
    @Override
    public void PrepareFailView(String error) {
        DeleteWatchlistState state = viewModel.getState();
        state.setMovieExistError(error);
        viewModel.firePropertyChanged();

    }

    /**
     * prepare view if success added.
     *
     * @param outputData that involve the movie being added.
     */
    @Override
    public void PrepareSuccessView(DeleteWatchlistOutputData outputData) {
        DeleteWatchlistState state = viewModel.getState();
        state.setMessage(outputData.getMessage());
        viewModel.firePropertyChanged();

    }
}