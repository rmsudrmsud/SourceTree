package Test;
import oop3.Parent;



class Child extends Parent{

	public void test() {

		System.out.println(age);

		System.out.println(name);

	}

}



public class ParentMain {


	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Parent p = new Parent();

		//p.age = 1;

		//p.name = "aaa";

		p.parentMethod();

	}

}