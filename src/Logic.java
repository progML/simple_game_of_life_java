public class Logic {

    private static final int[] DELTA = new int[]{-1, 0, 1};


    /** Проверка для каждой из клеток следующего условия:
     * а) если на шаге t-1 она была пустой, но были заполнены три соседние клетки или
     * б) если на шаге t-1 она была заполнена и были заполнены две или три соседние клетки
     *
     * @param map двумерный массив, клетки которого необходимо проверить.
     * @param i первый индекс двумерного массива.
     * @param j второй индекс двумерного массива.
     *
     * @return возврощает результат проверки.
     */
    protected boolean checkRulesAndSetResult(boolean[][]map, int i, int j){
        int neighbors = countNeighbors(map, i, j);
        return (map[i][j] && (neighbors == 2 || neighbors == 3))
                || (!map[i][j] && (neighbors == 3));
    }


    /** Подсчет количества соседей для каждой из клеток.
     * @param map двумерный массив, клетки которого необходимо проверить.
     * @param i первый индекс двумерного массива.
     * @param j второй индекс двумерного массива.
     *
     * @return возврощает количесто соседей для каждой из клеток.
     */
    protected int countNeighbors(boolean[][] map, int i, int j) {
        int count = 0;
        for (int k : DELTA) {
            for (int y : DELTA) {
                if ((k == 0 && y == 0) || !checkConfines(i + k, j + y, map.length)) continue;

                if (map[i + k][j + y]) {
                    count++;
                    if (count == 4) break;
                }
            }
        }
        return count;
    }


    /** Проверка границ поля.
     * @param i первый индекс двумерного массива.
     * @param j второй индекс двумерного массива.
     * @param length размер поля.
     *
     * @return возврощает результат проверки.
     */
    private static boolean checkConfines(int i, int j, int length) {
        return i >= 0 && i < length && j >= 0 && j < length;
    }

}
