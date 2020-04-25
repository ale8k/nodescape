package com.jagex.map;

import com.jagex.cache.Archive;
import com.jagex.io.Buffer;

public class Floor {

	private static int count;
	public static Floor[] floors;

	public static void init(Archive archive) {
		Buffer buffer = new Buffer(archive.getEntry("flo.dat"));
		count = buffer.readUShort();

		if (floors == null) {
			floors = new Floor[count];
		}

		for (int id = 0; id < count; id++) {
			if (floors[id] == null) {
				floors[id] = new Floor();
			}

			floors[id].decode(buffer);
		}
	}

	private int chroma;
	private int colour;
	private int hue;
	private int luminance;
	private int minimap;
	private String name;
	private int saturation;
	private boolean shadowed = true;
	private int texture = -1;
	private int weightedHue;

	private final int combine(int hue, int saturation, int luminance) {
		if (luminance > 179) {
			saturation /= 2;
		}

		if (luminance > 192) {
			saturation /= 2;
		}

		if (luminance > 217) {
			saturation /= 2;
		}

		if (luminance > 243) {
			saturation /= 2;
		}

		return (hue / 4 << 10) + (saturation / 32 << 7) + luminance / 2;
	}

	public void decode(Buffer buffer) {
		do {
			int opcode = buffer.readUByte();
			if (opcode == 0) {
				return;
			}

			if (opcode == 1) {
				minimap = buffer.readUTriByte();
				rgbToHsl(minimap);
			} else if (opcode == 2) {
				texture = buffer.readUByte();
			} else if (opcode == 5) {
				shadowed = false;
			} else if (opcode == 6) {
				name = buffer.readString();
			} else if (opcode == 7) {
				int hue = this.hue;
				int saturation = this.saturation;
				int luminance = this.luminance;
				int chroma = this.weightedHue;
				int rgb = buffer.readUTriByte();
				rgbToHsl(rgb);

				this.hue = hue;
				this.saturation = saturation;
				this.luminance = luminance;
				this.weightedHue = chroma;
				this.chroma = chroma;
			} else if (opcode != 3) {
				System.out.println("Error unrecognised config code: " + opcode);
			}
		} while (true);
	}

	/**
	 * Gets the chroma.
	 *
	 * @return The chroma.
	 */
	public int getChroma() {
		return chroma;
	}

	/**
	 * Gets the colour.
	 *
	 * @return The colour.
	 */
	public int getColour() {
		return colour;
	}

	/**
	 * Gets the hue.
	 *
	 * @return The hue.
	 */
	public int getHue() {
		return hue;
	}

	/**
	 * Gets the luminance.
	 *
	 * @return The luminance.
	 */
	public int getLuminance() {
		return luminance;
	}

	/**
	 * Gets the minimap colour.
	 *
	 * @return The minimap colour.
	 */
	public int getMinimapColour() {
		return minimap;
	}

	/**
	 * Gets the name.
	 *
	 * @return The name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the saturation.
	 *
	 * @return The saturation.
	 */
	public int getSaturation() {
		return saturation;
	}

	/**
	 * Gets the texture.
	 *
	 * @return The texture.
	 */
	public int getTexture() {
		return texture;
	}

	/**
	 * Gets the weighted hue.
	 *
	 * @return The weighted hue.
	 */
	public int getWeightedHue() {
		return weightedHue;
	}

	private void rgbToHsl(int rgb) {
		double r = (rgb >> 16 & 0xff) / 256D;
		double g = (rgb >> 8 & 0xff) / 256D;
		double b = (rgb & 0xff) / 256D;
		double darkest = r;

		if (g < darkest) {
			darkest = g;
		}
		if (b < darkest) {
			darkest = b;
		}

		double lightest = r;
		if (g > lightest) {
			lightest = g;
		}
		if (b > lightest) {
			lightest = b;
		}

		double hue = 0;
		double saturation = 0;
		double lumination = (darkest + lightest) / 2;

		if (darkest != lightest) {
			if (lumination < 0.5D) {
				saturation = (lightest - darkest) / (lightest + darkest);
			}
			if (lumination >= 0.5D) {
				saturation = (lightest - darkest) / (2 - lightest - darkest);
			}
			if (r == lightest) {
				hue = (g - b) / (lightest - darkest);
			} else if (g == lightest) {
				hue = 2 + (b - r) / (lightest - darkest);
			} else if (b == lightest) {
				hue = 4 + (r - g) / (lightest - darkest);
			}
		}

		hue /= 6;
		this.hue = (int) (hue * 256);
		this.saturation = (int) (saturation * 256);
		this.luminance = (int) (lumination * 256);

		if (this.saturation < 0) {
			this.saturation = 0;
		} else if (this.saturation > 255) {
			this.saturation = 255;
		}

		if (this.luminance < 0) {
			this.luminance = 0;
		} else if (this.luminance > 255) {
			this.luminance = 255;
		}

		if (lumination > 0.5D) {
			chroma = (int) ((1 - lumination) * saturation * 512);
		} else {
			chroma = (int) (lumination * saturation * 512);
		}
		if (chroma < 1) {
			chroma = 1;
		}

		weightedHue = (int) (hue * chroma);
		int h = this.hue + (int) (Math.random() * 16) - 8;
		if (h < 0) {
			h = 0;
		} else if (h > 255) {
			h = 255;
		}

		int s = this.saturation + (int) (Math.random() * 48) - 24;
		if (s < 0) {
			s = 0;
		} else if (s > 255) {
			s = 255;
		}

		int l = this.luminance + (int) (Math.random() * 48) - 24;
		if (l < 0) {
			l = 0;
		} else if (l > 255) {
			l = 255;
		}

		colour = combine(h, s, l);
	}

	/**
	 * Gets the shadowing flag.
	 *
	 * @return The shadowing flag.
	 */
	public boolean shadowed() {
		return shadowed;
	}

}