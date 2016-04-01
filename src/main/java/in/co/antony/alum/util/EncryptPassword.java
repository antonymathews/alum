/**
 * <!-- 
Author - Antony Mathews IMIT, Cuttack, Odisha, India, batch-2001
With inputs from 
Biajay Sahoo			batch-2001
Sundeep Mohanty (Tutu)	batch-2001
Sambit Satpathy			batch-2000
Soumya Ranjan Parida (Bapi) 	batch-2001
Kamalesh Nayak			batch-2001
 -->

 */

package in.co.antony.alum.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {
	public static String encrypt(String password) {
		if(null != password && !password.isEmpty()) {
			return new BCryptPasswordEncoder().encode(password);
		}
		return null;
	}
	public static void main(String args[]) {
		System.out.println(EncryptPassword.encrypt("111"));
	}
}
