package leejy.myapp.api.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Standard {
    private static final Logger logger = LoggerFactory.getLogger(Standard.class);

    public static boolean isEmpty(String input) {
        return input == null || input.isEmpty() || input.trim().length() == 0;
    }

    public static boolean isEmpty(Object value) {
        return value == null;
    }

    public static boolean isEmpty(Object[] value) {
        return value == null || value.length == 0;
    }

    public static boolean isEmpty(List<?> value) {
        return value == null || value.size() == 0;
    }

    public static boolean isNotUnique(List<?> value) {
        return value == null || value.size() != 1;
    }

    public static boolean isUnique(List<?> value) {
        return value == null || value.size() == 1;
    }

    // 만나이 계산기
    public static int getAmericanAge(String birthDate) {
        LocalDate now = LocalDate.now();
        LocalDate parsedBirthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyyMMdd"));

        int americanAge = now.minusYears(parsedBirthDate.getYear()).getYear(); // (1)2020-2007 = 13

        // (2)
        // 생일이 지났는지 여부를 판단하기 위해 (1)을 입력받은 생년월일의 연도에 더한다.
        // 연도가 같아짐으로 생년월일만 판단할 수 있다!
        if (parsedBirthDate.plusYears(americanAge).isAfter(now)) {
            americanAge = americanAge -1;
        }

        return americanAge;
    }

}
