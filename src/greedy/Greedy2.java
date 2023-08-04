package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * 만약, 여러 개의 회의가 주어졌을 때 겹치지 않는 회의들의 최대 갯수를 구합니다.
 * 회의들은 시작과 끝 시간이 주어지며, 한 회의가 끝난다면 바로 다음 회의를 시작할 수 있습니다.
 */
public class Greedy2 {

    public static int maxMeeting(List<Meeting> meetings) {
        /**
         * 종료 시간을 기준으로 회의들을 오름차순으로 정렬합니다.
         */
        meetings.sort(Comparator.comparingInt(Meeting::getEnd));

        int count = 1; // 첫 번째 회의는 무조건 선택되었다는 가정 하 count를 1부터 시작합니다.
        int endTime = meetings.get(0).getEnd();

        /**
         * 첫 번째 회의는 무조건 선택되었으니 다음 회의들을 하나씩 가져오며 비교합니다.
         * 만약 다음 회의가 개최될 수 있는 조건이 충족되었다면 count에 1을 더하고
         * endTime을 개최된 회의의 종료시간으로 바꿉니다.
         */
        for (int i = 1; i < meetings.size(); i++) {
            Meeting current = meetings.get(i);
            if (current.getStart() >= endTime) {
                count++;
                endTime = current.getEnd();
            }
        }

        /**
         * 모든 연산이 끝나면 총 몇 개의 회의가 진행 가능한지 반환합니다.
         */
        return count;
    }

    public static void main(String[] args) {
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(1, 5));
        meetings.add(new Meeting(2, 6));
        meetings.add(new Meeting(5, 7));
        meetings.add(new Meeting(6, 9));
        meetings.add(new Meeting(8, 10));
        meetings.add(new Meeting(9, 11));

        int result = maxMeeting(meetings);
        System.out.println("Max meeting count is : " + result);
    }
}
