package com.jagex.map;

final class SimpleTile {

	int centreColour;
	int eastColour;
	int northEastColour;
	int northColour;
	int anInt722;
	boolean flat;
	int texture;

	public SimpleTile(int centreColour, int eastColour, int northEastColour, int northColour, int texture, int j1, boolean flat) {
		this.centreColour = centreColour;
		this.eastColour = eastColour;
		this.northEastColour = northEastColour;
		this.northColour = northColour;
		this.texture = texture;
		this.anInt722 = j1;
		this.flat = flat;
	}

}