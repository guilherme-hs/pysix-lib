package com.tenacity.pysix.security.cryptography;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Class used to encrypt and decrypt Strings
 */
public final class Cryptographer {

    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static final int MAX_HEX = 0xff;
    private static final int HEX_BASE = 16;

    private Cryptographer(){}

    /**
     * Key used on the operation
     */
	private static final String KEY =  "12355ab45c5d55e4e455a4c55b55a5c456b655e544d555a555f455e54ef54a54";

    /**
     * Encrypts a String
     * @param value - String to be encrypted
     * @return encrypted string
     * @throws GeneralSecurityException - Case for some reason it cannot access the resources needed to encrypt
     */
	public static String encrypt(String value)
			throws GeneralSecurityException {
		SecretKeySpec sks = new SecretKeySpec(hexStringToByteArray(KEY), ENCRYPTION_ALGORITHM);
		Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
		byte[] encrypted = cipher.doFinal(value.getBytes());
		return byteArrayToHexString(encrypted);
	}

    /**
     * Decrypts a String
     * @param message - String to be decrypted
     * @return decrypted string
     * @throws GeneralSecurityException - Case for some reason it cannot access th resources needed to decrypt
     */
	public static String decrypt(String message)
			throws GeneralSecurityException {
		SecretKeySpec sks = new SecretKeySpec(hexStringToByteArray(KEY), ENCRYPTION_ALGORITHM);
		Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, sks);
		byte[] decrypted = cipher.doFinal(hexStringToByteArray(message));
		return new String(decrypted);
	}

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			int v = b[i] & MAX_HEX;
			if (v < HEX_BASE) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	private static byte[] hexStringToByteArray(String s) {
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), HEX_BASE);
			b[i] = (byte) v;
		}
		return b;
	}
}
