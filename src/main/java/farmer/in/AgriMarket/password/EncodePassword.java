package farmer.in.AgriMarket.password;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class EncodePassword {
    public static String encode(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean verifyPassword(String inputPassword, String hashedPassword) {
        String hashedInput = encode(inputPassword);
        return hashedInput.equals(hashedPassword);
    }

    public static long  randomNumber(){
        return  (long) (Math.random() * 100000000000000000L);
    }
}
