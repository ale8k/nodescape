package com.jagex.entity;

import com.jagex.Client;
import com.jagex.cache.anim.Animation;

public class Mob extends Renderable {

	// Class30_Sub2_Sub4_Sub1

	public int animationDelay;
	public boolean animationStretches = false;
	public int anInt1503;
	public int anInt1519;
	public int anInt1522;
	public int anInt1542;
	public int currentAnimation;
	public int currentAnimationLoops;
	public int currentHealth;
	public int cycleStatus = -1000;
	public int destinationX;
	public int destinationY;
	public int direction;
	public int displayedEmoteFrames;
	public int displayedMovementFrames;
	public int emoteAnimation = -1;
	public int emoteTimeRemaining;
	public int endForceMovement;
	public int faceX;
	public int faceY;
	public int graphic = -1;
	public int graphicDelay;
	public int graphicHeight;
	public int halfTurnAnimation = -1;
	public int height = 200;
	public int[] hitCycles = new int[4];
	public int[] hitDamages = new int[4];
	public int[] hitTypes = new int[4];
	public int idleAnimation = -1;
	public int initialX;
	public int initialY;
	public int interactingMob = -1;
	public int maximumHealth;
	public int movementAnimation = -1;
	public int nextStepOrientation;
	public int orientation;
	public boolean[] pathRun = new boolean[10];
	public int[] pathX = new int[10];
	public int[] pathY = new int[10];
	public int quarterAnticlockwiseTurnAnimation = -1;
	public int quarterClockwiseTurnAnimation = -1;
	public int remainingPath;
	public int rotation = 32;
	public int runAnimation = -1;
	public int size = 1;
	public String spokenText;
	public int startForceMovement;
	public int textColour;
	public int textCycle = 100;
	public int textEffect;
	public int time;
	public int turnAnimation = -1;
	public int walkingAnimation = -1;
	public int worldX;
	public int worldY;

	public final void damage(int damage, int type, int cycle) {
		for (int index = 0; index < 4; index++) {
			if (hitCycles[index] <= cycle) {
				hitDamages[index] = damage;
				hitTypes[index] = type;
				hitCycles[index] = cycle + 70;
				break;
			}
		}
	}

	public boolean isVisible() {
		return false;
	}

	public final void move(int x, int y, boolean teleported) {
		if (emoteAnimation != -1 && Animation.animations[emoteAnimation].getWalkingPrecedence() == 1) {
			emoteAnimation = -1;
		}

		if (!teleported) {
			int dirX = x - pathX[0];
			int dirY = y - pathY[0];
			if (dirX >= -8 && dirX <= 8 && dirY >= -8 && dirY <= 8) {
				if (remainingPath < 9) {
					remainingPath++;
				}
				for (int i = remainingPath; i > 0; i--) {
					pathX[i] = pathX[i - 1];
					pathY[i] = pathY[i - 1];
					pathRun[i] = pathRun[i - 1];
				}

				pathX[0] = x;
				pathY[0] = y;
				pathRun[0] = false;
				return;
			}
		}

		remainingPath = 0;
		anInt1542 = 0;
		anInt1503 = 0;
		pathX[0] = x;
		pathY[0] = y;
		worldX = pathX[0] << 7 + size << 6;
		worldY = pathY[0] << 7 + size << 6;
	}

	public final void resetPath() {
		remainingPath = 0;
		anInt1542 = 0;
	}

	public final void walk(int direction, boolean run) {
		int x = pathX[0];
		int y = pathY[0];
		if (direction == 0) {
			x--;
			y++;
		}
		if (direction == 1) {
			y++;
		}
		if (direction == 2) {
			x++;
			y++;
		}
		if (direction == 3) {
			x--;
		}
		if (direction == 4) {
			x++;
		}
		if (direction == 5) {
			x--;
			y--;
		}
		if (direction == 6) {
			y--;
		}
		if (direction == 7) {
			x++;
			y--;
		}
		if (emoteAnimation != -1 && Animation.animations[emoteAnimation].getWalkingPrecedence() == 1) {
			emoteAnimation = -1;
		}
		if (remainingPath < 9) {
			remainingPath++;
		}
		for (int i = remainingPath; i > 0; i--) {
			pathX[i] = pathX[i - 1];
			pathY[i] = pathY[i - 1];
			pathRun[i] = pathRun[i - 1];
		}

		pathX[0] = x;
		pathY[0] = y;
		pathRun[0] = run;
	}

	public static final void nextStep(Mob mob) {
		mob.movementAnimation = mob.idleAnimation;
		if (mob.remainingPath == 0) {
			mob.anInt1503 = 0;
			return;
		}
	
		if (mob.emoteAnimation != -1 && mob.animationDelay == 0) {
			Animation animation = Animation.animations[mob.emoteAnimation];
			if (mob.anInt1542 > 0 && animation.getAnimatingPrecedence() == 0) {
				mob.anInt1503++;
				return;
			}
	
			if (mob.anInt1542 <= 0 && animation.getWalkingPrecedence() == 0) {
				mob.anInt1503++;
				return;
			}
		}
	
		int x = mob.worldX;
		int y = mob.worldY;
		int nextX = mob.pathX[mob.remainingPath - 1] * 128 + mob.size * 64;
		int nextY = mob.pathY[mob.remainingPath - 1] * 128 + mob.size * 64;
	
		if (nextX - x > 256 || nextX - x < -256 || nextY - y > 256 || nextY - y < -256) {
			mob.worldX = nextX;
			mob.worldY = nextY;
			return;
		}
	
		if (x < nextX) {
			if (y < nextY) {
				mob.nextStepOrientation = 0x500;
			} else if (y > nextY) {
				mob.nextStepOrientation = 0x700;
			} else {
				mob.nextStepOrientation = 0x600;
			}
		} else if (x > nextX) {
			if (y < nextY) {
				mob.nextStepOrientation = 0x300;
			} else if (y > nextY) {
				mob.nextStepOrientation = 0x100;
			} else {
				mob.nextStepOrientation = 0x200;
			}
		} else if (y < nextY) {
			mob.nextStepOrientation = 0x400;
		} else {
			mob.nextStepOrientation = 0;
		}
	
		int rotation = mob.nextStepOrientation - mob.orientation & 0x7ff;
		if (rotation > 0x400) {
			rotation -= 0x800;
		}
	
		int animation = mob.halfTurnAnimation;
		if (rotation >= -0x100 && rotation <= 0x100) {
			animation = mob.walkingAnimation;
		} else if (rotation >= 0x100 && rotation < 0x300) {
			animation = mob.quarterAnticlockwiseTurnAnimation;
		} else if (rotation >= -0x300 && rotation <= -0x100) {
			animation = mob.quarterClockwiseTurnAnimation;
		}
		if (animation == -1) {
			animation = mob.walkingAnimation;
		}
	
		mob.movementAnimation = animation;
		int positionDelta = 4;
	
		if (mob.orientation != mob.nextStepOrientation && mob.interactingMob == -1 && mob.rotation != 0) {
			positionDelta = 2;
		}
	
		if (mob.remainingPath > 2) {
			positionDelta = 6;
		}
	
		if (mob.remainingPath > 3) {
			positionDelta = 8;
		}
	
		if (mob.anInt1503 > 0 && mob.remainingPath > 1) {
			positionDelta = 8;
			mob.anInt1503--;
		}
	
		if (mob.pathRun[mob.remainingPath - 1]) {
			positionDelta *= 2;
		}
	
		if (positionDelta >= 8 && mob.movementAnimation == mob.walkingAnimation && mob.runAnimation != -1) {
			mob.movementAnimation = mob.runAnimation;
		}
	
		if (x < nextX) {
			mob.worldX += positionDelta;
			if (mob.worldX > nextX) {
				mob.worldX = nextX;
			}
		} else if (x > nextX) {
			mob.worldX -= positionDelta;
			if (mob.worldX < nextX) {
				mob.worldX = nextX;
			}
		}
		if (y < nextY) {
			mob.worldY += positionDelta;
			if (mob.worldY > nextY) {
				mob.worldY = nextY;
			}
		} else if (y > nextY) {
			mob.worldY -= positionDelta;
			if (mob.worldY < nextY) {
				mob.worldY = nextY;
			}
		}
		if (mob.worldX == nextX && mob.worldY == nextY) {
			mob.remainingPath--;
			if (mob.anInt1542 > 0) {
				mob.anInt1542--;
			}
		}
	}

	public static final void nextForcedMovementStep(Mob mob) {
		if (mob.endForceMovement == Client.tick
				|| mob.emoteAnimation == -1
				|| mob.animationDelay != 0
				|| mob.emoteTimeRemaining + 1 > Animation.animations[mob.emoteAnimation]
						.duration(mob.displayedEmoteFrames)) {
			int remaining = mob.endForceMovement - mob.startForceMovement;
			int elapsed = Client.tick - mob.startForceMovement;
	
			int initialX = mob.initialX * 128 + mob.size * 64;
			int initialY = mob.initialY * 128 + mob.size * 64;
			int endX = mob.destinationX * 128 + mob.size * 64;
			int endY = mob.destinationY * 128 + mob.size * 64;
	
			mob.worldX = (initialX * (remaining - elapsed) + endX * elapsed) / remaining;
			mob.worldY = (initialY * (remaining - elapsed) + endY * elapsed) / remaining;
		}
	
		mob.anInt1503 = 0;
		if (mob.direction == 0) {
			mob.nextStepOrientation = 1024;
		} else if (mob.direction == 1) {
			mob.nextStepOrientation = 1536;
		} else if (mob.direction == 2) {
			mob.nextStepOrientation = 0;
		} else if (mob.direction == 3) {
			mob.nextStepOrientation = 512;
		}
	
		mob.orientation = mob.nextStepOrientation;
	}

	public static final void nextPreForcedStep(Mob character) {
		int remaining = character.startForceMovement - Client.tick;
		int x = character.initialX * 128 + character.size * 64;
		int y = character.initialY * 128 + character.size * 64;
	
		character.worldX += (x - character.worldX) / remaining;
		character.worldY += (y - character.worldY) / remaining;
		character.anInt1503 = 0;
	
		if (character.direction == 0) {
			character.nextStepOrientation = 1024;
		} else if (character.direction == 1) {
			character.nextStepOrientation = 1536;
		} else if (character.direction == 2) {
			character.nextStepOrientation = 0;
		} else if (character.direction == 3) {
			character.nextStepOrientation = 512;
		}
	}

}