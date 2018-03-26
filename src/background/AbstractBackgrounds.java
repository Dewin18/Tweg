package background;

import java.util.ArrayList;

public abstract class AbstractBackgrounds {
	
	protected ArrayList<Background> backgrounds = new ArrayList<>();
	
	public AbstractBackgrounds() {
		initBackgrounds();
	}
		
	protected abstract void initBackgrounds();
	
	public ArrayList<Background> getBackgrounds() {
		return backgrounds;
	}
}
