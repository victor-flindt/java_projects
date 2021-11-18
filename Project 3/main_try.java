public class main_try {
	public static void main(String[] args) {
		
		Bush bush = new Bush(PeberholmConstantsAndUtilities.getLegalRandomPosition());
		Tree tree = new Tree(PeberholmConstantsAndUtilities.getLegalRandomPosition());
		Moss moss = new Moss(PeberholmConstantsAndUtilities.getLegalRandomPosition());
		Flower flower = new Flower(PeberholmConstantsAndUtilities.getLegalRandomPosition());

		bush.setPosition(10, 10);
		
		System.out.println(bush.position.x + PeberholmConstantsAndUtilities.getRandomIntBetween(-10, 10));

		bush.spreadSeeds();


		PeberholmSimulation phsc = new PeberholmSimulation();



		//System.out.print(bush.spreadSeeds());

		//new Bush(PeberholmConstantsAndUtilities.getLegalRandomPosition());

	}

}