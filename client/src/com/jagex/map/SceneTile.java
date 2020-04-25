package com.jagex.map;

import com.jagex.entity.GameObject;
import com.jagex.link.Linkable;
import com.jagex.map.object.GroundDecoration;
import com.jagex.map.object.Wall;
import com.jagex.map.object.WallDecoration;

public final class SceneTile extends Linkable {

	public ShapedTile shape;
	public SimpleTile simple;
	public boolean aBoolean1322;
	public boolean aBoolean1323;
	public boolean aBoolean1324;
	public SceneTile aClass30_Sub3_1329;
	public int anInt1310;
	public int anInt1325;
	public int anInt1326;
	public int anInt1327;
	public int anInt1328;
	public int attributes;
	public int collisionPlane;
	public GameObject[] gameObjects;
	public GroundDecoration groundDecoration;
	public GroundItem groundItem;
	public int[] objectAttributes;
	public int objectCount;
	public int plane;
	public int positionX;
	public int positionY;
	public Wall wall;
	public WallDecoration wallDecoration;

	public SceneTile(int x, int y, int z) {
		gameObjects = new GameObject[5];
		objectAttributes = new int[5];
		anInt1310 = plane = z;
		positionX = x;
		positionY = y;
	}

}