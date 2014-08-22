package jrt.jrt;

public class Renderer {
	private int imgWidth;
	private int imgHeight;
	private int renderTask;
	
	/**
	 * Renders an imgWidth by imgHeight pixel image of a given render task.
	 * @param imgWidth image pixel width
	 * @param imgHeight image pixel height
	 * @param renderTask render task identifier
	 */
	public Renderer(int imgWidth, int imgHeight, int renderTask) {
		this.imgHeight = imgHeight;
		this.imgWidth = imgWidth;
		this.renderTask = renderTask;
	}
}
