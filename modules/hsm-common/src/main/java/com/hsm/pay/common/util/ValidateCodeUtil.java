package com.hsm.pay.common.util;

import java.util.Random;

public class ValidateCodeUtil {

	public static String makeRandomNumber(int digit) {
		Random random=new Random(System.currentTimeMillis());
		StringBuffer sixNumber=new StringBuffer();
		for (int i = 0; i <digit; i++) {
			sixNumber.append(random.nextInt(10));
		}
		return sixNumber.toString();
	}
	public static void main(String[] args) {
		 System.out.println(makeRandomNumber(6));
	}

}
