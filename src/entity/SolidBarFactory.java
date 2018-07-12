package entity;

import java.util.ArrayList;
import java.util.TimerTask;

public class SolidBarFactory extends TimerTask {

    private SolidBar solidBar;
    private ArrayList<SolidBar> allSolidBars;

    public SolidBarFactory() {
	allSolidBars = new ArrayList<>();
	allSolidBars.add(new SolidBar(30, 500, 30, 30));
    }

    @Override
    public void run() {
	solidBar = new SolidBar(30, 600, 30, 30);
	allSolidBars.add(solidBar);
	System.out.println(allSolidBars.size());
    }

    public ArrayList<SolidBar> getSolidbars() {
	return allSolidBars;
    }
}
