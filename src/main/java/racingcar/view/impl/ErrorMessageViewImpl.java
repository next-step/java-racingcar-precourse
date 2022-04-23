package racingcar.view.impl;

import racingcar.view.ErrorMessageView;

public class ErrorMessageViewImpl implements ErrorMessageView {

    @Override
    public void printException(Exception e) {
        System.out.printf(ErrorMessageView.ERROR_MSG_HOLDER, e.getMessage());
    }
}
