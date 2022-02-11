package com.chainsys.util;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ConnectionPassword {
	
	    private ConnectionPassword() {
			super();
		}

		static String plainText = "oracle";
	    public static final int AES_KEY_SIZE = 256;
	    public static final int GCM_IV_LENGTH = 12;
	    public static final int GCM_TAG_LENGTH = 16;

	    
	    public static byte[] encrypt(byte[] plaintext, SecretKey key, byte[] iv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException  
	    {
	        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
	        
	        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
	        
	        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
	        
	        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);
	        
	        return cipher.doFinal(plaintext);
	    }

	    public static String decrypt() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException 
	    {
	    	
	    	  KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	          keyGenerator.init(AES_KEY_SIZE);
	          SecretKey key = keyGenerator.generateKey();
	          byte[] iv = new byte[GCM_IV_LENGTH];
	          SecureRandom random = new SecureRandom();
	          random.nextBytes(iv);
	          byte[] cipherText = encrypt("oracle".getBytes(), key, iv);
	        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
	        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
	        
	        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
	        
	        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
	        
	        byte[] decryptedText = cipher.doFinal(cipherText);
	        
	        return new String(decryptedText);
	    }
	}


