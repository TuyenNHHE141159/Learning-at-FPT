/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Security {

    /**
     *
     * @param password mã hóa
     * @return
     */
    public String Encoding(String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encoded = encoder.encode(password.getBytes());
        return new String(encoded);
    }

    /**
     *
     * @param password giải mã
     * @return
     */
    public String Decoding(String password) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decoded = decoder.decode(password.getBytes());
        return new String(decoded);
    }
/**
 * 
 * @param password
 * @return 
 */
    public String EncodingMD5(String password) {
        String encoded = "";
        try {
            MessageDigest msd = MessageDigest.getInstance("MD5");
            try {
                byte[] srcTextBytes = password.getBytes("UTF-8");//chuyen chuoi sang dang byte
                byte[] endTextBytes = msd.digest(srcTextBytes);//thuc hien ma hoa sang dang byte moi
                BigInteger bigInt = new BigInteger(1, endTextBytes);//mang byte sau khi ma hoa dc chuyen sang he co so 16(hex)
                encoded = bigInt.toString(16);//ep kieu
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encoded;
    }

    public static void main(String[] args) {
        String password = "tuyen";
        Security s = new Security();
        //  String encoded = s.Encoding(password);
        //String decoded = s.Decoding(password);
        //System.out.println(encoded);
        System.out.println(s.EncodingMD5(password));
    }
}
