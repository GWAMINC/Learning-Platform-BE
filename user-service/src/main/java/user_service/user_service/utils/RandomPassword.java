package user_service.user_service.utils;

public class RandomPassword {
    public static String generatePassword() {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters  + numbers;
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int index = (int) (Math.random() * combinedChars.length());
            password.append(combinedChars.charAt(index));
        }
        return password.toString();
    }
}
