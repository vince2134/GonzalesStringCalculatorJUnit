package com.ideyatech.ut.exercise;

public class StringCalculator implements Calculator{

	public long calculate(String input) {

		if(input == null)
			return 0;
		else if(input.substring(0, 2).equals("//")){
			long sum = 0;
			
			if(input.charAt(2) == '['){
				String splitter = input.substring(3, input.indexOf(']'));
				//System.out.println(splitter);
				
				String[] numbers = input.substring(input.indexOf(']') + 1, input.length()).split(splitter);
				
				for(int x = 0; x < numbers.length; x++){
					if(Long.parseLong(numbers[x]) <= 1000)
						if(Long.parseLong(numbers[x]) < 0)
							throw new IllegalArgumentException();
						sum += Long.parseLong(numbers[x]);
				}
			}
			else{
				String splitter = input.substring(2, 3);
	
				String[] numbers = input.substring(3, input.length()).split(splitter);
				
				for(int x = 0; x < numbers.length; x++){
					if(Long.parseLong(numbers[x]) <= 1000){
						if(Long.parseLong(numbers[x]) < 0)
							throw new IllegalArgumentException();
						sum += Long.parseLong(numbers[x]);
					}
				}
				
			}
			
			return sum;
		}
		else if(input.contains(",")){
			long sum = 0;
			String[] numbers = input.split(",");
			
			for(int x = 0; x < numbers.length; x++){
				if(Long.parseLong(numbers[x]) <= 1000){
					if(Long.parseLong(numbers[x]) < 0)
						throw new IllegalArgumentException();
					sum += Long.parseLong(numbers[x]);
				}
			}
			
			return sum;
		}
		else if(input.charAt(0) == '-')
			throw new IllegalArgumentException();
		else if(Long.parseLong(input) > 1000)
			return 0;
		else if(input.matches("^[0-9]+$"))
			return Long.parseLong(input);

		
		return -1;
	}
}
