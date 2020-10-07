package q3;   //name: Naor Fahima ; ID:315783563 ; Number of task = 1
 
public class IsDiagonalHasLettersSequence {

	public static boolean isDiagonalLettersSequence(char[][] mat, int rows) {
		char ch = (char) ('a' + rows-1);
		if (rows == 0) {
			return true;
		}
		
		if (mat[rows-1][rows-1] == ch) {
			return isDiagonalLettersSequence(mat, rows-1);
		} else {
			return false;
		}
		
	}

	public static void main(String[] args) {
		char[][] mat = new char[5][5];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++)
				mat[i][j] = (char) (int) ((Math.random() * 26) + 'a');
		}
		
		for (int i=0 ; i <mat.length ; i++)
			mat[i][i] = (char)('a' + i);
		//mat[2][2] = 'b';

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
		
		System.out.println(isDiagonalLettersSequence(mat, mat.length));

	}

}
