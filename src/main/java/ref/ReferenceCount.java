package ref;


class A{
	private B b = null;
	
	public void setB(B b) {
		this.b = b;
	}
	
	public B getB() {
		return b;
	}
}

class B{
	private A a = null;
	
	public void setA(A a) {
		this.a = a;
	}
	
	public A getA() {
		return a;
	}
}

public class ReferenceCount {

	public static void main(String[] args) {
		A ARef = new A();
		B BRef = new B();
		
		ARef.setB(BRef);
		BRef.setA(ARef);
		
		ARef = null;
		BRef = null;
		
		System.gc();
		

	}

}
