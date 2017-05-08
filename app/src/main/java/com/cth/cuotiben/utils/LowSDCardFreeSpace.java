package com.cth.cuotiben.utils;

/**
 * SD卡空间不足异常类。
 *
 */
public class LowSDCardFreeSpace extends Exception{
	private static final long serialVersionUID = 8136744458017179380L;
	public LowSDCardFreeSpace(String msg){
		super(msg);
	}
}
