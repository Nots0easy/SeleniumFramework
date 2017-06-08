package triangle;

public class RightTriangle {

    public static final double EPSILON = 0.000001;

    private double side1;
    private double side2;
    private double hypotenuse;
    private double area;
    private double perimeter;

    private RightTriangle(Double side1, Double side2, Double hypotenuse) {
        this.side1 = side1;
        this.side2 = side2;
        this.hypotenuse = hypotenuse;
        this.area = (side1 * side2) / 2;
        this.perimeter = side1 + side2 + hypotenuse;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getHypotenuse() {
        return hypotenuse;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public static RightTriangleBuilder newInstance() {
        return new RightTriangleBuilder();
    }

    public static class RightTriangleBuilder {

        private Double side1;
        private Double side2;
        private Double hypotenuse;

        private RightTriangleBuilder() {

        }

        public RightTriangleBuilder withSide1(double side1) {
            this.side1 = side1;
            return this;
        }

        public RightTriangleBuilder withSide2(double side2) {
            this.side2 = side2;
            return this;
        }

        public RightTriangleBuilder withHypotenuse(double hypotenuse) {
            this.hypotenuse = hypotenuse;
            return this;
        }

        public RightTriangle build() {

            if (isDefined()) {
                verify();
                return new RightTriangle(side1, side2, hypotenuse);
            }

            if (isPartiallyDefined()) {

                if (side1 == null) {
                    side1 = getSideViaPythagoreanTheorem(side2, hypotenuse);
                } else if (side2 == null) {
                    side2 = getSideViaPythagoreanTheorem(side1, hypotenuse);
                } else if (hypotenuse == null) {
                    hypotenuse = getHypotenuseViaPythagoreanTheorem(side1, side2);
                }

                return new RightTriangle(side1, side2, hypotenuse);
            }

            throw new ArithmeticException(String.format(
                    "Minimum two sides must be defined: side1=%s, side2=%s, hypotenuse=%s", side1, side2, hypotenuse));
        }

        // Verify that all sides are defined
        private Boolean isDefined() {
            return !(side1 == null || side2 == null || hypotenuse == null);
        }

        // Verify that two sides of three are defined
        private Boolean isPartiallyDefined() {
            return !((side1 == null && side2 == null) || (side1 == null && hypotenuse == null)
                    || (hypotenuse == null && side2 == null));
        }

        // Verify that all sides has the positive values
        private void verify() {

            // Verify that all sides has the positive values
            if (side1 <= 0 || side2 <= 0 || hypotenuse <= 0) {
                throw new ArithmeticException(
                        String.format("All sides must have the positive values: side1=%s, side2=%s, hypotenuse=%s",
                                side1, side2, hypotenuse));
            }

            // Verify that a triangle is valid
            if ((side1 + side2 - hypotenuse) <= EPSILON || (side1 - side2 + hypotenuse) <= EPSILON
                    || (-side1 + side2 + hypotenuse) <= EPSILON) {
                throw new ArithmeticException(String.format("Triangle is not valid: side1=%s, side2=%s, hypotenuse=%s",
                        side1, side2, hypotenuse));
            }

            // Verify that a triangle is right
            double x = pow2(side1) + pow2(side2);
            double y = pow2(hypotenuse);
            if (!(x < y + EPSILON && x > y - EPSILON)) {
                throw new ArithmeticException(String.format("Triangle is not right: side1=%s, side2=%s, hypotenuse=%s",
                        side1, side2, hypotenuse));
            }
        }

        private Double getSideViaPythagoreanTheorem(Double side, Double hypotenuse) {
            return Math.sqrt(pow2(hypotenuse) - pow2(side));
        }

        private Double getHypotenuseViaPythagoreanTheorem(Double side1, Double side2) {
            return Math.sqrt(pow2(side1) + pow2(side2));
        }

        private double pow2(double num) {
            return Math.pow(num, 2);
        }
    }

}
