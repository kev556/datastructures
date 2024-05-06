package lab1;

public class Lab1App {

	public static void main(String[] args) {
		part1();
		part2();
	}
	public static void part1() {
		
		Matrix A = new Matrix(new double[][] {{1,2},{3,4}});
		Matrix B = new Matrix(new double[][] {{3,2},{5,4}});
		Matrix C = new Matrix(new double[][] {{2,2},{-1,1}});
		Matrix D = new Matrix(new double[][] {{1,2,3},{4,5,6}});
		Matrix E = new Matrix(new double[][] {{1,2,3},{4,5,6},{7,8,9}});
		
		System.out.print("1. (A^T)^T = A\t\t\t = ");
		System.out.println(A.transpose().transpose().equals(A));
		
		System.out.print("2. (A+B)^T = A^T+B^T\t\t = ");
		System.out.println(A.add(B).transpose().equals(A.transpose().add(B.transpose())));
		
		System.out.print("3. (rA)^T = rA^T\t\t = ");
		System.out.println(A.scalarMult(3).transpose().equals(A.transpose().scalarMult(3)));
		
		System.out.print("4. (AB)^T = A^TB^T\t\t = ");
		System.out.println(A.mult(B).transpose().equals(B.transpose().mult(A.transpose())));
		
		System.out.print("5. DE != ED\t\t\t = ");
		System.out.println(D.mult(E) != E.mult(D));
		
		System.out.print("6. A(BC) = (AB)C\t\t = ");
		System.out.println(A.mult(B.mult(C)).equals((A.mult(B)).mult(C)));
		
		System.out.print("7. A(B+C) = AB + AC\t\t = ");
		System.out.println(A.mult(B.add(C)).equals(A.mult(B).add(A.mult(C))));
		
		System.out.print("8. (A+B)C = AC + BC\t\t = ");
		System.out.println(A.add(B).mult(C).equals(A.mult(C).add(B.mult(C))));
		
		System.out.print("9. r(A)B = r(AB) = A(rB)\t = ");
		System.out.println(A.scalarMult(2).mult(B).equals(A.mult(B).scalarMult(2)) && 
				A.scalarMult(2).mult(B).equals(A.mult(B.scalarMult(2))));
		
	}
	public static void part2() {
		Matrix A = new Matrix(new double[][] {{1,-2,3},{1,-1,0}});
		Matrix B = new Matrix(new double[][] {{3,4},{5,-1},{1,-1}});
		Matrix C = new Matrix(new double[][] {{4,-1,2},{-1,5,1}});
		Matrix D = new Matrix(new double[][] {{-1,0,1},{0,2,1}});
		Matrix E = new Matrix(new double[][] {{3,4},{-2,3},{0,1}});
		Matrix F = new Matrix(new double[][] {{2},{-3}});
		Matrix G = new Matrix(new double[][] {{2,-1}});
		
		System.out.println("\n(a) 3C - 4D  =");
		System.out.println(C.scalarMult(3).subt(D.scalarMult(4)));
		
		System.out.println("\n(b) A - (D + 2C)");
		System.out.println(A.subt(D.add(C.scalarMult(2))));
		
		System.out.println("\n(c) A - E");
		System.out.println(A.subt(E));
		
		System.out.println("\n(d) AE");
		System.out.println(A.mult(E));
		
		System.out.println("\n(e) 3BC - 4BD");
		System.out.println(B.scalarMult(3).mult(C).subt(B.scalarMult(4).mult(D)));
		
		System.out.println("\n(f) CB + D");
		System.out.println(C.mult(B).add(D));
		
		System.out.println("\n(g) GC");
		System.out.println(G.mult(C));
		
		System.out.println("\n(h) FG");
		System.out.println(F.mult(G));
		
		System.out.println("\n(i) C^2");
		System.out.println(C.mult(C));
		
		System.out.println("\n(j) C + D");
		System.out.println(C.add(D));
	}
}
