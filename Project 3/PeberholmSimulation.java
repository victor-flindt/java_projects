import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PeberholmSimulation {

	private int steps;
	private static ArrayList<Plant> plants; // Array containg the p	lants
	private static boolean[][] occupied;
	private static JFrame jf;
	private static Random rand = new Random();

	/**
	 * Constructor. Initializes the data structures and the graphics.
	 * 
	 * @param noOfPlants
	 *            The number of plants.
	 * @param steps
	 *            The number of steps, the simmulation should run.
	 */
	public PeberholmSimulation() {
		this.steps = PeberholmConstantsAndUtilities.ROUNDS;
		init();
		run();
	}

	/**
	 * Public method which performs the simulation.
	 */

	public void run() {
		// During each execution of the loop one step of the
		// simulation is performed.
		ArrayList<Plant[]> newPlants;
		for (int i = 0; i < steps; i++) {
			// Draw the state of the island
			if (PeberholmConstantsAndUtilities.SHOW) {
				try {
					Thread.sleep(500L);
				} catch (Exception e) {
					// TODO: handle exception
				}
				drawIsland();
			}
			newPlants = new ArrayList<Plant[]>();
			// Loop over all Plants
			for (Plant plant : plants) {
				// Draw and then move a Plants
				newPlants.add(plant.spreadSeeds());
				// one cannot add the plants here, because that
				// would change the array-list used in the loop
				// and give an exception.
			}
			// show the new situation and pause 100 millseconds
			// add the new plants.
			for (Plant[] newPl : newPlants) {
				for (int k = 0; k < newPl.length; k++) {
					addPlantIfPossible(newPl[k]);
				}
			}
		}
	}

	/**
	 * Initializes the graphics and creates the Plants.
	 */
	private void init() {
		occupied = new boolean[PeberholmConstantsAndUtilities.H + 1][PeberholmConstantsAndUtilities.W + 1];
		for (int i = 0; i < PeberholmConstantsAndUtilities.H + 1; i++) {
			for (int j = 0; j < PeberholmConstantsAndUtilities.W + 1; j++) {
				occupied[i][j] = false;
			}
		}
		//drawEmptyIsland();

		createInitialPlants();
		if (PeberholmConstantsAndUtilities.SHOW) {
			initGraphics();
		}

	}

	private void initGraphics() {
		jf = new JFrame("Peberholm");
		jf.setSize(1000, 1000);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel peberholm = new JPanel() {
			public void paintComponent(Graphics gr) {
				super.paintComponent(gr);
				int width = this.getWidth();
				int height = this.getHeight();
				int noOfRows = PeberholmConstantsAndUtilities.H;
				int noOfCols = PeberholmConstantsAndUtilities.W;
				int cellwidth = width / noOfCols;
				int cellheight = height / noOfRows;
				int cellsize = cellwidth;
				if (cellsize > cellheight) {
					cellsize = cellheight;
				}
				if (cellsize == 0) {
					cellsize = 1;
				}
				Color oldCol = gr.getColor();
                gr.setColor(Color.white);
				gr.fillRect(1, 1, cellsize * (noOfCols + 1),
						cellsize * (noOfRows + 1));
				gr.setColor(oldCol);
				gr.drawRect(1, 1, cellsize * (noOfCols + 1),
						cellsize * (noOfRows + 1));
				for (int pl = 0; pl < plants.size(); pl++) {
					drawPlant(plants.get(pl), gr, cellsize);
				}

			}

			private void drawPlant(Plant pl, Graphics gr, int cellsize) {
				gr.setColor(pl.getColor());
				gr.fillRect(pl.position.x * cellsize, pl.position.y * cellsize,
						cellsize, cellsize);

			}

		};
		jf.getContentPane().add(peberholm);
		jf.setVisible(true);
	}

	/**
	 * Creates the Plants and stores them in the array "Plants". 
	 */
	private void createInitialPlants() {
		// create an array of type Plant
		plants = new ArrayList<Plant>();
		// fill the array. The do-statemants ensure distinct positions.
		do {
		} while (!addPlantIfPossible(new Bush(
				PeberholmConstantsAndUtilities.getLegalRandomPosition())));
		do {
		} while (!addPlantIfPossible(new Moss(
				PeberholmConstantsAndUtilities.getLegalRandomPosition())));
		do {
		} while (!addPlantIfPossible(new Flower(
				PeberholmConstantsAndUtilities.getLegalRandomPosition())));
		do {
		} while (!addPlantIfPossible(new Tree(
				PeberholmConstantsAndUtilities.getLegalRandomPosition())));

	}

	// adds plant pl if the position is not already occupied.
	// returns true in case of success and false otherwise.
	private boolean addPlantIfPossible(Plant pl) {
		if (PeberholmConstantsAndUtilities
				.positionOK(pl.position) && !occupied[pl.getPosition().y][pl
						.getPosition().x]) {
			plants.add(pl);
			occupied[pl.getPosition().y][pl.getPosition().x] = true;
			return true;
		} else {
			return false;
		}

	}
	/**;
	 * Does what the name suggests
	 * 
	 */
	private void drawIsland() {
		jf.repaint();

	}

	private static void fail(String error) {
		System.out.println("RESULT Fail");
		System.out.println("TEXT " + error);
		System.exit(0);
	}
	
	

}
