package view;

import static validator.LottoNumberValidators.validateAndParseNumber;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int requestUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return validateAndParseNumber(readline());
    }
    
    public static String requestWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return readline();
    }
    
    public static int requestBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return validateAndParseNumber(readline());
    }

    private static String readline() {
        return scanner.nextLine();
    }
}