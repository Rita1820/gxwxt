package com.util;

import java.util.Comparator;

import com.model.TUser;

public class ComparatorUser implements Comparator {

	public int compare(Object o1, Object o2) {
		// 正序：eturn ((TUser) o1).getZongfen() - ((TUser) o2).getZongfen();

		// 倒序：
		return ((TUser) o2).getZongfen() - ((TUser) o1).getZongfen();
	}

}
