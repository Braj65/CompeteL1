package com.trgr.careerstack45.pizzavol;

public class PizzaDiscount {

	public static void main(String[] args){
		Double d8=3.99;
		//finding difference in volume using #r2h where h is constant for both pizzas
		Double num=Math.PI*144*d8;
		Double deno=Math.PI*64;
		//substracting actual price 6.73 from calculated price
		Double disc=(num/deno)-6.73;
		Double discp=disc*100/8.97;
		System.out.println(discp);
	}

}
