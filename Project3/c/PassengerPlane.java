package hjemmeopgave_3;

import java.util.ArrayList;

public class Airport {


	int i = 1;

	ArrayList<Plane> landed = new ArrayList<Plane>();

	ArrayList<Integer> idarray = new ArrayList<Integer>();


	public void start(int id) {

		for(int i=0; i < idarray.size(); i++ ) {

			if(idarray.get(i) == id) {

				idarray.remove(i);

				landed.remove(i);

			}

		}
	}


	public void land(Plane plane) {	


		if(idarray.contains(plane.id)) 	{			

		}	
		else {


			plane.setId(i);

			landed.add(plane);



			idarray.add(plane.id);

			i++;

		}
	}

	public String toString() {


		StringBuilder sb = new StringBuilder();
		for (Plane s : landed)
		{
			sb.append(s);
			sb.append("\n");
		}
		return sb.toString();

	}
}
