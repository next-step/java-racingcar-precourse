package racingcar.utils;

import racingcar.view.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ValidationUtils extends IllegalArgumentException{

    public boolean validName(String userInput) {
        List<String> nameList = new ArrayList<>();

        //입력받은 이름 리스트 분리
        splitNameList(userInput, nameList);

        try{
            //이름 입력 값 체크 (아무것도 입력되지 않았거나 쉼표만 입력된 경우)
            validNameValue(nameList);

            //이름 길이 체크 (이름값이 입력되지 않았거나 5자리 초과한 경우 에러)
            validNameLength(nameList);

            //중복값이 입력된 경우 체크
            validNameDuplicate(nameList);
        } catch(IllegalArgumentException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    private boolean splitNameList(String name, List<String> nameList) {
        return Collections.addAll(nameList, name.split(ValidCommonConditionEnum.DELIMITER.getValue()));
    }

    private void validNameValue(List<String> nameList){
        ErrorMessage.checkError(nameList.size() == 0, ErrorMsgEnum.NAME_TYPE_ERR_MSG);
    }

    private void validNameLength(List<String> nameList) {
            for (String name : nameList) {
            validNameZeroValue(name);
            validNameMaxLength(name);
        }
    }

    private void validNameMaxLength(String name) {
        ErrorMessage.checkError(name.length() > 5, ErrorMsgEnum.OVER_MAX_LENGTH_MSG);
    }

    private void validNameZeroValue(String name) {
        ErrorMessage.checkError(name.length() == 0, ErrorMsgEnum.NO_NAME_MSG);
    }


    private void validNameDuplicate(List<String> nameList) {
        HashSet<String> hs = new HashSet<>();
        for (String name : nameList) {
            ErrorMessage.checkError(!hs.add(name.toUpperCase()), ErrorMsgEnum.NAME_DUP_MSG);
        }
    }

   public boolean validRepeat(String repeatCnt) {
        try {
            ErrorMessage.checkError(repeatCnt.isEmpty() || !checkNumFormat(repeatCnt) || Integer.parseInt(repeatCnt)==0, ErrorMsgEnum.REPEAT_COUNT_ERR_MSG);
        } catch(IllegalArgumentException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    private boolean checkNumFormat(String repeatCnt) {
        return repeatCnt.matches(ValidCommonConditionEnum.REGEX_NUM.getValue());
    }

}
