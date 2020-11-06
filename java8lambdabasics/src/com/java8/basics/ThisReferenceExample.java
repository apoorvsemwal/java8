package com.java8.basics;

public class ThisReferenceExample {

	public void instanceProcess(int i, ProcessLambda p) {
		p.process(i);
	}

	public void execute() {
		instanceProcess(10, (i) -> {
			System.out.println("Value is: "+i);
			System.out.println(this);				
		});
	} 

	public static void main(String[] args) {
		ThisReferenceExample obj = new ThisReferenceExample();

		//Anonymous Inner class overrides this(enclosing method). 
		//That is within a method in anonymous inner class
		//this refers to the Anonymous Inner class object itself and not the enclosing menthod's this.
		obj.instanceProcess(10, new ProcessLambda() {
			@Override
			public void process(int i) {
				System.out.println("Value is: "+i);
				System.out.println(this);		
			}

			@Override
			public String toString() {
				return "Its an annonymous inner class...";
			}
		});

		obj.instanceProcess(10, (i) -> {
			System.out.println("Value is: "+i);
			//System.out.println(this); //This will give an error as lambdas do not override this.
			//Lambda uses the same this reference as is available to the enclosing method. 
			//Here in this case inclosing method is a static method so this is not applicable within
			//a static context. Therefore we get an error for that.
		});
		
		obj.execute();
		
	}
	
	@Override
	public String toString() {
		return "Main Class Object...";
	}


}
