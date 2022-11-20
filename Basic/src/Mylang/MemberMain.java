package Mylang;

class Member{
	public String id;
	public String pwd;
	public Member(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Member) {
			Member m = (Member)obj;
			if(this.id.equals(m.id)) {
				return true;
			}
		}
		return false;
	}

	public void print() {
		System.out.println("id:"+id);
		System.out.println("pwd:"+ pwd);
	}
}

public class MemberMain {
	public static void main(String[] args) {
		Member m1 = new Member("aaa","111");
		Member m2 = new Member("aaa","134");
		Member m3 = m1; //참조값만 복사. 얕은복
		
		System.out.println("m1==m2:"+(m1==m2)); //내용은 같지만 참조값이 다름. false
		System.out.println("m1==m3:"+(m1==m3));
		System.out.println("m1.equals(m2):"+m1.equals(m2));
		System.out.println("m1.equals(m3):"+m1.equals(m3));
		
	}
}
