class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int total = 0;

        for (int y = 1971; y < year; y++) {
            total += isLeap(y) ? 366 : 365;
        }

        for (int m = 0; m < month - 1; m++) {
            total += daysInMonth[m];
            if (m == 1 && isLeap(year)) {
                total++;
            }
        }

        total += day - 1;

        return days[(5 + total) % 7];
    }

    private boolean isLeap(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}