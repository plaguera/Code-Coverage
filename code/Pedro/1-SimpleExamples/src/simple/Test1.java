package simple;

public class Test1 {

	public static void main(String[] args) {
		
		boolean a = true, b = true, c = true;
		
		if(a || (b && c))
			System.out.println("Success !!");

		foo(0, 0);
		foo(1, 0);
		//foo(0, 1);
		foo(1, 1);
		
		int x = 1;
		while(x != 0){
			foo(0, 0);
			x--;
		}
		switch(x){
			case 0: ;
			case 1: break;
			case 2: break;
			case 3: break;
			//default: break;
		}
		Test1 a1 = new Test1();
	}
	
	public Test1(){;}
	
	public static int foo(int x, int y) {
		int z = 0;
		if((x > 0) && (y > 0))
			z = x;
		return z;
	}

}
