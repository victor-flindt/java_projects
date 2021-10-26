public class TrianglePattern {

	//define the fields
	private int n;
	private int h;
	private int[] initial;
	private int[][] cell;

	//make the constructor
	public TrianglePattern(int n, int h, int[] initial) {

		//define our variables
		this.n = n;
		this.h = h;
		this.initial = initial;


		//create the grid
		cell = new int[h][n];

		//makes the entire first, and last, column empty.
		for(int i=0; i < h; i++) {
			cell[i][0] = 0;	
			cell[i][n-1] = 0;
		}		

		//define the cells that are filled in to begin with
		for(int i=0; i<initial.length; i++) {

			cell[0][initial[i]] = 1; //kan komme fejl i positionen.
		}

		//loops to run the method enough times, to fill out the entire grid.
		for(int i=1; i < h; i++) {

			for(int j=1; j < n-1; j++) {

				celler(i,j);

			}
		}

	}	
	//our getValueAt loop for codejudge too achieve data
	public int getValueAt(int r, int c) {

		return this.cell[r][c];

	}
	//the method to check whether or not the j cell, should be 1 og 0
	private int celler(int r, int c) {

		//checks if any of the cases, where the j cell is 1, are true, if so, it returns 1, else it returns 0.

		if 	(cell[r-1][c-1]==0 && cell[r-1][c]==0 && cell[r-1][c+1]==1) {

			cell[r][c] = 1;

			return 1;
		}

		if (cell[r-1][c-1]==0 && cell[r-1][c]==1 && cell[r-1][c+1]==0) {

			cell[r][c] = 1;

			return 1;
		}

		if (cell[r-1][c-1]==0 && cell[r-1][c]==1 && cell[r-1][c+1]==1) {

			cell[r][c] = 1;

			return 1;
		}

		if (cell[r-1][c-1]==1 && cell[r-1][c]==0 && cell[r-1][c+1]==0) {

			cell[r][c] = 1;

			return 1;

		}
		else {

			cell[r][c] = 0;

			return 0;

		}

	}

	//our getter methods.

	public int getN() {

		return this.n;

	}
	public int getH() {

		return this.h;

	}
	public int[] getInitial() {

		return this.initial;

	}

}



