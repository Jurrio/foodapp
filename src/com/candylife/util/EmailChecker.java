package com.candylife.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailChecker {

	public static boolean checkWithRegExp(String userNameString) {
		Pattern p = Pattern.compile("^[a-z0-9_\\.]{4,31}@[a-z]{1,}[a-z0-9]{0,}\\.[a-z]{2,3}$");
		Matcher m = p.matcher(userNameString);
		return m.matches();
	}

	public static void main(String[] args) {
		System.out.println(checkWithRegExp("jurimik@yandex.ua"));
		System.out.println(checkWithRegExp("380957952437@i.ua"));
		System.out.println(checkWithRegExp("gasf_90@ji.com"));
		System.out.println(checkWithRegExp("iy@.ua"));
		
		System.out.println(" ≥льк≥сть символ≥в (example@com.ua), €к≥ сто€ть перед знаком С@Т маЇ бути не менше 4-ох ≥ не б≥льше 31-го");
		System.out.println(checkWithRegExp("test@yandex.ua"));
		System.out.println(checkWithRegExp("1234567890123456789012345678901@yandex.ua"));
		System.out.println(checkWithRegExp("tes@yandex.ua"));
		System.out.println(checkWithRegExp("12345678901234567890123456789012@yandex.ua"));
		
		System.out.println("“акож в ц≥й частин≥ допускаютьс€ т≥льки л≥тери, цифри та знаки крапки ≥ нижнього п≥дкресленн€. ¬с≥ решта символ≥в, так≥ €к С%Т, С*Т, С(Т, С)Т, С=Т, С+Т ≥ т.д., не допускаютьс€.");
		System.out.println(checkWithRegExp("abcdefghijklmnopqrstuvwxyz0.98_@yandex.ua"));
		System.out.println(checkWithRegExp("jg-hkl@yandex.ua"));
		System.out.println(checkWithRegExp("j&jas@yandex.ua"));
		System.out.println(checkWithRegExp("васек@yandex.ua"));
		System.out.println(checkWithRegExp("васЄк@yandex.ua"));
		
		System.out.println("¬ частин≥, €ка стоњть п≥сл€ знаку С@Т (example@com.ua), маЇ бути принаймн≥ 1 буквенний символ, €кий розм≥щений до крапки.");
		System.out.println(checkWithRegExp("jjklas@u.ua"));
		System.out.println(checkWithRegExp("jjjas@1.ua"));
		System.out.println(checkWithRegExp("васЄк@.ua"));
		
		System.out.println("якщо в ц≥й частин≥ символ≥в б≥льше н≥ж один то першим маЇ бути буквенний.");
		System.out.println(checkWithRegExp("jwer23jas@u123gfh.ua"));
		System.out.println(checkWithRegExp("j__jas@1gb.ua"));
		System.out.println(checkWithRegExp("kritoy.iv@220716.ua"));
		
		System.out.println("ќстанн€ частина емейлу, €ка розташована п≥сл€ крапки повинна м≥стити або 2 або 3 буквенний символа.");
		System.out.println(checkWithRegExp("jurimik@yandex."));
		System.out.println(checkWithRegExp("jurimik@yandex.u"));
		System.out.println(checkWithRegExp("jurimik@yandex.ua"));
		System.out.println(checkWithRegExp("jurimik@yandex.com"));
		System.out.println(checkWithRegExp("jurimik@yandex.name"));
		
	}
}
