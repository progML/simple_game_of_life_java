public class Grid extends Cell {

    private static final int[] coords = {3, 8, 4, 7, 5, 7, 5, 8, 5, 9, 10, 7, 10, 8, 10, 9, 11, 7, 12, 8, 3, 2, 4, 3, 5, 1, 5, 2, 5, 3, 9, 1, 9, 2, 9, 3, 10, 3, 11, 2};
    private static final int MAP_SIZE = 15;
    private final boolean[][] map = new boolean[MAP_SIZE][MAP_SIZE];


    /** Инициализация поля, преобразование одномерного массива в двумерный и вывод инициализированного поля на экран.
     *
     * @return возврощает двумерный массив.
     */
    protected boolean[][] initGrid() {
        for (int i = 1; i < coords.length; i += 2) {
            setNewState(map, coords[i-1], coords[i]);
        }
        printGrid(map);
        return map;
    }

    /** Обновления данных после шага t, вывод полученного двумерного массива на экран.
     * @param map двумерный массив, полученный после шага t.
     *
     * @return возврощает двумерный массив.
     */
    protected boolean[][] updateGrid(boolean[][] map) {
        Logic logic = new Logic();
        boolean[][] updateGridCell = new boolean[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                updateGridCell[i][j] = logic.checkRulesAndSetResult(map, i, j);
            }
        }
        printGrid(updateGridCell);
        return updateGridCell;
    }

    /** Вывод двумерного массива в терминальное окно.
     * @param map двумерный массив, который необходимо вывести на экран.
     *
     */
    protected void printGrid(boolean[][] map) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(setDataCell(map, i, j));
            }
            System.out.println();
        }
        System.out.println();
    }

}
