package com.jagex.cache.anim;

import com.jagex.io.Buffer;

public class FrameBase {

	/**
	 * The amount of transformations.
	 */
	private int count;
	private int[][] labels;

	/**
	 * The type of each transformation.
	 */
	private int[] transformationType;

	public FrameBase(Buffer buffer) {
		count = buffer.readUByte();
		transformationType = new int[count];
		labels = new int[count][];
		for (int index = 0; index < count; index++) {
			transformationType[index] = buffer.readUByte();
		}

		for (int label = 0; label < count; label++) {
			int count = buffer.readUByte();
			labels[label] = new int[count];

			for (int index = 0; index < count; index++) {
				labels[label][index] = buffer.readUByte();
			}
		}
	}

	public int[] getLabels(int label) {
		return labels[label];
	}

	/**
	 * Gets the amount of transformations in this FrameBase.
	 * 
	 * @return The amount of transformations.
	 */
	public int getTransformationCount() {
		return count;
	}

	/**
	 * Gets the transformation type of the transformation at the specified index.
	 * 
	 * @param index The index.
	 * @return The transformation type.
	 */
	public int getTransformationType(int index) {
		return transformationType[index];
	}

}