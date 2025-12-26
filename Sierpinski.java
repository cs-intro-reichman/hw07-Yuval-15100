/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {

	StdDraw.setCanvasSize(800, 800);

	double x1 = 0.0; double y1 = 0.0;
	double x2 = 1.0; double y2 = 0.0;
	double x3 = 0.5; double y3 = Math.sqrt(3) / 2;

	StdDraw.setPenColor(StdDraw.BLACK);
	StdDraw.line(x1, y1, x2, y2);
	StdDraw.line(x2, y2, x3, y3);
	StdDraw.line(x3, y3, x1, y1);

	if (n > 1) {
		sierpinski(n - 1, x1, x2, x3, y1, y2, y3); }

	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {

	if (n == 0) {
		return; }

	double leftLineX = (x1 + x3) / 2;
	double leftLineY = (y1 + y3) / 2;
	double rightLineX = (x2 + x3) / 2;
	double rightLineY = (y2 + y3) / 2;
	double underLineX = (x1 + x2) / 2;
	double underLineY = (y1 + y2) / 2;

	StdDraw.setPenColor(StdDraw.BLACK);
	StdDraw.line(leftLineX, leftLineY, rightLineX, rightLineY);
    StdDraw.line(rightLineX, rightLineY, underLineX, underLineY);
    StdDraw.line(underLineX, underLineY, leftLineX, leftLineY);

	sierpinski(n - 1, leftLineX, rightLineX, x3, leftLineY, rightLineY, y3);
	sierpinski(n - 1, leftLineX, underLineX, x1, leftLineY, underLineY, y1);
	sierpinski(n - 1, underLineX, rightLineX, x2, underLineY, rightLineY, y2);

	}
}
