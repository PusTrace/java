public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Необходимо как минимум 2 аргумента - X и Y!");
        }
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        if (y < x + 3) {
            // Ниже прямой
            if (25 > Math.pow(x - 6, 2) + Math.pow(y - 6, 2)) {
                // Внутри окружности
                if ((x > 3) && (x < 9) && (y > 1) && (y < 8)) {
                    // Внутри прямоугольника
                    System.out.println(3);
                } else {
                    // Вне прямоугольника
                    System.out.println(4);
                }
            } else {
                // Вне окружности
                if ((x > 3) && (x < 9) && (y > 1) && (y < 8)) {
                    // Внутри прямоугольника
                    System.out.println(2);
                } else {
                    // Вне прямоугольника
                    System.out.println(1);
                }
            }
        } else {
            // Выше прямой
            if (25 > Math.pow(x - 6, 2) + Math.pow(y - 6, 2)) {
                // Внутри окружности
                if ((x > 3) && (x < 9) && (y > 1) && (y < 8)) {
                    // Внутри прямоугольника
                    System.out.println(7);
                } else {
                    // Вне прямоугольника
                    System.out.println(6);
                }
            } else {
                // Вне окружности
                if ((x > 3) && (x < 9) && (y > 1) && (y < 8)) {
                    // Внутри прямоугольника
                    System.out.println("x & y have error");
                } else {
                    // Вне прямоугольника
                    System.out.println(5);
                }
            }
        }
    }

}
