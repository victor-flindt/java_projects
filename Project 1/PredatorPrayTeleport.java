public class PredatorPrayTeleport {
	public static void main(String[] args) {
        PredatorPrayTeleport.runSimulation(100,2,10);
	}
    public static void runSimulation (int n , int s , int t ){
        //  n = gridsize of the playingfield
        //  s = number of steps to move 
        //  t = number of steps ? whatever that means
        if((s<=1)||(n<=0)||(t<0)){
            System.out.format("n=%d s=%d t=%d",n,s,t);
            System.out.println("");
            System.out.print("Illegal Parameters!");
            System.exit(0);
        }
        // init and allocating memory. 
        long[] pray_position = new long[2];         // long basic type accounts for overflow in the position of the position.   
        long[] predetor_position = new long[2];     

        // declare start positions of pray
        pray_position[0]=((long)Math.floor(Math.random()*((n-1)-0+1)));
        pray_position[1]=((long)Math.floor(Math.random()*((n-1)-0+1)));

        // delcare start position of predetor
        predetor_position[0]=((long)Math.floor(Math.random()*((n-1)-0+1)));
        predetor_position[1]=((long)Math.floor(Math.random()*((n-1)-0+1)));

        // state parameters and starting positions
        System.out.format("n=%d s=%d t=%d",n,s,t);
        System.out.println("");
        System.out.format("[%d;%d] [%d;%d]\n",pray_position[0],pray_position[1],predetor_position[0],predetor_position[1]);
        System.out.print("");
        
        int h =0 ;

        while(h<=t-1){
            pray_position=PredatorPrayTeleport.new_position_pray(s,pray_position,n);
            predetor_position = PredatorPrayTeleport.new_position_predetor(s, predetor_position, pray_position,n);
            //System.out.format("[%d;%d] [%d;%d]\n",pray_position[0],pray_position[1],predetor_position[0],predetor_position[1]);
            h++;
        }
    }

    public static long[] new_position_pray(int step_size, long[] pray_position, int map_dimension){
        int min = -step_size;
        int max = step_size;

        pray_position[0]=((long)Math.floor(Math.random()*(max-min+1)+min))+pray_position[0];
        pray_position[1]=((long)Math.floor(Math.random()*(max-min+1)+min))+pray_position[1];

        if(pray_position[0]>=map_dimension){
            pray_position[0]=pray_position[0]-(pray_position[0]-map_dimension+1);
        }
        if(pray_position[1]>=map_dimension){
            pray_position[1]=pray_position[1]-(pray_position[1]-map_dimension+1);
        }
        if(pray_position[0]<0){
            pray_position[0]=0;
        }
        if(pray_position[1]<0){
            pray_position[1]=0;
        }
        // catches if the pray is position where both cordinates are divisible by s
        if((pray_position[0]%step_size==0)&&(pray_position[1]%step_size==0)){
            pray_position=pray_teleport(pray_position,map_dimension);
        }
        System.out.format("[%d;%d]",pray_position[0],pray_position[1]);
        return pray_position;
    }
    
    public static long[] new_position_predetor(int step_size, long[] predetor_position, long[] pray_position, int map_size){
        for (int i = 0; i < step_size; i++) {
            if(pray_position[0] > predetor_position[0]){
                predetor_position[0]++;
            }else if(pray_position[0] < predetor_position[0]){
                predetor_position[0]--;
            }
            if(pray_position[1] > predetor_position[1]){
                predetor_position[1]++;
            }else if(pray_position[1] < predetor_position[1]){
                predetor_position[1]--;
            }
            if((pray_position[0] == predetor_position[0])&&(pray_position[1] == predetor_position[1])){
                System.out.format("[%d;%d]\n",predetor_position[0],predetor_position[1]);
                System.out.print("Catch!");
                System.exit(0);
            }
        }
        System.out.format("[%d;%d]\n",predetor_position[0],predetor_position[1]);
        return predetor_position;
    }
    public static long[] pray_teleport(long[] pray_position, int map_dimension){
        
        pray_position[0]=((long)Math.floor(Math.random()*((map_dimension-1)-0+1)));
        pray_position[1]=((long)Math.floor(Math.random()*((map_dimension-1)-0+1)));

        return pray_position;
    }
}

