package christmas;

import java.util.*;

public enum Calendar {
	// 주말 : 금, 토
	// 평일 : 일, 월, 화, 수, 목
	// 별 : 일, 크리스마스
	SPECIAL_DISCOUNT(Arrays.asList(3, 10, 17, 24, 25, 31)),
	WEEKEND_DISCOUNT(Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));

	private List<Integer> fixedDays;

	Calendar(List<Integer> fixedDays) {
		this.fixedDays = fixedDays;
	}

	public static boolean isSpecial(int date) {
		if (SPECIAL_DISCOUNT.fixedDays.contains(date)) // 일요일이거나 크리스마스 당일일 때
			return true;

		return false;
	}

	public static boolean isWeekday(int date) { // 주말이 아닐 때
		if (!WEEKEND_DISCOUNT.fixedDays.contains(date))
			return true;

		return false;
	}

	public static boolean isWeekend(int date) { // 주말일 때
		if (WEEKEND_DISCOUNT.fixedDays.contains(date))
			return true;

		return false;
	}
}
