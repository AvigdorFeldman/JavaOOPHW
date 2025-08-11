package images;

public class Func1 implements TwoDFunc {
	// The class implements interface TwoDFunc, it implements function f
	@Override
	public double f(double x, double y) {
		// This function implements method f from TwoDfunc
			if (x < 0.25)
				return 0;
			if (y < 0.25)
				return 1;
		return (x + y) / 2;
	}
}

