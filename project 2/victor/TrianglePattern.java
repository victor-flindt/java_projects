public class TrianglePattern
{
    int [] init;
    int h;
    int n;
    int[][] map;
    public static void main(String[] args)
    {
        int[] initilize = {11,19};
		int n = 31, h = 8;

        TrianglePattern tp = new TrianglePattern(n,h,initilize);
		for (int r = 0; r < tp.getH(); r++) {
			for (int c = 0; c < tp.getN(); c++) {
				System.out.print(tp.getValueAt(r, c));
			}
			System.out.println();
		}
    }
    // constructor of the class
    public TrianglePattern(int n, int h, int[] initilize)
    {
        this.n = n;
        this.h = h;
        this.init = initilize;
        this.map = new int[h][n];
        // initilize the map value at row 0 column iniziliations value. 
        for (int i = 0; i < initilize.length; i++) {
            map[0][initilize[i]]=1;
            
        }
		for(int i=1; i < h; i++) {
			for(int j=1; j < n-1; j++) {
				cell_value_update(i,j);
			}
		}

        //map_init(map,this.init);
    }

    // methods
    public int getValueAt(int r,int c)
    {
        return this.map[r][c];
    }
    
    	//the method to check whether or not the j map, should be 1 og 0
    private int cell_value_update(int r, int c) {
        //checks if any of the cases, where the j map is 1, are true, if so, it returns 1, else it returns 0.
        if 	(map[r-1][c-1]==0 && map[r-1][c]==0 && map[r-1][c+1]==1) {
            map[r][c] = 1;
            return 1;
        }
        if (map[r-1][c-1]==0 && map[r-1][c]==1 && map[r-1][c+1]==0) {
            map[r][c] = 1;
            return 1;
        }
        if (map[r-1][c-1]==0 && map[r-1][c]==1 && map[r-1][c+1]==1) {
            map[r][c] = 1;
            return 1;
        }
        if (map[r-1][c-1]==1 && map[r-1][c]==0 && map[r-1][c+1]==0) {
            map[r][c] = 1;
            return 1;
        }
        else {
            map[r][c] = 0;
            return 0;    
        }

    }
    // getter methods
    public int getN()
    {
        return this.n;
    }
    public int getH()
    {
        return this.h;
    }
    public int[] getInitial()
    {
        return this.init;
    }

}